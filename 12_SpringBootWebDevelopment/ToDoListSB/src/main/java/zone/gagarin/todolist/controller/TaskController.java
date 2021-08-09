package zone.gagarin.todolist.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zone.gagarin.todolist.entity.Task;
import zone.gagarin.todolist.service.TaskService;

@RestController
@RequestMapping("/todolist")
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/tasks")
  public ResponseEntity<List<Task>> getAllTasks() {
    List<Task> tasks = taskService.findAll();
    if (tasks.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    tasks.forEach(task -> {
      task.add(linkTo(methodOn(TaskController.class)
          .getTaskById(task.getId()))
          .withSelfRel());
    });
    return ResponseEntity.status(HttpStatus.OK).body(tasks);
  }

  @GetMapping("/tasks/{id}")
  public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
    Task task = taskService.findById(id);
    if (task == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    task.add(linkTo(methodOn(TaskController.class)
        .getTaskById(task.getId()))
        .withSelfRel());
    return ResponseEntity.status(HttpStatus.OK).body(task);
  }

  @PostMapping("/tasks")
  public ResponseEntity<Task> addNewTask(@RequestBody Task task) {
  taskService.save(task);
  return ResponseEntity.status(HttpStatus.CREATED).body(task);
  }

  @PostMapping("/tasks/{id}")
  public ResponseEntity<Object> addNewSubtask(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
  }

  @PutMapping("/tasks/{id}")
  public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Long id) {
    Task taskUpdate = taskService.findById(id);
    if (taskUpdate == null) {
      taskService.save(task);
      return ResponseEntity.status(HttpStatus.CREATED).body(task);
    } else {
      taskUpdate.setId(id);
      taskUpdate.setTitle(task.getTitle());
      taskUpdate.setDescription(task.getDescription());
      taskUpdate.setCompleted(task.isCompleted());
      taskUpdate.setDateAndTimeOfCreation(task.getDateAndTimeOfCreation());
      taskService.save(taskUpdate);
      return ResponseEntity.status(HttpStatus.OK).body(taskUpdate);
    }
  }

  @PutMapping("/tasks")
  public ResponseEntity<Object> updateAllTasks() {
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
  }

  @DeleteMapping("/tasks/{id}")
  public ResponseEntity<String> deleteTaskById(@PathVariable Long id) {
    Task task = taskService.findById(id);
    taskService.deleteById(id);
    return task == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        : ResponseEntity.status(HttpStatus.OK).body("Deleting Task by ID = " + id);
  }

  @DeleteMapping("/tasks")
  public ResponseEntity<String> deleteAllTasks() {
    List<Task> tasks = taskService.findAll();
    tasks.forEach(t -> taskService.deleteById(t.getId()));
    return tasks.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        : ResponseEntity.status(HttpStatus.OK).body("Deleting All Tasks");
  }
}
