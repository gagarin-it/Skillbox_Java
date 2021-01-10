import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class ImageResizer implements Runnable {

  private File[] files;
  private int newWidth;
  private String dstFolder;
  private long start;
  private int threadNumber;

  public ImageResizer(int threadNumber, File[] files, int newWidth, String dstFolder, long start) {
    this.files = files;
    this.newWidth = newWidth;
    this.dstFolder = dstFolder;
    this.start = start;
    this.threadNumber = threadNumber;
  }

  @Override
  public void run() {
    try {
      for (File file : files) {
        BufferedImage image = ImageIO.read(file);
        if (image == null) {
          continue;
        }

        int newHeight = (int) Math.round(
            image.getHeight() / (image.getWidth() / (double) newWidth)
        );
        BufferedImage newImage = Scalr
            .resize(image, Method.QUALITY, Mode.AUTOMATIC, newWidth, newHeight, Scalr.OP_ANTIALIAS);

        File newFile = new File(dstFolder + "/" + file.getName());
        ImageIO.write(newImage, "jpg", newFile);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished thread after start: " + (System.currentTimeMillis() - start) + " ms");
  }

  public File[] getFiles() {
    return files;
  }

  public void setFiles(File[] files) {
    this.files = files;
  }

  public int getNewWidth() {
    return newWidth;
  }

  public void setNewWidth(int newWidth) {
    this.newWidth = newWidth;
  }

  public String getDstFolder() {
    return dstFolder;
  }

  public void setDstFolder(String dstFolder) {
    this.dstFolder = dstFolder;
  }

  public long getStart() {
    return start;
  }

  public void setStart(long start) {
    this.start = start;
  }

  public int getThreadNumber() {
    return threadNumber;
  }

  public void setThreadNumber(int threadNumber) {
    this.threadNumber = threadNumber;
  }
}