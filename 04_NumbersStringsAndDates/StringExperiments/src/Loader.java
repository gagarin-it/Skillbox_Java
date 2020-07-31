import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] textInput = reader.readLine().split("\\s+");
    String[] result = new String[3];
    System.arraycopy(textInput, 0, result, 0, textInput.length);
    String[] lnp = "Фамилия: Имя: Отчество:".split("\\s+");
    for (int i = 0; i < result.length; i++) {
      if (result[i] == null) {
        result[i] = " ";
      }
      System.out.println(lnp[i] + " " + result[i]);
    }
  }
}