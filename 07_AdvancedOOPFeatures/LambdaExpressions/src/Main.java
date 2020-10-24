import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

  private static String staffFile = "D:/Skillbox/java_basics/07_AdvancedOOPFeatures/LambdaExpressions/data/staff.txt";
  private static String dateFormat = "dd.MM.yyyy";

  public static void main(String[] args) {
    ArrayList<Employee> staff = loadStaffFromFile();
    staff.sort(Comparator.comparing(Employee::getName));
    staff.sort(Comparator.comparing(Employee::getSalary));
//        staff.forEach(System.out::println);
//        System.out.println("_________________________");
//        staff.forEach(e -> e.setSalary(e.getSalary() + 10000));
//        staff.forEach(System.out::println);
//        System.out.println("_________________________");
//        staff.stream().filter(e -> e.getSalary() >= 99000).forEach(System.out::println);
//        staff.stream().min(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
//        System.out.println("_________________________");
    staff.stream().filter(
        employee -> employee.getWorkStart().after(new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime())
            && employee.getWorkStart().before(new GregorianCalendar(2018, Calendar.JANUARY, 1).getTime()))
        .max(Comparator.comparing(Employee::getSalary)).ifPresent(
        System.out::println);


  }

  private static ArrayList<Employee> loadStaffFromFile() {
    ArrayList<Employee> staff = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(Paths.get(staffFile));
      for (String line : lines) {
        String[] fragments = line.split("\t");
        if (fragments.length != 3) {
          System.out.println("Wrong line: " + line);
          continue;
        }
        staff.add(new Employee(
            fragments[0],
            Integer.parseInt(fragments[1]),
            (new SimpleDateFormat(dateFormat)).parse(fragments[2])
        ));
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return staff;
  }
}