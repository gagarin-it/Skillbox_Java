import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
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
      String strImageName = strImageURL.substring(strImageURL.lastIndexOf("/") + 1);
      URL urlImage = new URL(strImageURL);
      FileUtils.copyURLToFile(urlImage,new File(OUTPUT_FOLDER_SAVED_IMAGE,strImageName));
      System.out.println("Saved: " + strImageName + ", from: " + strImageURL);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}