package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.util.List;

public class IntervalList {
    private ObservableList<Interval> intervals = FXCollections.observableArrayList();

    public ObservableList<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(ObservableList<Interval> intervals) {
        this.intervals = intervals;
    }

    public void fillList(int n, double start, double end, double[] array) {
        intervals.clear();
        int intervalsCount = 1 + log2(n);
        double dx = (end - start) / intervalsCount;
        for (double i = start; i < end; i += dx) {
            i = Double.parseDouble(new BigDecimal(i).setScale(1, BigDecimal.ROUND_HALF_UP) + "");
            Interval interval = new Interval(i, i + dx);
            interval.setNumberOfVariables(array);
            intervals.add(interval);
        }
    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    @Override
    public String toString() {
        return "IntervalList{" +
                "intervals=" + intervals +
                '}';
    }
}
