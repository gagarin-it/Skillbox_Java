import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

  private static final String PATH_FILE_CSV = "src/main/resources/movementList.csv";
  private static final String DATE_FORMAT = "dd.MM.yy";

  public static void main(String[] args) {
    List<String> parseLines = parserCSVToList(PATH_FILE_CSV);
    List<Statement> statements = parseStatement(parseLines);
    System.out.println(
        "Сумма расходов: " + statements.stream().mapToDouble(Statement::getWithdrawalMoney).sum()
            + " руб.");
    System.out.println(
        "Сумма доходов: " + statements.stream().mapToDouble(Statement::getDepositMoney).sum()
            + " руб.");
    System.out.println("Суммы расходов по организациям: ");
    //Сортировка компаний по расходам
    sortByValue(statements.stream().collect(Collectors.groupingBy(Statement::getTransactionDescription,
        Collectors.summingDouble(Statement::getWithdrawalMoney)))).forEach((key, value) -> System.out.printf("%-33s%,10.2f руб.%n", key, value));
/*
    //Без сортировки
    statements.stream().collect(Collectors.groupingBy(Statement::getTransactionDescription,
        Collectors.summingDouble(Statement::getWithdrawalMoney)))
        .forEach((key, value) -> System.out.printf("%-33s%,10.2f руб.%n", key, value));
*/
/*
    //Сортировка компаний по алфавиту
    Map<String, Double> treeMap = new TreeMap<>(statements.stream().collect(Collectors.groupingBy(Statement::getTransactionDescription,
        Collectors.summingDouble(Statement::getWithdrawalMoney))));
    treeMap.forEach((key, value) -> System.out.printf("%-33s%,10.2f руб.%n", key, value));
*/
  }

  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
    List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
    list.sort(Entry.comparingByValue());

    Map<K, V> result = new LinkedHashMap<>();
    for (Entry<K, V> entry : list) {
      result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }

  private static List<String> parserCSVToList(String pathCSV) {
    try {
      return Files.readAllLines(Paths.get(pathCSV));
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  private static List<Statement> parseStatement(List<String> linesCSV) {
    try {
      List<Statement> statementsTemp = new ArrayList<>();
      List<String> tempList = getListIsParseDouble(linesCSV);
      for (String line : tempList) {
        String[] fragmentsLine = line.split(",", 8);
        statementsTemp.add(new Statement(fragmentsLine[0], fragmentsLine[1], fragmentsLine[2],
            (new SimpleDateFormat(DATE_FORMAT)).parse(fragmentsLine[3]), fragmentsLine[4],
            getDescriptionRegExReplaceSlash(fragmentsLine[5]), Double.parseDouble(fragmentsLine[6]),
            Double.parseDouble(getStringReplaceForDouble(fragmentsLine[7]))));
      }
      return statementsTemp;
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  private static String getStringReplaceForDouble(String text) {
    try {
      if (text.matches("\"?\\d+,\\d+\"")) {
        return text.replaceAll("\"", "").replaceAll(",", ".");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return text;
  }

  private static String getDescriptionRegExReplaceSlash(String text) {
    try {
      Pattern pattern = Pattern.compile("([/\\\\].*?)(\\s{2,})");
      Matcher matcher = pattern.matcher(text);
      if (matcher.find()) {
        return matcher.group(1).replaceAll("[/\\\\]", "");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return text;
  }

  public static boolean isNotParsableDouble(String input) {
    try {
      Double.parseDouble(input);
      return false;
    } catch (final NumberFormatException e) {
      return true;
    }
  }

  private static List<String> getListIsParseDouble(List<String> list) {
    try {
      List<String> temp = new ArrayList<>(list);
      for (String line : list) {
        String[] fragmentsLine = line.split(",", 8);
        if (isNotParsableDouble(fragmentsLine[6]) && isNotParsableDouble(fragmentsLine[7])) {
          temp.remove(line);
        }
      }
      return temp;
    } catch (Exception e) {
      e.printStackTrace();
      return list;
    }
  }

}
