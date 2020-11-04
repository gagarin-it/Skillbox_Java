import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException(
                "Не верный формат записи. Введите согласно формата: \n"
                    + "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        Pattern patternNumber = Pattern
            .compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10}$");
        Matcher matcherNumber = patternNumber.matcher(components[3]);
        if (!matcherNumber.find()) {
            throw new NumberFormatException(
                "Не верный формат телефонного номера. Введите согласно формата: +79215637722");
        }
        Pattern patternEmail = Pattern.compile("(?i)([A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4})");
        Matcher matcherEmail = patternEmail.matcher(components[2]);
        if (!matcherEmail.find()) {
            throw new IllegalArgumentException(
                "Не верный формат адреса электронной почты. Введите согласно формата: vasily.petrov@gmail.com");
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (name.split("\\s+").length != 2) {
            throw new IllegalArgumentException(
                "Не верный формат записи. Введите согласно формата: remove Василий Петров");
        }
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}