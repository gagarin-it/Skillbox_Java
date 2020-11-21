import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

  private static final String OUTPUT_FOLDER_SAVED_IMAGE = "src/main/resources/img";

  public static void main(String[] args) throws IOException {
    String url = "https://lenta.ru";
    Document doc = Jsoup.connect(url).get();
    Elements pngs = doc.select("img[src~=(?i)\\.(png|jpe?g)]");
    for (Element png : pngs) {
      String strImageURL = png.attr("abs:src");
      downloadImage(strImageURL);
    }
  }

  private static void downloadImage(String strImageURL) {
    try {
      Path pathFolder = Paths.get(OUTPUT_FOLDER_SAVED_IMAGE);
      if(!Files.exists(pathFolder)){
        Files.createDirectory(pathFolder);
      }
      String strImageName = strImageURL.substring(strImageURL.lastIndexOf("/") + 1);

      URL urlImage = new URL(strImageURL);
      InputStream in = urlImage.openStream();

      byte[] buffer = new byte[4096];
      int n = -1;

      OutputStream os =
          new FileOutputStream(OUTPUT_FOLDER_SAVED_IMAGE + "/" + strImageName);
      while ((n = in.read(buffer)) != -1) {
        os.write(buffer, 0, n);
      }
      os.close();
      System.out.println("Saved: " + strImageName + ", from: " + strImageURL);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}