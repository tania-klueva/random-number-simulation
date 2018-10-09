package sample;

import java.math.BigDecimal;

public class Interval {
    private double start;
    private double end;
    private String interval;
    private int numberOfVariables = 0;
    private double frequencyOfHits;

    public Interval(double start, double end) {
        this.start = start;
        this.end = end;
        this.interval = new BigDecimal(start).setScale(1, BigDecimal.ROUND_HALF_UP)+"-"+new BigDecimal(end).setScale(1, BigDecimal.ROUND_HALF_UP);
    }

    public double getStart() {
        return start;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public int getNumberOfVariables() {
        return numberOfVariables;
    }

    public void setNumberOfVariables(double [] array) {
        for (double v : array) {
            if (v >= start && v < end){
                this.numberOfVariables++;
            }
        }

        this.frequencyOfHits = numberOfVariables / 1000.0;
    }

    public double getFrequencyOfHits() {
        return frequencyOfHits;
    }


    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                ", interval='" + interval + '\'' +
                ", numberOfVariables=" + numberOfVariables +
                ", frequencyOfHits=" + frequencyOfHits +
                '}';
    }
}
