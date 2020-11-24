package core;

public class Line implements Comparable<Line> {
    private String number;
    private String name;
    private String color;

    public Line(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.number + ". " + this.name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int compareTo(Line line) {
        return this.getNumber().compareTo(line.getNumber());
    }
}

