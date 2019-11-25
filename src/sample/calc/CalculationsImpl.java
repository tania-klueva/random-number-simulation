package sample.calc;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class CalculationsImpl implements Calculations {


    @Override
    public double calculateVibirkoveSerednye(double[] array) {
        return getSum(array, DoubleUnaryOperator.identity()) / array.length;
    }

    @Override
    public double calculateVybyrkovuDispersion(double[] array) {
        return getSum(array, x -> Math.pow(x - calculateVibirkoveSerednye(array), 2)) / array.length;
    }

    @Override
    public double calculateKvVidhylennia(double[] array) {
        return Math.sqrt(calculateVybyrkovuDispersion(array));
    }

    @Override
    public double koefKoreliatsii(double[] x, double[] y) {
        return getSum(x, y, (xValue, yValue) -> (xValue - calculateVibirkoveSerednye(x)) * (yValue - calculateVibirkoveSerednye(y))) /
                Math.sqrt(getSum(x, xValue -> Math.pow(xValue - calculateVibirkoveSerednye(x), 2)) * getSum(y, yValue -> Math.pow(yValue - calculateVibirkoveSerednye(y), 2)));
    }

    public double getSum(double[] array, DoubleUnaryOperator function) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += function.applyAsDouble(array[i]);
        }
        return sum;
    }

    public double getSum(double[] x, double[] y, DoubleBinaryOperator function) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += function.applyAsDouble(x[i], y[i]);
        }
        return sum;
    }

    public void printArr(double[] array) {
        for (double v : array) {
            System.out.printf("%.15f\t", v);
        }
        System.out.println();
    }
}
