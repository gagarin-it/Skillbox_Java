import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws IOException {
    String[] chars = {"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У", "Х", "К"};
    Arrays.sort(chars);
    List<String> autoNumber = new ArrayList<>();
    for (int region = 1; region <= 199; region++) {
      for (int num = 111; num <= 999; num += 111) {
        for (int char1 = 0; char1 < chars.length; char1++) {
          for (int char2 = 0; char2 < chars.length; char2++) {
            for (int char3 = 0; char3 < chars.length; char3++) {
              String numberFormat = String
                  .format("%s%03d%s%s%02d", chars[char1], num, chars[char2], chars[char3], region);
              autoNumber.add(numberFormat);
            }
          }
        }
      }
    }
    Set<String> setHash = new HashSet<>();
    setHash.addAll(autoNumber);
    Set<String> setTree = new TreeSet<>();
    setTree.addAll(autoNumber);
    long timeStart, duration = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String number = reader.readLine();
      if (number.equalsIgnoreCase("EXIT")) {
        break;
      }
      //Прямой перебор
      timeStart = System.nanoTime();
      if (autoNumber.contains(number)) {
        duration = System.nanoTime() - timeStart;
        System.out.println("Поиск перебором: номер найден, поиск занял " + duration + " нс");
      } else {
        duration = System.nanoTime() - timeStart;
        System.out.println("Поиск перебором: номер не найден, поиск занял " + duration + " нс");
      }
      //Бинарный поиск
      timeStart = System.nanoTime();
      if (Collections.binarySearch(autoNumber, number) >= 0) {
        duration = System.nanoTime() - timeStart;
        System.out.println("Бинарный поиск: номер найден, поиск занял " + duration + " нс");
      } else {
        duration = System.nanoTime() - timeStart;
        System.out.println("Бинарный поиск: номер не найден, поиск занял " + duration + " нс");
      }
      //Поиск в HashSet
      timeStart = System.nanoTime();
      if (setHash.contains(number)) {
        duration = System.nanoTime() - timeStart;
        System.out.println("Поиск в HashSet: номер найден, поиск занял " + duration + " нс");
      } else {
        duration = System.nanoTime() - timeStart;
        System.out.println("Поиск в HashSet: номер не найден, поиск занял " + duration + " нс");
      }
      //Поиск в TreeSet
      timeStart = System.nanoTime();
      if (setTree.contains(number)) {
        duration = System.nanoTime() - timeStart;
        System.out.println("Поиск в TreeSet: номер найден, поиск занял " + duration + " нс");
      } else {
        duration = System.nanoTime() - timeStart;
        System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + duration + " нс");
      }
    }
  }
}