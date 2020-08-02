import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DayOfWeekOnBirthday {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Введите день Вашего рождения: ");
    int day = Integer.parseInt(reader.readLine());
    System.out.println("Введите месяц Вашего рождения: ");
    int month = Integer.parseInt(reader.readLine());
    System.out.println("Введите год Вашего рождения: ");
    int year = Integer.parseInt(reader.readLine());

    Calendar dateNow = new GregorianCalendar();
    Calendar dateBorn = new GregorianCalendar(year, month - 1, day);
    DateFormat dateFormat = new SimpleDateFormat(" - dd.MM.YYYY - EEEE");
    int differenceYear = dateNow.get(Calendar.YEAR) - dateBorn.get(Calendar.YEAR);

    if (dateBorn.get(Calendar.YEAR) > dateNow.get(Calendar.YEAR)) {
      System.err.println("Вы ввели год, превышающий текущий!");
    }
    for (int i = 0; i <= differenceYear; i++) {
      if (dateBorn.get(Calendar.YEAR) == dateNow.get(Calendar.YEAR)
          && dateBorn.get(Calendar.MONTH) > dateNow.get(Calendar.MONTH)) {
        System.err.println("Вы ввели месяц, превышающий текущий!");
        break;
      }
      if (dateBorn.get(Calendar.YEAR) == dateNow.get(Calendar.YEAR)
          && dateBorn.get(Calendar.DATE) > dateNow.get(Calendar.DATE)) {
        System.err.println("Вы ввели число, превышающее текущее!");
        break;
      }
      System.out.println(i + dateFormat.format(dateBorn.getTime()));
      dateBorn.add(Calendar.YEAR, 1);
      if ((dateBorn.get(Calendar.YEAR) == dateNow.get(Calendar.YEAR)
          && dateBorn.get(Calendar.DATE) > dateNow.get(Calendar.DATE)) || (
          dateBorn.get(Calendar.YEAR) == dateNow.get(Calendar.YEAR)
              && dateBorn.get(Calendar.MONTH) > dateNow.get(Calendar.MONTH))) {
        break;
      }
    }
  }
}
