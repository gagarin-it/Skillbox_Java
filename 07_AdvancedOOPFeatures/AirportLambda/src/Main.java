import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Flight.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Airport airport = Airport.getInstance();

    DateFormat dF = new SimpleDateFormat("HH:mm");
    Calendar timeNow = Calendar.getInstance();
    Calendar timeDeparture = Calendar.getInstance();
    timeDeparture.add(Calendar.HOUR, 2);

    List<Flight> flightList = new ArrayList<>();

    for (int i = 0; i < airport.getTerminals().size(); i++) {
      flightList.addAll(airport.getTerminals().get(i).getFlights());
    }

    flightList.stream().filter(
        e -> e.getType().equals(Type.DEPARTURE) && e.getDate().after(timeNow.getTime()) && e
            .getDate().before(timeDeparture.getTime()))
        .map(e -> "Время вылета: " + dF.format(e.getDate()) + " // Самолётом: " + e.getAircraft())
        .sorted().forEach(System.out::println);
  }
}
