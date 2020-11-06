import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;

public class Main {

  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Введите путь к каталогу, для копирования");
      File pathFromDirectory = new File(reader.readLine());
      System.out.println("Введите путь к каталогу, куда копировать");
      File pathToDirectory = new File(reader.readLine());
      copyFileUsingApacheCommonsIO(pathFromDirectory, pathToDirectory);
    } catch (Exception e) {
      System.out.println(Arrays.toString(e.getStackTrace()));
    }
  }

  private static void copyFileUsingApacheCommonsIO(File source, File dest) {
    try {
      FileUtils.copyDirectory(source, dest);
      System.out.println("Копирование каталога выполнено!");
    } catch (IOException e) {
      e.getStackTrace();
      System.err.println("Не верно указаны путь или имя каталога: " + e.getMessage());
    }
  }
}
