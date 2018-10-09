package sample.calc;

import javafx.collections.ObservableList;
import sample.Event;

import java.util.List;
import java.util.Set;

public interface Calculations {
    double calculateVibirkoveSerednye();
    double calculateMathHope(List<Event> list);
    double calculateMathHope(List<Event> list, int pow);
    double calculateVybyrkovuDispersion();
    double calculateDispersion(List<Event> list);
}
