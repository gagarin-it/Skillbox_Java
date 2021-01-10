import java.io.File;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

  private static int newWidth = 300;
  private static int amountOfCores = Runtime.getRuntime().availableProcessors();
  private static long startTime = System.currentTimeMillis();


  public static void main(String[] args) {
    String srcFolder = "E:\\Skillbox\\ImageResizerJava\\src";
    String dstFolder = "E:\\Skillbox\\ImageResizerJava\\dst";

    File[] listOfFilesSCR = new File(srcFolder).listFiles();
    startThreads(initializingThreadsWithFiles(createThreads(amountOfCores), listOfFilesSCR, dstFolder, startTime));
  }

  public static Thread[] initializingThreadsWithFiles(Thread[] threads, File[] listOfFilesSCR, String dstFolder,
      long startTime) {
    Thread[] threadsTemp = new Thread[threads.length];
    for (int i = 0; i < threads.length; i++) {
      int threadNumber = i;
      File[] filesPerCore = IntStream.range(0, listOfFilesSCR.length)
          .filter(fileNo -> fileNo % threads.length == threadNumber)
          .mapToObj(n -> listOfFilesSCR[n])
          .toArray(File[]::new);
      threadsTemp[i] = new Thread(new ImageResizer(threadNumber, filesPerCore, newWidth, dstFolder, startTime));
    }
    return threadsTemp;
  }

  public static void startThreads(Thread[] threads) {
    Arrays.stream(threads).forEach(Thread::start);
  }

  public static Thread[] createThreads(int amountOfCores) {
    if (amountOfCores <= 0) {
      throw new IllegalArgumentException("Invalid amount of cores: " + amountOfCores);
    } else {
      return new Thread[amountOfCores];
    }
  }
}
