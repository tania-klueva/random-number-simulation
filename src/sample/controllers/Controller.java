package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.DiskreteRandomVariable;
import sample.Event;
import sample.calc.CalculationsImpl;
import sample.Interval;
import sample.IntervalList;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private IntervalList intervals = new IntervalList();
    private IntervalList intervals2 = new IntervalList();
    private DiskreteRandomVariable eventList = new DiskreteRandomVariable();

    private CalculationsImpl calculations = new CalculationsImpl();
    @FXML
    public TextField textAream;
    @FXML
    public TextField textAreaM;
    @FXML
    public Button generateButton;
    @FXML
    public ListView<Double> randomArrayListView1;
    @FXML
    public Label mS1;
    @FXML
    public Label dP1;
    @FXML
    public TableView frequencyTable1;
    @FXML
    public TableColumn<Interval, String> interval1;
    @FXML
    public TableColumn<Interval, Integer> numberOfVariables1;
    @FXML
    public TableColumn<Interval, Double> frequency1;
    @FXML
    public ListView<Double> randomArrayListView2;
    @FXML
    public Label mS2;
    @FXML
    public Label dP2;
    @FXML
    public TableView frequencyTable2;
    @FXML
    public TableColumn<Interval, String> interval2;
    @FXML
    public TableColumn<Interval, Integer> numberOfVariables2;
    @FXML
    public TableColumn<Interval, Double> frequency2;
    @FXML
    public BarChart gistorgam;
    @FXML
    public LineChart<Number, Number> lineChart;

    public List<Double> convertToList(double [] arr){
        List<Double> list = new ArrayList<>();
        for (double v : arr) {
            list.add(v);
        }
        return list;
    }

    public ObservableList<Double> modelingVV(ObservableList<Interval> intervals, ObservableList<Double> randomArray){
        ObservableList<Double> newList = FXCollections.observableArrayList();
        double sum = 0;
        for (Double aDouble : randomArray) {
//            for (Event event : events) {
//                if(aDouble>=sum && aDouble < sum+event.getP()) newList.add((double) event.getX());
//                sum+=event.getP();
//            }

                if (aDouble >= intervals.get(0).getStart() && aDouble< intervals.get(0).getEnd()) newList.add(5.0d);
                if (aDouble >= intervals.get(1).getStart() && aDouble< intervals.get(1).getEnd()) newList.add(8.0d);
                if (aDouble >= intervals.get(2).getStart() && aDouble< intervals.get(2).getEnd()) newList.add(13.0d);
                if (aDouble >= intervals.get(3).getStart() && aDouble< intervals.get(3).getEnd()) newList.add(16.0d);
                if (aDouble >= intervals.get(4).getStart() && aDouble< intervals.get(4).getEnd()) newList.add(21.0d);
                if (aDouble >= intervals.get(5).getStart() && aDouble< intervals.get(5).getEnd()) newList.add(24.0d);
                if (aDouble >= intervals.get(6).getStart() && aDouble< intervals.get(6).getEnd()) newList.add(29.0d);
        }
        return newList;
    }

    public void generateOnClick(MouseEvent mouseEvent) {
        calculations.generateRandomArray(Integer.parseInt(textAream.getText()), Integer.parseInt(textAreaM.getText()));
        double[] array = calculations.getArray();
        intervals.fillList(10, 0.0, 1.0, array);
        List<Event> events = eventList.fillTable();
        intervals2.fillListWithDiskreteValues(events, array);
        ObservableList<Interval> intervalsObservable = intervals.getIntervals();
        ObservableList<Interval> intervalsObservable2 = intervals2.getIntervals();
        ObservableList<Double> randomArray = FXCollections.observableArrayList(convertToList(array));
        mS1.setText("Математичне сподівання = " + calculations.calculateVibirkoveSerednye());
        dP1.setText("Дисперсія = " + calculations.calculateVybyrkovuDispersion());
        mS2.setText("Математичне сподівання = " + calculations.calculateMathHope(events));
        dP2.setText("Дисперсія = " + calculations.calculateDispersion(events));
        randomArrayListView1.setItems(randomArray);
        randomArrayListView2.setItems(modelingVV(intervalsObservable2, randomArray));
        interval1.setCellValueFactory(new PropertyValueFactory<Interval, String>("interval"));
        numberOfVariables1.setCellValueFactory(new PropertyValueFactory<Interval, Integer>("numberOfVariables"));
        frequency1.setCellValueFactory(new PropertyValueFactory<Interval, Double>("frequencyOfHits"));
        frequencyTable1.setItems(intervalsObservable);
        interval2.setCellValueFactory(new PropertyValueFactory<Interval, String>("interval"));
        numberOfVariables2.setCellValueFactory(new PropertyValueFactory<Interval, Integer>("numberOfVariables"));
        frequency2.setCellValueFactory(new PropertyValueFactory<Interval, Double>("frequencyOfHits"));
        frequencyTable2.setItems(intervalsObservable2);
        gistorgam.getData().clear();
        gistorgam.getXAxis().setLabel("Xi");
        gistorgam.getYAxis().setLabel("Pj");
        gistorgam.getData().add(createSeriesForGistogram("", intervalsObservable));
        lineChart.getData().clear();
        lineChart.getXAxis().setLabel("Xi");
        lineChart.getYAxis().setLabel("FrequencyOfHits");
        lineChart.getData().add(createSeriesForGraphics("", intervalsObservable2));


    }

    public XYChart.Series createSeriesForGistogram(String name, ObservableList<Interval> list){
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        for (Interval interval1 : list) {
            series.getData().add(new XYChart.Data(interval1.getInterval(), interval1.getFrequencyOfHits()));
        }

        return series;

    }

    public XYChart.Series createSeriesForGraphics(String name, ObservableList<Interval> list){
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        for (Interval interval1 : list) {
            series.getData().add(new XYChart.Data(interval1.getValueOfX(), interval1.getFrequencyOfHits()));
        }

        return series;

    }
}
