import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {

  public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("https://lenta.ru").get();

    Element link = doc.select("img").first();
    String relHref = link.attr("href"); // == "/"
    String absHref = link.attr("src:href");
    System.out.println(absHref);
  }
}
