package entities;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
public class Subscription {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscription_date")
  private LocalDateTime subscriptionDate;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Student student;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Course course;

  public LocalDateTime getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(LocalDateTime subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

}
