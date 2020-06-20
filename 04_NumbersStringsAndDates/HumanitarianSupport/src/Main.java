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
    if(boxes != 0 && containers != 0)
    {
      for (int i = 1; i <= 27; i++)
      {
        System.out.println("Ящик " + i);
      }

    }

    System.out.println(boxes);
  }
}
