package sample;

import java.math.BigDecimal;
import java.util.List;

public class Interval {
    private double start;
    private double end;
    private String interval;
    private int numberOfVariables = 0;
    private double frequencyOfHits;
    private double valueOfX = 0;

    public Interval(double start, double end) {
        this.start = start;
        this.end = end;
        this.interval = new BigDecimal(start).setScale(2, BigDecimal.ROUND_HALF_UP)+"-"+new BigDecimal(end).setScale(2, BigDecimal.ROUND_HALF_UP);
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

        this.frequencyOfHits = (double)numberOfVariables / array.length;
    }


    public double getFrequencyOfHits() {
        return frequencyOfHits;
    }

    public double getValueOfX() {
        return valueOfX;
    }

    public void setValueOfX(double valueOfX) {
        this.valueOfX = valueOfX;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                ", interval1='" + interval + '\'' +
                ", numberOfVariables1=" + numberOfVariables +
                ", frequencyOfHits=" + frequencyOfHits +
                '}';
    }
}
