public class Main
{
    private Integer number;
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        Container container2 = new Container();
        container2.count += 1546;
        System.out.println("Число: " + container.count);
        System.out.println("Сумма цифр в числе: " + sumDigits(container.count));
        System.out.println("Число: " + container2.count);
        System.out.println("Сумма цифр в числе: " + sumDigits(container2.count));
    }

    public static Integer sumDigits(Integer number)
    {
        String sNum1 = String.valueOf(number);
        int num1 = Integer.parseInt(sNum1.substring(0,1));
        int num2 = Integer.parseInt(sNum1.substring(1,2));
        int num3 = Integer.parseInt(sNum1.substring(2,3));
        int num4 = Integer.parseInt(sNum1.substring(3,4));
        int sum = num1 + num2 + num3 + num4;
        return sum;
    }
}
