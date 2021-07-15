package zone.gagarin.todolist.service;

import zone.gagarin.todolist.model.Task;
import java.util.List;
import java.util.Map;

public interface TaskService {
  List<Task> getAll();

  void create(Task task);

  Task get(int taskId);

  boolean update(Task task, int taskId);
  
  boolean update(Map<Integer, Task> tasks);

  boolean delete(int taskId);

  boolean clearAll();

}
