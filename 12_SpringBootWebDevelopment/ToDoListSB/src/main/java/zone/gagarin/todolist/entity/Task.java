package zone.gagarin.todolist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import org.springframework.lang.Nullable;

@Entity
@Table(name = "tasks")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
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

//  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//  @JoinColumn(name = "user_id")
//  private User user;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parentTask")
  @JsonBackReference
  private List<Task> subtasks;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "parent_task_id")
  @Nullable
  private Task parentTask;

  public void addSubtask(@NotNull Task task) {
    subtasks.add(task);
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

  @Nullable
  public Task getParentTask() {
    return parentTask;
  }

  public void setParentTask(@Nullable Task parentTask) {
    this.parentTask = parentTask;
  }

//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }

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
