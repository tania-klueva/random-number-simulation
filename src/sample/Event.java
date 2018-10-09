package sample;

public class Event {
    private int x;
    private double p;

    public Event(int x, double p) {
        this.x = x;
        this.p = p;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Event{" +
                "x=" + x +
                ", p=" + p +
                '}';
    }
}
