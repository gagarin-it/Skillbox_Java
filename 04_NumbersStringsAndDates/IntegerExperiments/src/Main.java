public class Main
{
    private Integer number;
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        Container container2 = new Container();
        container2.count += 1541;
        System.out.println("Число: " + container.count);
        System.out.println("Сумма цифр в числе: " + sumDigits(container.count));
        System.out.println("Число: " + container2.count);
        System.out.println("Сумма цифр в числе: " + sumDigits(container2.count));
    }

    public static Integer sumDigits(Integer number)
    {
        String sNum1 = String.valueOf(number);
        int num1 = Integer.parseInt(Character.toString(sNum1.charAt(0)));
        int num2 = Integer.parseInt(Character.toString(sNum1.charAt(1)));
        int num3 = Integer.parseInt(Character.toString(sNum1.charAt(2)));
        int num4 = Integer.parseInt(Character.toString(sNum1.charAt(3)));
        int sum = num1 + num2 + num3 + num4;
        return sum;
    }
}
