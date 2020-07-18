
public class Loader
{
    public static void main(String[] args)
    {
//        for(char i = 'A'; i <= 'Z';i++)
//        {
//            System.out.println(i + " - " + ((int)i));
//        }
//        for(char i = 'a'; i <= 'z';i++)
//        {
//            System.out.println(i + " - " + ((int)i));
//        }

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(Integer.parseInt(text.substring(15,19)) + Integer.parseInt(text.substring(56,61)));
    }
}