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

    public void fillList(int L, double start, double end, double[] array){
        intervals.clear();
        double dx = (end - start)/L;
        for (double i = start; i < end; i+=dx) {
            i = Double.parseDouble(new BigDecimal(i).setScale(1, BigDecimal.ROUND_HALF_UP) + "");
            Interval interval = new Interval(i, i+dx);
            interval.setNumberOfVariables(array);
            intervals.add(interval);
        }
    }

    public void fillListWithDiskreteValues(List<Event> list, double[] array){
        intervals.clear();
        double sum = 0;
        for (Event event : list) {
            Interval interval = new Interval(sum, sum += event.getP());
            interval.setNumberOfVariables(array);
            interval.setValueOfX(event.getX());
            intervals.add(interval);
        }
    }

    @Override
    public String toString() {
        return "IntervalList{" +
                "intervals=" + intervals +
                '}';
    }
}
