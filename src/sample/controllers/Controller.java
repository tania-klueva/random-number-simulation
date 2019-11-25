package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Interval;
import sample.IntervalList;
import sample.calc.Calculations;
import sample.calc.CalculationsImpl;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    public TextField textAreaMin;
    @FXML
    public TextField textAreaMax;
    @FXML
    public TextField textAreaN;
    @FXML
    public Button generateButton;
    @FXML
    public ListView<Double> randomArrayListView1;
    @FXML
    public ListView<Double> randomArrayListView2;
    @FXML
    public Label mS;
    @FXML
    public Label dP;
    @FXML
    public Label kV;
    @FXML
    public Label kK;
    @FXML
    public BarChart<String, Double> gistorgam;

    private IntervalList intervals = new IntervalList();
    private Calculations calculations = new CalculationsImpl();

    public List<Double> convertToList(double[] arr) {
        List<Double> list = new ArrayList<>();
        for (double v : arr) {
            list.add(v);
        }
        return list;
    }


    public void generateOnClick(MouseEvent mouseEvent) {
        int min = Integer.parseInt(textAreaMin.getText());
        int max = Integer.parseInt(textAreaMax.getText());
        int n = Integer.parseInt(textAreaN.getText());
        double[] array = Calculations.generateRandomArray(min, max, n);
        double[] arrayY = Calculations.generateRandomArray(min, max, n);
        intervals.fillList(n, min, max, array);
        ObservableList<Interval> intervalsObservable = intervals.getIntervals();
        ObservableList<Double> randomArrayX = FXCollections.observableArrayList(convertToList(array));
        ObservableList<Double> randomArrayY = FXCollections.observableArrayList(convertToList(arrayY));
        mS.setText("Математичне сподівання = " + calculations.calculateVibirkoveSerednye(array));
        dP.setText("Дисперсія = " + calculations.calculateVybyrkovuDispersion(array));
        kV.setText("Квадратичне відхилення = " + calculations.calculateKvVidhylennia(array));
        kK.setText("Коєфіцієнт кореляції = " + calculations.koefKoreliatsii(array, arrayY));
        randomArrayListView1.setItems(randomArrayX);
        randomArrayListView2.setItems(randomArrayY);
        gistorgam.getData().clear();
        gistorgam.getXAxis().setLabel("Інтервал");
        gistorgam.getYAxis().setLabel("Частота появи");
        gistorgam.getData().add(createSeriesForGistogram("Гістограма", intervalsObservable));
    }

    public XYChart.Series<String, Double> createSeriesForGistogram(String name, ObservableList<Interval> list) {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName(name);
        for (Interval interval1 : list) {
            series.getData().add(new XYChart.Data<>(interval1.getInterval(), interval1.getFrequencyOfHits()));
        }

        return series;

    }
}
