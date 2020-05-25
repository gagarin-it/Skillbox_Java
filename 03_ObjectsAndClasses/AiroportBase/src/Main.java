import com.skillbox.airport.Airport;

public class Main {
    public static void main(String[] args)
    {
        Airport airport = Airport.getInstance();
        System.out.println("Список самолётов: " + airport.getAllAircrafts());
        System.out.println("Количество самолётов: " + airport.getAllAircrafts().size());
    }
}
