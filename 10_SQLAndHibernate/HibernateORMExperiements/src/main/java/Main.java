import entities.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  public static void main(String[] args) {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    String hqlCourses =
        "From " + Course.class.getSimpleName();
    List<Course> courses = session.createQuery(hqlCourses).getResultList();
    Map<String, Integer> mapCourses =
        courses.stream().collect(Collectors.toMap(Course::getName, Course::getId));

    String hqlStudents =
        "From " + Student.class.getSimpleName();
    List<Student> students = session.createQuery(hqlStudents).getResultList();
    Map<String, Integer> mapStudents =
        students.stream().collect(Collectors.toMap(Student::getName, Student::getId));

    String hqlPurchaseList =
        "From " + PurchaseList.class.getSimpleName();
    List<PurchaseList> purchaseList = session.createQuery(hqlPurchaseList).getResultList();

    for (PurchaseList pl : purchaseList){
      LinkedPurchaseList linkedPurchase = new LinkedPurchaseList();
      linkedPurchase.setStudentId(mapStudents.get(pl.getStudentName()));
      linkedPurchase.setCourseId(mapCourses.get(pl.getCourseName()));
      session.save(linkedPurchase);
    }

    transaction.commit();
    sessionFactory.close();
  }

}