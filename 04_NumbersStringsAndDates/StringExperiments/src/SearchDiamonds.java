import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchDiamonds {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String textIn = reader.readLine();
    System.out.println(searchAndReplaceDiamonds(textIn,"***"));
  }
  public static String searchAndReplaceDiamonds(String text, String placeholder)
  {
    text = text.replaceAll("<\\w+>", placeholder);
    return text;
  }

}
