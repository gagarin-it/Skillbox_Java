import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Set<String> treeList = new TreeSet<>();
    System.out.println(
        "Добро пожаловать в перечень адресов электронной почты."
            + "\n Для работы используйте следующие команды:"
            + "\n\t LIST — выводит адреса электронной почты;"
            + "\n\t ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;"
            + "\n\t EXIT - выход из программы");
    treeList.add("email@skillbox.ru");
    treeList.add("email@yandex.ru");
    treeList.add("sacred@newmail.ru");
    while (true) {
      String s = reader.readLine();
      Pattern pattern = Pattern.compile("(?i)(ADD\\s+)([A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4})");
      Matcher matcher = pattern.matcher(s);
      if (s.equalsIgnoreCase("EXIT")) {
        break;
      }
      if (s.equalsIgnoreCase("LIST")) {
        for (String list : treeList) {
          System.out.println(list);
        }
      } else if (matcher.find()) {
        treeList.add(matcher.group(2));
      } else {
        System.err.println("Введён неверный e-mail адресс, проверьте формат введёного адреса");
      }
    }
  }
}
