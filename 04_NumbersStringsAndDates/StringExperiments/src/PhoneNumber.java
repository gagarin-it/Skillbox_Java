import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneNumber {

  public static void main(String[] args) throws IOException {
    System.out.println("Введите номер телефона, в любом удобном для Вас формате: ");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String number = reader.readLine().replaceAll("[^0-9]", "");
    char firstCharNumber = number.charAt(0);
    if (number.length() == 11 && firstCharNumber == '9') {
      System.err.println("Неверный формат номера");
    }
    if (number.length() == 11 && firstCharNumber == '8') {
      System.out.println(number.replaceFirst("8", "7"));
    }
    if (number.length() != 11) {
      if (number.length() == 10 && firstCharNumber == '9') {
        System.out.println("7" + number);
      } else {
        System.err.println("Неверный формат номера");
      }
    }
  }
}
