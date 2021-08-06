package zone.gagarin.todolist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zone.gagarin.todolist.entity.Task;
import zone.gagarin.todolist.service.TaskService;

@RestController
@RequestMapping("/todolist")
public class RESTController {

  private final TaskService taskService;

  @Autowired
  public RESTController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/tasks")
  public List<Task> getAllTasks() {
    return taskService.findAll();
  }

  @GetMapping("/tasks/{id}")
  public Task getTaskById(@PathVariable Long id) {
    return taskService.findById(id);
  }

  @PostMapping("/tasks")
  public Task addNewTask(@RequestBody Task task) {
    taskService.save(task);
    return task;
  }

  @PostMapping("/tasks/{id}")
  public ResponseEntity<Object> addNewSubtask(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
  }

  @PutMapping("/tasks/{id}")
  public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Long id) {
    Task taskUpdate = taskService.findById(id);
    if(taskUpdate == null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    taskUpdate.setId(id);
    taskUpdate.setTitle(task.getTitle());
    taskUpdate.setDescription(task.getDescription());
    taskUpdate.setCompleted(task.isCompleted());
    taskUpdate.setDateAndTimeOfCreation(task.getDateAndTimeOfCreation());
    taskService.save(taskUpdate);
    return ResponseEntity.status(HttpStatus.OK).body(taskUpdate);
  }

  @PutMapping("/tasks")
  public ResponseEntity<Object> updateAllTasks() {
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
  }

  @DeleteMapping("/tasks/{id}")
  public String deleteTaskById(@PathVariable Long id) {
    taskService.deleteById(id);
    return "Deleting Task by ID = " + id;
  }

  @DeleteMapping("/tasks")
  public void deleteAllTasks() {
    List<Task> tasks = taskService.findAll();
    tasks.forEach(t -> taskService.deleteById(t.getId()));
  }
}
