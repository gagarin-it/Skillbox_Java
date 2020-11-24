package core;

import com.steadystate.css.parser.CSSOMParser;
import com.steadystate.css.parser.SACParserCSS3;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.CSSParseException;
import org.w3c.css.sac.ErrorHandler;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleSheet;
import ru.folko85.tableofcolor.TableOfColor;

public class ParserHTML {

    private final static String url = "https://www.moscowmap.ru/metro.html#lines";
    Document docMetro;
    Elements elements;

    public ParserHTML() throws IOException {
        this.docMetro = Jsoup.connect(url).userAgent("Chrome")
            .maxBodySize(0).get();
        this.elements = docMetro.select("div#metrodata");
    }

    public List<Line> parseLines() {
        List<Line> listOfLines = new ArrayList<>();
        try {
            Elements lines = elements
                .select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
            Map<String, String> namesOfLines = lines.stream()
                .collect(Collectors.toMap((k) -> k.attr("data-line"), Element::text));
            namesOfLines.forEach((k, v) -> listOfLines.add(new Line(k, v)));
            listOfLines.forEach(line -> line.setColor(parseColorOfLine(getCssUrl(docMetro), line)));
            return listOfLines;
        }catch (Exception e){
            e.getStackTrace();
            return listOfLines;
        }
    }

    public List<Station> parseStations(Line line) {
        try {
            Elements stations = elements.select(
                "div.js-metro-stations.t-metrostation-list-table[data-line = " + line.getNumber()
                    + "]")
                .select("span.name");
            List<String> namesOfStations = stations.stream().map(Element::text)
                .collect(Collectors.toList());
            return namesOfStations.stream().map(x -> new Station(x, line))
                .collect(Collectors.toList());
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public List<TreeSet<Station>> parseConnections(List<Line> lineList,
        Map<String, Station> stationList) {
        List<TreeSet<Station>> result = new ArrayList<>();
        try {
            lineList.forEach(line -> {
                Elements connections = elements.select(
                    "div.js-metro-stations.t-metrostation-list-table[data-line = " + line
                        .getNumber() + "]")
                    .select("p");
                List<TreeSet<Station>> connectionsOfLine = connections.stream().map(stations -> {
                    TreeSet<Station> stationSet = new TreeSet<>();
                    stationSet.add(stationList.get(stations.select("span.name").text()));
                    for (Line innerLine : lineList) {
                        if (getStationName(stations, innerLine) != null) {
                            stationSet.add(stationList.get(getStationName(stations, innerLine)));
                        }
                    }
                    return stationSet;
                }).filter(s -> s.size() > 1).collect(Collectors.toList());
                result.addAll(connectionsOfLine);
            });
            return result;
        } catch (Exception e){
            e.getStackTrace();
            return result;
        }
    }

    public static String getStationName(Element element, Line line) {
        try {
            String title = element.select("span.ln-" + line.getNumber()).attr("title");
            if (!title.isBlank() && !title.isEmpty()) {
                int begin = title.indexOf("«") + 1;
                int end = title.lastIndexOf("»");
                return title.substring(begin, end);
            } else {
                return null;
            }
        } catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public static String parseColorOfLine(String cssUrl, Line line) {
        String color = null;
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new URL(cssUrl).openStream());
            InputSource source = new InputSource(new InputStreamReader(inputStream));
            CSSOMParser parserCSS = new CSSOMParser(new SACParserCSS3());
            ErrorHandler errorHandler = new MyErrorHandler();
            parserCSS.setErrorHandler(errorHandler);
            CSSStyleSheet styleSheet = parserCSS.parseStyleSheet(source, null, null);
            CSSRuleList ruleList = styleSheet.getCssRules();
            inputStream.close();
            TableOfColor table = new TableOfColor(new Locale("ru"));
            for (int i = 0; i < ruleList.getLength(); i++) {
                if (ruleList.item(i).getCssText()
                    .contains("t-icon-metroln.ln-" + line.getNumber() + "::before")) {
                    String itemRule = ruleList.item(i).getCssText();
                    int begin = itemRule.indexOf("(") + 1;
                    int end = itemRule.lastIndexOf(")");
                    String rgbCode = itemRule.substring(begin, end);
                    String hexCode = rgbToHex(rgbCode);
                    color = table.findNamedColorFromHex(hexCode);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return color;
    }

    public static String getCssUrl(Document document) {
        return document.select("link[type = text/css]").attr("abs:href");
    }

    private static String rgbToHex(String code) {
        String[] rgb = code.split(",");
        int r = Integer.parseInt(rgb[0].trim());
        int g = Integer.parseInt(rgb[1].trim());
        int b = Integer.parseInt(rgb[2].trim());
        return String.format("%02x%02x%02x", r, g, b);
    }

    public static class MyErrorHandler implements ErrorHandler {

        @Override
        public void warning(CSSParseException e) throws CSSException {
            e.getStackTrace();
        }

        @Override
        public void error(CSSParseException e) throws CSSException {
            e.getStackTrace();
        }

        @Override
        public void fatalError(CSSParseException e) throws CSSException {
            e.getStackTrace();
        }
    }
}
