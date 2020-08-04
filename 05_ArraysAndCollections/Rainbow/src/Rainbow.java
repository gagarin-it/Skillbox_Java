import java.util.Arrays;
import java.util.Collections;

public class Rainbow {

  public static void main(String[] args) {
    String text = "Каждый охотник желает знать, где сидит фазан";
    String[] colors = text.split(",?\\s+");
    for (String print : colors){
      System.out.println(print);
    }
    Collections.reverse(Arrays.asList(colors));
    for (String print : colors){
      System.out.println(print);
    }
  }
}
