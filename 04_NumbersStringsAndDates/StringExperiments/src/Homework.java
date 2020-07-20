import java.io.IOException;

public class Homework {

  public static void main(String[] args) throws IOException {
    int sum = 0;
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    String[] splitText = text.split("\\s+руб");
    for (int i = 0; i < splitText.length - 1; i++) {
      int cash = Integer.parseInt(splitText[i].replaceAll("[^0-9]", ""));
      sum += cash;
    }
    System.out.println(sum);
  }
}

