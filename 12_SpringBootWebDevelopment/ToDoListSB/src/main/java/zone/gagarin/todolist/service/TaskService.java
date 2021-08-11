package zone.gagarin.todolist.service;

import java.util.List;
import zone.gagarin.todolist.entity.Task;

public interface TaskService {

  List<Task> findAll();

  List<Task> findAllByParentTask(Long idParent);

  Task findById(Long id);

  void save(Task task);

  void deleteById(Long id);

  void deleteAll();

  Task addNewSubtask(Long idParent, Task subtask);

  void deleteSubtask(Long id);

}
