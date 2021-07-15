package zone.gagarin.todolist;

import zone.gagarin.todolist.model.Task;
import zone.gagarin.todolist.service.Storage;
import zone.gagarin.todolist.model.Subtask;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListApplication {

  public static void main(String[] args) {

    Task task1 = new Task();
    task1.setName("First task");
    task1.setDescription("List market-place");
    task1.setId(1);
    Map<Integer, Subtask> list = new HashMap<>();
    Subtask subtask1 = new Subtask();
    subtask1.setId(1);
    subtask1.setName("First subtask");
    subtask1.setDescription("Buy milk");
    list.put(1, subtask1);
    Subtask subtask2 = new Subtask();
    subtask2.setId(2);
    subtask2.setName("Second subtask");
    subtask2.setDescription("Buy meat and potatoes");
    list.put(1, subtask2);
    task1.setSubtaskMap(list);

    Task task2 = new Task();
    task2.setName("Second task");
    task2.setDescription("List java study");
    task2.setId(2);

    Storage.addTask(task1);
    Storage.addTask(task2);

    SpringApplication.run(ToDoListApplication.class, args);
  }

}
