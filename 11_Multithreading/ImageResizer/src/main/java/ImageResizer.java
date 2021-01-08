import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class ImageResizer implements Runnable {

  private List<File> files;
  private int newWidth;
  private String dstFolder;
  private long start;

  public ImageResizer(List<File> files, int newWidth, String dstFolder, long start) {
    this.files = files;
    this.newWidth = newWidth;
    this.dstFolder = dstFolder;
    this.start = start;
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
}
