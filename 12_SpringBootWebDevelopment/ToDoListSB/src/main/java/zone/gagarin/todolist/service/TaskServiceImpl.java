package zone.gagarin.todolist.service;

import zone.gagarin.todolist.model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

  private static final Map<Integer, Task> TASKS_MAP = new HashMap<>();
  private static final AtomicInteger TASK_ID = new AtomicInteger(1);

  @Override
  public List<Task> getAll() {
    return new ArrayList<>(TASKS_MAP.values());
  }

  @Override
  public void create(Task task) {
    final int taskId = TASK_ID.incrementAndGet();
    task.setId(taskId);
    TASKS_MAP.put(taskId, task);
  }

  @Override
  public Task get(int taskId) {
    if (TASKS_MAP.containsKey(taskId)) {
      return TASKS_MAP.get(taskId);
    }
    return null;
  }

  @Override
  public boolean update(Task task, int taskId) {
    if (TASKS_MAP.containsKey(taskId)) {
      task.setId(taskId);
      TASKS_MAP.put(taskId, task);
      return true;
    }
    return false;
  }

  @Override
  public boolean update(Map<Integer, Task> tasks) {
    TASKS_MAP.clear();
    TASKS_MAP.putAll(tasks);
    if(TASKS_MAP.equals(tasks)){
      return true;
    }
    return false;
  }

  @Override
  public boolean delete(int taskId) {
    return TASKS_MAP.remove(taskId) != null;
  }

  @Override
  public boolean clearAll() {
    TASKS_MAP.clear();
    if (TASKS_MAP.isEmpty()){
      return true;
    }
    return false;
  }


}
