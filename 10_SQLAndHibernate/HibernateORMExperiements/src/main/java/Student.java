import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private int age;
  @Temporal(TemporalType.DATE)
  @Column(name = "registration_date", columnDefinition = "datetime")
  private Date registrationDate;

  @Override
  public String toString() {
    return id + ") " + name + ". Возраст: " + age + ". Дата регистрации: " + registrationDate;
  }
}
