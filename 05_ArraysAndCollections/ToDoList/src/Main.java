import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> toDoList = new ArrayList<>();
    int indexList = 0;
    System.out.println(
        "Добро пожаловать в Ваш список дел.\n" + "Для работы используйте следующие команды:"
            + "\n\t LIST — выводит дела с их порядковыми номерами;"
            + "\n\t ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;"
            + "\n\t EDIT — заменяет дело с указанным номером;"
            + "\n\t DELETE — удаляет дело с указанным номером;" + "\n\t EXIT - выход из программы");
    toDoList.add("Сходить в магазин");
    toDoList.add("Помыть дракона");
    toDoList.add("Покормить дракона 25 барашками");
    while (true) {
      String s = reader.readLine();
      String[] massiveSplit = s.split("\\s+", 3);
      if (s.equals("LIST")) {
        for (int i = 0; i < toDoList.size(); i++) {
          System.out.println(i + ") " + toDoList.get(i));
        }
      }
      if (s.equals("EXIT")) {
        break;
      }
      if (s.matches("ADD\\s+(\\d+)\\s+(\\w*.*)")) {
        indexList = Integer.parseInt(massiveSplit[1]);
        if (indexList < toDoList.size()) {
          toDoList.add(indexList, massiveSplit[2]);
        } else {
          System.err.println("Введён неверный номер дела, дело добавлено в конец списка");
          toDoList.add(massiveSplit[2]);
        }
      } else if (s.matches("ADD\\s+\\w.*")) {
        toDoList.add(massiveSplit[1]);
      }
      if (s.matches("EDIT\\s+(\\d+)\\s+(\\w*.*)")) {
        indexList = Integer.parseInt(massiveSplit[1]);
        if (indexList < toDoList.size()) {
          toDoList.set(indexList, massiveSplit[2]);
        } else {
          System.err.println("Введён неверный номер дела");
        }
      }
      if (s.matches("DELETE\\s+(\\d+).*")) {
        indexList = Integer.parseInt(massiveSplit[1]);
        if (indexList < toDoList.size()) {
          toDoList.remove(indexList);
        } else {
          System.err.println("Введён неверный номер дела");
        }
      }
    }
  }
}
