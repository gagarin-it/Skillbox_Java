package zone.gagarin.todolist.service;

import zone.gagarin.todolist.model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
  private static final AtomicInteger TASK_ID = new AtomicInteger(1);
  private static final HashMap<Integer, Task> TASK_MAP = new HashMap<>();

  public static List<Task> getAllTasks(){
    return new ArrayList<>(TASK_MAP.values());
  }

  public static int addTask (Task task) {
    int id = TASK_ID.incrementAndGet();
    task.setId(id);
    TASK_MAP.put(id, task);
    return id;
  }

  public static List<Task> deletingAllTasks(){
    TASK_MAP.clear();
    return new ArrayList<>(TASK_MAP.values());
  }

  public static Task getTask(int taskId) {
    if(TASK_MAP.containsKey(taskId)){
      return TASK_MAP.get(taskId);
    }
    return null;
  }

  public static void deletingTask(int taskId) {
    if(TASK_MAP.containsKey(taskId)){
      TASK_MAP.remove(taskId);
    }
  }



}
