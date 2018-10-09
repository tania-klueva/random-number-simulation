package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private IntervalList intervals = new IntervalList();

    private CalculationsImpl calculations = new CalculationsImpl();
    @FXML
    public TextField textAream;
    @FXML
    public TextField textAreaM;
    @FXML
    public Button generateButton;
    @FXML
    public ListView<Double> randomArrayListView;
    @FXML
    public Label mS;
    @FXML
    public Label dP;
    @FXML
    public TableView frequencyTable;
    @FXML
    public TableColumn<Interval, String> interval;
    @FXML
    public TableColumn<Interval, Integer> numberOfVariables;
    @FXML
    public TableColumn<Interval, Double> frequency;
    @FXML
    public BarChart gistorgam;

    public List<Double> convertToList(double [] arr){
        List<Double> list = new ArrayList<>();
        for (double v : arr) {
            list.add(v);
        }
        return list;
    }

    public void generateOnClick(MouseEvent mouseEvent) {
        calculations.generateRandomArray(Integer.parseInt(textAream.getText()), Integer.parseInt(textAreaM.getText()));
        double[] array = calculations.getArray();
        intervals.fillList(10, 0.0, 1.0, array);
        ObservableList<Interval> intervalsObservable = intervals.getIntervals();
        ObservableList<Double> randomArray = FXCollections.observableArrayList(convertToList(array));
        mS.setText("Математичне сподівання = " + calculations.calculateVibirkoveSerednye());
        dP.setText("Дисперсія = " + calculations.calculateVybyrkovuDispersion());
        randomArrayListView.setItems(randomArray);
        interval.setCellValueFactory(new PropertyValueFactory<Interval, String>("interval"));
        numberOfVariables.setCellValueFactory(new PropertyValueFactory<Interval, Integer>("numberOfVariables"));
        frequency.setCellValueFactory(new PropertyValueFactory<Interval, Double>("frequencyOfHits"));
        frequencyTable.setItems(intervalsObservable);
        gistorgam.getData().clear();
        gistorgam.getXAxis().setLabel("Xi");
        gistorgam.getYAxis().setLabel("Pj");
        gistorgam.getData().add(createSeriesForGistogram("", intervalsObservable));


    }

    public XYChart.Series createSeriesForGistogram(String name, ObservableList<Interval> list){
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        for (Interval interval1 : list) {
            series.getData().add(new XYChart.Data(interval1.getInterval(), interval1.getFrequencyOfHits()));
        }

        return series;

    }
}
