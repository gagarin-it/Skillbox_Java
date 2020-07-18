import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Введите количество загруженных ящиков: ");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int boxes = Integer.parseInt(reader.readLine());
    int containers = boxes / 27;
    int trucks = containers / 12;
    for (int i = 1; i <= ((boxes % 27) % 12); i++)
      {
        System.out.println("Грузовик " + i);
        for (int j = 1; j <= 12; j++)
        {
          System.out.println("Контейнер " + j);
          for (int y = 1; y <= 27; y++)
          {
            System.out.println("\tЯщик " + y);
          }
        }
      }
  }
}
