import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

  private static final String URL_MYSQL = "jdbc:mysql://127.0.0.1:3306/skillbox";
  private static final String USER_MYSQL = "user";
  private static final String PASSWORD_MYSQL = "test";

  public static void main(String[] args) {
    try {
      Connection connection = DriverManager.getConnection(URL_MYSQL, USER_MYSQL, PASSWORD_MYSQL);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(
          "SELECT pl.course_name, (count(month(pl.subscription_date))/max(month(pl.subscription_date))) as "
              + "average_of_count_buy FROM PurchaseList pl group by pl.course_name order by pl.course_name");
      int courseId = 0;
      System.out
          .printf("     %-35s%-16s%n", "Наименование курса",
              "Среднее количество покупок");
      while (resultSet.next()) {
        courseId++;
        String courseName = resultSet.getString(1);
        double averageOfCountBuy = resultSet.getDouble(2);
        System.out
            .printf("%3d) %-35s%.2f шт. в месяц%n", courseId, courseName, averageOfCountBuy);
      }
      resultSet.close();
      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}