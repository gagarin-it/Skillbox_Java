import com.google.common.collect.Lists;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

  private static int newWidth = 300;
  private static int amountOfCores = Runtime.getRuntime().availableProcessors();


  public static void main(String[] args) {
    String srcFolder = "E:\\Skillbox\\ImageResizerJava\\src";
    String dstFolder = "E:\\Skillbox\\ImageResizerJava\\dst";

    List<File> files = Arrays.asList(Objects.requireNonNull(new File(srcFolder).listFiles()));
    int sizeList = files.size() / amountOfCores + 1;

    List<List<File>> tep = splitList(files, sizeList);
    startThread(tep,dstFolder,amountOfCores);
  }

  public static void startThread(List<List<File>> listOfFilesSCR, String dstFolder, int amountOfCores) {
    long startTime = System.currentTimeMillis();
    if (amountOfCores <= 0) {
      throw new IllegalArgumentException("Invalid amount of cores: " + amountOfCores);
    }
    for (int i = 0; i < amountOfCores; i++) {
      System.out.println(listOfFilesSCR.get(i).size());
      ImageResizer resizer = new ImageResizer(listOfFilesSCR.get(i), newWidth, dstFolder, startTime);
      new Thread(resizer).start();
    }
  }

  public static List<List<File>> splitList(List<File> listFiles, int sizeList) {
    return Lists.partition(listFiles, sizeList);
  }
}
