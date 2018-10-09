package sample;

import javafx.collections.ObservableList;

import java.util.Arrays;

public class CalculationsImpl implements Calculations {

    private double[] array = new double[1000];

    @Override
    public double calculateVibirkoveSerednye() {
        double sum = 0;
        for (int i = 0; i < this.array.length; i++) {
            sum += this.array[i];
        }
        return sum/this.array.length;
    }

    @Override
    public double calculateMathHope(ObservableList<Event> list) {

        double mathHope = 0;

        for (Event event : list) {
            mathHope+=event.getX()*event.getP();
        }
        return mathHope;
    }

    @Override
    public double calculateMathHope(ObservableList<Event> list, int pow) {
        double mathHope = 0;

        for (Event event : list) {
            mathHope+=Math.pow(event.getX(), pow)*event.getP();
        }
        return mathHope;
    }

    @Override
    public double calculateVybyrkovuDispersion() {
        double sum = 0;
        for (int i = 0; i < this.array.length; i++) {
            sum += Math.pow(this.array[i] - calculateVibirkoveSerednye(), 2);
        }
        return sum/(this.array.length-1);
    }

    @Override
    public double calculateDispersion(ObservableList<Event> list) {
        return calculateMathHope(list, 2) - Math.pow(calculateMathHope(list), 2);
    }

    public void generateRandomArray(int m, int M){
        array[0]= Math.pow(2, -m);
        for (int i = 1; i < array.length; i++) {
            array[i] = (M * array[i-1])%1;
        }
    }

    public void printArr(){
        for (double v : array) {
            System.out.printf("%.15f",v);
            System.out.println();
        }
    }

    public double[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "CalculationsImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
