package zone.gagarin.todolist.entity;

import javax.persistence.*;

@Entity
@Table(name = "subtasks")
public class Subtask {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private String description;

  @ManyToOne
  @JoinColumn(name = "task_id")
  private Task task;

  public Subtask() {
  }

  public Subtask(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }
}
