package zone.gagarin.todolist.entity;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "tasks")
public class Task extends RepresentationModel<Task> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  @NotNull
  private String title;

  @Column(name = "description")
  @NotNull
  private String description;

  @Column(name = "date_time_of_creation")
  private LocalDateTime dateAndTimeOfCreation;

  @Column(name = "completed")
  private boolean isCompleted;

  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_task_id",referencedColumnName = "id")
  private Task taskParent;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "taskParent")
  private List<Task> subtasks;

  public void addSubtask(Task task) {
    task.setTaskParent(this);
    subtasks.add(task);
  }

  public void deleteSubtask(Task task) {
    subtasks.remove(task);
  }

  public Task() {
    this.dateAndTimeOfCreation = LocalDateTime.now();
  }

  public Task(String title, String description) {
    this.title = title;
    this.description = description;
    this.dateAndTimeOfCreation = LocalDateTime.now();
    this.subtasks = new CopyOnWriteArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getDateAndTimeOfCreation() {
    return dateAndTimeOfCreation;
  }

  public void setDateAndTimeOfCreation(LocalDateTime dateAndTimeOfCreation) {
    this.dateAndTimeOfCreation = dateAndTimeOfCreation;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

  public List<Task> getSubtasks() {
    return subtasks;
  }

  public void setSubtasks(List<Task> subtasks) {
    this.subtasks = subtasks;
  }

  public Task getTaskParent() {
    return taskParent;
  }

  public void setTaskParent(Task taskParent) {
    this.taskParent = taskParent;
  }

  @Override
  public String toString() {
    return "Task{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", dateAndTimeOfCreation=" + dateAndTimeOfCreation +
        ", isCompleted=" + isCompleted +
        '}';
  }
}
