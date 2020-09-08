import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) throws IOException {
    Map<String, String> name2phone = new TreeMap<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Введите имя контакта или номер телефона:");
    while (true) {
      String name2number = reader.readLine();
      if (name2number.equalsIgnoreCase("LIST")) {
        listMap(name2phone);
        continue;
      }
      if (name2number.equalsIgnoreCase("EXIT")) {
        break;
      }
      Pattern patternName = Pattern.compile(
          "^([А-ЯЁA-Z]|[А-ЯЁA-Z][\\x27а-яёa-z]+|[А-ЯЁA-Z][\\x27а-яёa-z]+-([А-ЯЁA-Z][\\x27а-яёa-z]+|(оглы)|(кызы)|(бюль)))\\040[А-ЯЁA-Z][\\x27а-яёa-z]+(\\040[А-ЯЁA-Z][\\x27а-яёa-z]+)?$");
      Matcher matcherName = patternName.matcher(name2number);
      Pattern patternNumber = Pattern
          .compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
      Matcher matcherNumber = patternNumber.matcher(name2number);

      name2phone.put("Иванов-Фёдоров Пётр Сергеевич", "+79825637955");
      name2phone.put("Гагарин Александр Юрьевич", "+79991111111");
      name2phone.put("Ромик-оглы Арзиманов", "+79212025469");

      if (matcherNumber.find()) {
        if (name2phone.containsValue(name2number)) {
          int index = new ArrayList<>(name2phone.values()).indexOf(name2number);
          System.out.println(name2phone.keySet().toArray()[index]);
        } else {
          System.out.println("Введите имя контакта, для добавления в телефонную книгу:");
          String name = reader.readLine();
          if (name2phone.containsKey(name)) {
            name2phone.put(name, name2phone.get(name) + "\n\t" + name2number);
            name2phone.replace(name, name2phone.get(name) + "\n\t" + name2number);
          }
          name2phone.put(name, name2number);
        }
      }
      if (matcherName.find()) {
        if (name2phone.containsKey(name2number)) {
          System.out.println(name2phone.get(name2number));
        } else {
          System.out.println("Введите номер телефона, для добавления в телефонную книгу:");
          String number = reader.readLine();
          name2phone.put(name2number, number);
        }
      }
    }
  }

  private static void listMap(Map<String, String> map) {
    for (String key : map.keySet()) {
      System.out.println(key + "\n\t" + map.get(key));
    }
  }
}