import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Введите путь до папки, для получения общего размера файлов и папок: ");
      String pathFolder = reader.readLine();
      File folder = new File(pathFolder);
      System.out.println("Размер папки \"" + pathFolder + "\" составляет: " + getCorrectFormatSizeFolder(
          getSizeFolder(folder)));
    } catch (Exception ex) {
      ex.getStackTrace();
    }
  }

  private static long getSizeFolder(File folder) {
    long sizeFolder = 0;
    File[] files = folder.listFiles();
    if (files != null) {
      for (File file : files) {
        if (file.isFile()) {
          sizeFolder += file.length();
        } else {
          sizeFolder += getSizeFolder(file);
        }
      }
    }
    return sizeFolder;
  }

  private static String getCorrectFormatSizeFolder(long size) {
    String[] units = new String[]{"Б", "Кб", "Мб", "Гб", "Тб"};
    int unitIndex = (int) (Math.log10(size) / 3);
    double unitValue = 1 << (unitIndex * 10);
    return new DecimalFormat("#,##0.#")
        .format(size / unitValue) + " "
        + units[unitIndex];
  }
}