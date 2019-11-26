package sample.calc;

public interface Calculations {

    static double[] generateRandomArray(int min, int max, int n) {
        double[] randomArray = new double[n];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (Math.random() * ((max - min) + 1)) + min;
        }
        return randomArray;
    }

    static double getMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    static double getMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    double calculateVibirkoveSerednye(double[] array);

    double calculateVybyrkovuDispersion(double[] array);

    double calculateKvVidhylennia(double[] array);

    double koefKoreliatsii(double[] x, double[] y);

    double[] generateNormArray(int a, int b, int n, double u, double o, int N);
}
