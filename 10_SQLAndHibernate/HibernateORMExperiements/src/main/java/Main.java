import static org.hibernate.id.PersistentIdentifierGenerator.PK;

import entities.Course;
import entities.PurchaseList;
import entities.Subscription;
import java.util.List;
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

    String hql =
        "From " + PurchaseList.class.getSimpleName() + " Where price > 120000" + " Order by price desc";
    List<PurchaseList> pl = session.createQuery(hql).getResultList();
    pl.stream().map(p -> p.getCourseName() + " - " + p.getStudentName())
        .forEach(System.out::println);

    transaction.commit();
    sessionFactory.close();
  }

}