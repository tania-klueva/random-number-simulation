package sample.calc;

public interface Calculations {

    static double[] generateRandomArray(int min, int max, int n) {
        double[] randomArray = new double[n];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (Math.random() * ((max - min) + 1)) + min;
        }
        return randomArray;
    }

    double calculateVibirkoveSerednye(double[] array);

    double calculateVybyrkovuDispersion(double[] array);

    double calculateKvVidhylennia(double[] array);

    double koefKoreliatsii(double[] x, double[] y);
}
