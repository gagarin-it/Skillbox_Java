import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Введите путь до папки, для получения общего размера файлов и папок: ");
    Path pathFolder = Paths.get(reader.readLine());
    System.out
        .println("Размер папки \"" + pathFolder + "\" составляет: " + getSizeFolder(pathFolder));
  }

  private static String getSizeFolder(Path pathFolder) {
    try {
      long sizeFolder = 0;
      String[] units = new String[]{"Б", "Кб", "Мб", "Гб", "Тб"};
      int unitIndex = (int) (Math.log10(sizeFolder) / 3);
      double unitValue = 1 << (unitIndex * 10);
      try (Stream<Path> walk = Files.walk(pathFolder)) {
        sizeFolder = walk
            .filter(Files::isRegularFile)
            .mapToLong(f -> {
              try {
                return Files.size(f);
              } catch (IOException e) {
                e.getStackTrace();
                System.out.println("Размер файла недоступен");
                return 0L;
              }
            })
            .sum();
      } catch (IOException e) {
        e.getStackTrace();
      }
      return new DecimalFormat("#,##0.#")
          .format(sizeFolder / unitValue) + " "
          + units[unitIndex];
    } catch (ArrayIndexOutOfBoundsException e) {
      e.getStackTrace();
      return "0 Б";
    }
  }
}