import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

  public static void main(String[] args) {

    DateFormat dF = new SimpleDateFormat("HH:mm");
    Calendar timeNow = Calendar.getInstance();
    Calendar timeDeparture = Calendar.getInstance();
    timeDeparture.add(Calendar.HOUR, 2);

    Airport.getInstance().getTerminals().stream().flatMap(t -> t.getFlights().stream().filter(
        e -> e.getType().equals(Type.DEPARTURE) && e.getDate().after(timeNow.getTime()) && e
            .getDate().before(timeDeparture.getTime()))
        .map(e -> "Время вылета: " + dF.format(e.getDate()) + " // Самолётом: " + e.getAircraft()))
        .sorted().forEach(System.out::println);
  }
}
