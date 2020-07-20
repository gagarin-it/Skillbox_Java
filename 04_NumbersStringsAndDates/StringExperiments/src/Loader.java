import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.sound.midi.Soundbank;

public class Loader {

  public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String textIn = reader.readLine();
//        System.out.println(searchAndReplaceDiamonds(textIn,"***"));

//        for(char i = 'A'; i <= 'Z';i++)
//        {
//            System.out.println(i + " - " + ((int)i));
//        }
//        for(char i = 'a'; i <= 'z';i++)
//        {
//            System.out.println(i + " - " + ((int)i));
//        }
    int sum = 0;
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    String splitText[] = text.split("\\s+руб");
    for (int i = 0; i < splitText.length; i++) {
      int number = Integer.parseInt(splitText[i].replaceAll("[^0-9]", ""));
      System.out.println(splitText[i].replaceAll("[^0-9]", ""));
      sum += number;
//            System.out.println(Integer.parseInt(splitText[i].replaceAll("[^0-9]","")));

    }
    System.out.println(sum);

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите ФИО в формате: Фамилия Имя Отчество");
//        String textIn = reader.readLine();
//        String lastName = "", name = "", patronymic = "";
//        int spaceIndex1 = textIn.indexOf(' ',0);
//        int spaceIndex2 = textIn.indexOf(' ', spaceIndex1 + 1);
//        int spaceIndex3 = textIn.indexOf(' ', spaceIndex2 + 1);
//        if (spaceIndex1 == -1)
//        {
//            lastName = textIn.substring(0,textIn.length());
//        }
//        else {
//            lastName = textIn.substring(0, spaceIndex1);
//            if (spaceIndex2 == -1) {
//                name = textIn.substring(spaceIndex1, textIn.length());
//            } else
//            {
//                name = textIn.substring(spaceIndex1, spaceIndex2);
//            if (spaceIndex3 == -1) {
//                patronymic = textIn.substring(spaceIndex2, textIn.length());
//            } else
//                patronymic = textIn.substring(spaceIndex2, spaceIndex3);
//            }
//        }
//
//        System.out.println("Фамилия: " + lastName + "\nИмя: " + name + "\nОтчество: " + patronymic);

  }
//    public static String searchAndReplaceDiamonds(String text, String placeholder)
//    {
//        int index1 = text.indexOf('<');
//        int index2 = text.lastIndexOf('>');
//        text = text.substring(0,index1) + placeholder + text.substring(index2 + 1);
//        return text;
//    }

}