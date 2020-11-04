import core.Line;
import core.Station;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class RouteCalculatorTest extends TestCase {

  RouteCalculator routeCalculator;
  StationIndex stationIndex;

  @Override
  protected void setUp() throws Exception {

    stationIndex = new StationIndex();
    stationIndex.addLine(new Line(1, "Синяя"));
    stationIndex.addLine(new Line(2, "Зелёная"));
    stationIndex.addLine(new Line(3, "Оранжевая"));

/*
                                  StationLayout
                                                  (Вторичная)
                                                       |
                                                       |2
                                                       |
                                                  (Ополчения)
    (Александровская) ----1---- (Еленина) ----1---- (Гагарина) ----1---- (Петровская)
                                                       |
                                                       |2
                                                       |
                                                  (Фрунзе)
                                                       |
                                                       |2
                                                       |
                                                  (Виниловая)
                            (Монастырская) ----3---- (Павловская) ----3---- (Сказочная) ----3---- (Космическая)
*/
    stationIndex.addStation(new Station("Александровская", stationIndex.getLine(1)));
    stationIndex.getLine(1).addStation(stationIndex.getStation("Александровская"));
    stationIndex.addStation(new Station("Еленина", stationIndex.getLine(1)));
    stationIndex.getLine(1).addStation(stationIndex.getStation("Еленина"));
    stationIndex.addStation(new Station("Гагарина", stationIndex.getLine(1)));
    stationIndex.getLine(1).addStation(stationIndex.getStation("Гагарина"));
    stationIndex.addStation(new Station("Петровская", stationIndex.getLine(1)));
    stationIndex.getLine(1).addStation(stationIndex.getStation("Петровская"));

    stationIndex.addStation(new Station("Вторичная", stationIndex.getLine(2)));
    stationIndex.getLine(2).addStation(stationIndex.getStation("Вторичная"));
    stationIndex.addStation(new Station("Ополчения", stationIndex.getLine(2)));
    stationIndex.getLine(2).addStation(stationIndex.getStation("Ополчения"));
    stationIndex.addStation(new Station("Фрунзе", stationIndex.getLine(2)));
    stationIndex.getLine(2).addStation(stationIndex.getStation("Фрунзе"));
    stationIndex.addStation(new Station("Виниловая", stationIndex.getLine(2)));
    stationIndex.getLine(2).addStation(stationIndex.getStation("Виниловая"));

    stationIndex.addStation(new Station("Монастырская", stationIndex.getLine(3)));
    stationIndex.getLine(3).addStation(stationIndex.getStation("Монастырская"));
    stationIndex.addStation(new Station("Павловская", stationIndex.getLine(3)));
    stationIndex.getLine(3).addStation(stationIndex.getStation("Павловская"));
    stationIndex.addStation(new Station("Сказочная", stationIndex.getLine(3)));
    stationIndex.getLine(3).addStation(stationIndex.getStation("Сказочная"));
    stationIndex.addStation(new Station("Космическая", stationIndex.getLine(3)));
    stationIndex.getLine(3).addStation(stationIndex.getStation("Космическая"));

    List<Station> connectionStations = new ArrayList<>();
    connectionStations.add(stationIndex.getStation("Ополчения", 2));
    connectionStations.add(stationIndex.getStation("Гагарина", 1));

    stationIndex.addConnection(connectionStations);
    connectionStations.clear();

    connectionStations.add(stationIndex.getStation("Виниловая", 2));
    connectionStations.add(stationIndex.getStation("Павловская", 3));

    stationIndex.addConnection(connectionStations);
    connectionStations.clear();

    routeCalculator = new RouteCalculator(stationIndex);
  }

  public void testCalculateDurationOnTheLine() {
    List<Station> route = routeCalculator
        .getShortestRoute(stationIndex.getStation("Александровская"),
            stationIndex.getStation("Петровская"));
    double actual = RouteCalculator.calculateDuration(route);
    double expected = 7.5;
    assertEquals(expected, actual);
  }

  public void testCalculateDurationWithOneConnection() {
    List<Station> route = routeCalculator
        .getShortestRoute(stationIndex.getStation("Еленина"), stationIndex.getStation("Виниловая"));
    double actual = RouteCalculator.calculateDuration(route);
    double expected = 11;
    assertEquals(expected, actual);
  }

  public void testCalculateDurationWithTwoConnections() {
    List<Station> route = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"),
        stationIndex.getStation("Сказочная"));
    double actual = RouteCalculator.calculateDuration(route);
    double expected = 17;
    assertEquals(expected, actual);
  }

  @Override
  protected void tearDown() throws Exception {

  }
}
