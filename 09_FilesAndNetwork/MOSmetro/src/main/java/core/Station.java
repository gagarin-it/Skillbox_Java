package core;

public class Station implements Comparable<Station> {
    private String lineNumber;
    private String stationName;

    public Station(String stationName, Line line) {
        this.stationName = stationName;
        this.lineNumber = line.getNumber();
    }

    public String getLineNumber() {
        return this.lineNumber;
    }

    public String getStationName() {
        return this.stationName;
    }

    public String toString() {
        return this.stationName;
    }

    @Override
    public int compareTo(Station station) {
        if (this.getLineNumber().equals(station.getLineNumber())) {
            return this.getStationName().compareTo(station.getStationName());
        } else return this.getLineNumber().compareTo(station.getLineNumber());
    }
}
