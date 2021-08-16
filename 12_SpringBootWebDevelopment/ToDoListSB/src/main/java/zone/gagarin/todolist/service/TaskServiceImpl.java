package zone.gagarin.todolist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.gagarin.todolist.repository.TaskRepository;
import zone.gagarin.todolist.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  @Autowired
  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public List<Task> findAll() {
    return taskRepository.findAll().stream().filter(task -> task.getParentTask() == null)
        .collect(Collectors.toList());
  }

  @Override
  public List<Task> findAllByParentTask(Long idParent) {
    Optional<Task> optionalParentTask = taskRepository.findById(idParent);
    if (optionalParentTask.isPresent()) {
      Task parentTask = optionalParentTask.get();
      return parentTask.getSubtasks();
    }
    return new ArrayList<>();
  }

  @Override
  public Task addNewSubtask(Long idParent, Task subtask) {
    Optional<Task> optionalParentTask = taskRepository.findById(idParent);
    if (optionalParentTask.isPresent()) {
      Task parentTask = optionalParentTask.get();
      subtask.setParentTask(parentTask);
      parentTask.addSubtask(taskRepository.save(subtask));
      taskRepository.save(parentTask);
      return subtask;
    }
    return null;
  }

  @Override
  public Task findById(Long id) {
    Task task = null;
    Optional<Task> optional = taskRepository.findById(id);
    if (optional.isPresent()) {
      task = optional.get();
    }
    return task;
  }

  @Override
  public void save(Task task) {
    taskRepository.save(task);
  }

  @Override
  public void deleteById(Long id) {
    taskRepository.deleteById(id);
  }

  @Override
  public void deleteAll() {
    taskRepository.deleteAll();
  }
}
