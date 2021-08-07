package zone.gagarin.todolist.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "date_time_of_creation")
  private LocalDateTime dateAndTimeOfCreation;

  @Column(name = "completed")
  private boolean isCompleted;

  public Task() {
    this.dateAndTimeOfCreation = LocalDateTime.now();
  }

  public Task(String title, String description) {
    this.title = title;
    this.description = description;
    this.dateAndTimeOfCreation = LocalDateTime.now();
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
