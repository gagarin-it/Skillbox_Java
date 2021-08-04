package zone.gagarin.todolist.controller;

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
import zone.gagarin.todolist.entity.Subtask;
import zone.gagarin.todolist.entity.Task;
import zone.gagarin.todolist.service.SubtaskService;
import zone.gagarin.todolist.service.TaskService;

@RestController
@RequestMapping("/todolist")
public class RESTController {

  private final TaskService taskService;

  private final SubtaskService subtaskService;

  @Autowired
  public RESTController(TaskService taskService, SubtaskService subtaskService) {
    this.taskService = taskService;
    this.subtaskService = subtaskService;
  }

  @GetMapping("/tasks")
  public List<Task> getAllTasks(){
    return taskService.findAll();
  }

  @GetMapping("/tasks/{id}")
  public Task getTaskById(@PathVariable Long id){
    Task task = taskService.findById(id);
    return task;
  }

  @GetMapping("/tasks/{id}/subtasks")
  public List<Subtask> getAllSubtask(@PathVariable Long id){
    Task task = taskService.findById(id);
    return subtaskService.findAllByTask(task);
  }

  @GetMapping("/tasks/{idTask}/subtasks/{idSubtask}")
  public Subtask getSubtaskById(@PathVariable Long idSubtask, @PathVariable Long idTask){
    Task task = taskService.findById(idTask);
    List<Subtask> subtasks = task.getSubtasks();
    Subtask subtask = subtaskService.findById(idSubtask);
    if(subtasks.contains(subtask)){
      return subtask;
    }
    return null;
  }

  @PostMapping("/tasks")
  public Task addNewTask(@RequestBody Task task){
    taskService.save(task);
    return task;
  }

  @PostMapping("/tasks/{id}")
  public Subtask addNewSubtask(@RequestBody Subtask subtask,@PathVariable Long id){
    List<Subtask> subtasks = taskService.findById(id).getSubtasks();
    subtasks.add(subtask);
    taskService.findById(id).setSubtasks(subtasks);
    subtaskService.save(subtask);
    return subtask;
  }

  @PutMapping("/tasks/{id}")
  public Task updateTask(@RequestBody Task task,@PathVariable Long id){
    id = task.getId();
    taskService.save(task);
    return task;
  }

  @PutMapping("/tasks")
  public ResponseEntity updateAllTasks() {
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
  }

  @DeleteMapping("/tasks/{id}")
  public void deleteTaskById(@PathVariable Long id) {
        taskService.deleteById(id);
  }

  @DeleteMapping("/tasks")
  public void deleteAllTasks(){
    List<Task> tasks = taskService.findAll();
    tasks.forEach(t -> taskService.deleteById(t.getId()));
  }









}
