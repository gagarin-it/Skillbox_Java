package zone.gagarin.todolist.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.gagarin.todolist.dao.TaskRepository;
import zone.gagarin.todolist.entity.Task;

@Service
public class TaskServiceImpl implements TaskService{

  private final TaskRepository taskRepository;

  @Autowired
  public TaskServiceImpl(TaskRepository taskRepository){
    this.taskRepository = taskRepository;
  }

  @Override
  public List<Task> findAll() {
    return taskRepository.findAll();
  }

  @Override
  public Task findById(Long id) {
    Task task = null;
    Optional<Task> optional = taskRepository.findById(id);
    if(optional.isPresent()){
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
    List<Task> tasks = taskRepository.findAll();
    tasks.forEach(task -> taskRepository.deleteById(task.getId()));

  }
}
