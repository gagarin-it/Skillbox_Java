public class Main
{
    private Integer number;
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        Container container2 = new Container();
        container2.count += 1000000000;
        System.out.println("Число: " + container.count);
        System.out.println("Сумма цифр в числе: " + sumDigits(container.count));
        System.out.println("Число: " + container2.count);
        System.out.println("Сумма цифр в числе: " + sumDigits(container2.count));
    }

    public static Integer sumDigits(Integer number)
    {
        String sNum1 = Integer.toString(number);
        int sum = 0;
        for (int i = 0; i < sNum1.length(); i++)
        {
            sNum1.charAt(i);
            sum += Character.getNumericValue(sNum1.charAt(i));
        }
        return sum;
    }
}
