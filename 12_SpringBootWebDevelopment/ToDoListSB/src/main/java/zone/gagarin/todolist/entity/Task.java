package zone.gagarin.todolist.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private String description;

  @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
  private Set<Subtask> subtasks;

  public Task() {
  }

  public Task(String name, String description) {
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

  public Set<Subtask> getSubtasks() {
    return subtasks;
  }

  public void setSubtasks(Set<Subtask> subtasks) {
    this.subtasks = subtasks;
  }

}
