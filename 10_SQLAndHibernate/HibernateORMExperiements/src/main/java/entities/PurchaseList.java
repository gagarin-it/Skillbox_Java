package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "student_name")
  private String studentName;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "course_name")
  private String courseName;

  private int price;

  @Column(name = "subscription_date")
  private LocalDateTime subscriptionDate;

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public LocalDateTime getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(LocalDateTime subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }
}
