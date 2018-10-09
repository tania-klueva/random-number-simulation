package sample;

import javafx.collections.ObservableList;

import java.util.Set;

public interface Calculations {
    double calculateVibirkoveSerednye();
    double calculateMathHope(ObservableList<Event> list);
    double calculateMathHope(ObservableList<Event> list, int pow);
    double calculateVybyrkovuDispersion();
    double calculateDispersion(ObservableList<Event> list);
}
