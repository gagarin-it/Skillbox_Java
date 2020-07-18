import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Введите количество загруженных ящиков: ");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int boxes = Integer.parseInt(reader.readLine());
    int container = 0, truck = 0;
    for (int b = 1; b <= boxes; b++)
          {
            if ((b - 1) % 27 == 0)
            {
              if (container  % 12 == 0)
              {
              truck++;
              System.out.println("Грузовик " + truck);
              }
              container++;
              System.out.println("Контейнер " + container);
            }
            System.out.println("\tЯщик " + b );
          }
    System.out.println("Необходимо:\nгрузовиков - " + truck + " шт.\nконтейнеров - " + container + " шт.");
  }
}
