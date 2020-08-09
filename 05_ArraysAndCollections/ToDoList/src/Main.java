import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> toDoList = new ArrayList<>();
    System.out.println(
        "Добро пожаловать в Ваш список дел.\n" + "Для работы используйте следующие команды:"
            + "\n\t LIST — выводит дела с их порядковыми номерами;"
            + "\n\t ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;"
            + "\n\t EDIT — заменяет дело с указанным номером;"
            + "\n\t DELETE — удаляет дело с указанным номером;" + "\n\t EXIT - выход из программы");
    toDoList.add("Первое");
    while (true) {
      String s = reader.readLine();
      if (s.equals("LIST")) {
        for (int i = 0; i < toDoList.size(); i++) {
          System.out.println(i + 1 + ") " + toDoList.get(i));
        }
      }
      if(s.equals("EXIT")){
        break;
      }
    }
  }

}
