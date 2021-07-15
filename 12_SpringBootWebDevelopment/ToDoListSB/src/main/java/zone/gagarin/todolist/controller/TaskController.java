package zone.gagarin.todolist.controller;

import zone.gagarin.todolist.repository.TaskRepository;
import zone.gagarin.todolist.service.Storage;
import zone.gagarin.todolist.model.Task;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  private TaskRepository taskRepository;

  @GetMapping("/tasks")
  public List<Task> getAllTasks(){
      return Storage.getAllTasks();
  }

  @PostMapping("/tasks")
  public int addTask (Task task) {
    return Storage.addTask(task);
  }

  @DeleteMapping("/tasks")
  public ResponseEntity deletingAllTasks() {
    if(Storage.deletingAllTasks().isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
  }

  @GetMapping("/tasks/{taskId}")
  public ResponseEntity getTask(@PathVariable int taskId) {
    Task task = Storage.getTask(taskId);
    if(task == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return new ResponseEntity(task, HttpStatus.OK);
  }

  @DeleteMapping("/tasks/{taskId}")
  public ResponseEntity deletingTask(@PathVariable int taskId) {
    Task task = Storage.getTask(taskId);
    if(task == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    Storage.deletingTask(taskId);
    return new ResponseEntity(taskId, HttpStatus.OK);
  }

}
