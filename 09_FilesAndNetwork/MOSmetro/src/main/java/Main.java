import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import core.Line;
import core.ParserHTML;
import core.Station;
import core.StationIndex;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

  private final static String JSON_FILE = "src/main/resources/map.json";
  private static Map<String, Station> stations = new TreeMap<>();
  private static StationIndex stationIndex = new StationIndex();

  public static void main(String[] args) throws IOException {
    ParserHTML parserHTML = new ParserHTML();
    List<Line> allLines = parserHTML.parseLines();
    allLines.forEach((line) -> {
      stationIndex.addLine(line);
      List<Station> stationsOfLine = parserHTML.parseStations(line);
      stationIndex.addAllLineStations(line, stationsOfLine);
      stationsOfLine.forEach(l -> stations.put(l.getStationName(), l));
    });
    List<TreeSet<Station>> allConnections = parserHTML
        .parseConnections(allLines, stations);
    allConnections.forEach(s -> stationIndex.addConnection(s));
    mapToFile(stationIndex, JSON_FILE);

    System.out.println("Общее количество станций: " + getStationsCount(JSON_FILE) + " шт.");
    System.out.println("Количество станций по каждой линии: ");
    getStationsOnLine(JSON_FILE);
    System.out.println("Общее количество переходов: " + getConnectionsCount(JSON_FILE) + " шт.");
  }

  public static void mapToFile(StationIndex index, String file) {
    try {
      Gson gson = new GsonBuilder()
          .setPrettyPrinting()
          .create();
      FileWriter fileToJson = new FileWriter(file);
      gson.toJson(index, fileToJson);
      fileToJson.flush();
      fileToJson.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
  }

  private static int getStationsCount(String jsonFile) {
    try {
      BufferedReader jsonReader = new BufferedReader(new FileReader(jsonFile));
      JsonObject obj = new Gson().fromJson(jsonReader, JsonObject.class);
      JsonObject stationsObject = (JsonObject) obj.get("stations");
      int count = stationsObject.keySet().stream().mapToInt(lineNumber -> {
        JsonArray stationsArray = (JsonArray) stationsObject.get(lineNumber);
        return stationsArray.size();
      }).sum();
      jsonReader.close();
      return count;
    } catch (Exception e) {
      e.getStackTrace();
      return 0;
    }
  }

  private static void getStationsOnLine(String jsonFile) {
    try {
      BufferedReader jsonReader = new BufferedReader(new FileReader(jsonFile));
      JsonObject obj = new Gson().fromJson(jsonReader, JsonObject.class);
      JsonObject stationsObject = (JsonObject) obj.get("stations");
      JsonArray linesArray = (JsonArray) obj.get("lines");
      Map<String, String> lin = new HashMap<>();
      for (int i = 0; i < linesArray.size(); i++) {
        lin.put(linesArray.get(i).getAsJsonObject().get("number").getAsString(),
            linesArray.get(i).getAsJsonObject().get("name").getAsString());
      }
      stationsObject.entrySet().stream().map(
          k -> lin.get(k.getKey()) + " (" + k.getKey() + "): "
              + stationsObject.get(k.getKey()).getAsJsonArray().size() + " шт.").forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static int getConnectionsCount(String jsonFile) {
    try {
      BufferedReader jsonReader = new BufferedReader(new FileReader(jsonFile));
      JsonObject obj = new Gson().fromJson(jsonReader, JsonObject.class);
      JsonArray connections = obj.getAsJsonArray("connections");
      int count = connections.size();
      jsonReader.close();
      return count;
    } catch (Exception e) {
      e.getStackTrace();
      return 0;
    }
  }
}