package Internal.Math;

/**
 * Various helpful math functions for use throughout other classes.
 */
public class MathUtils {

    /**
     * Calculate the covariance of two sets of data.
     *
     * @param x
     *          The first set of data
     * @param y
     *          The second set of data
     * @return The covariance of x and y
     */
    public static double covariance(double[] x, double[] y) {
        double xmean = mean(x);
        double ymean = mean(y);

        double result = 0;

        for (int i = 0; i < x.length; i++) {
            result += (x[i] - xmean) * (y[i] - ymean);
        }

        result /= x.length - 1;

        return result;
    }

    /**
     * Calculate the mean of a data set
     *
     * @param data The data set to calculate the mean of
     * @return The mean of the data set
     */
    public static double mean(double[] data) {
        double sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        return sum / data.length;
    }

    /**
     * Calculate the variance of a data set
     *
     * @param data The data set to calculate the variance of
     * @return The variance of the data set
     */
    public static double variance(double[] data) {
        // Get the mean of the data set
        double mean = mean(data);

        double sumOfSquaredDeviations = 0;

        // Loop through the data set
        for (int i = 0; i < data.length; i++) {
            // sum the difference between the data element and the mean squared
            sumOfSquaredDeviations += Math.pow(data[i] - mean, 2);
        }

        // Divide the sum by the length of the data set - 1 to get our result
        return sumOfSquaredDeviations / (data.length - 1);
    }

    /**
     * Calculates the Pearson correlation between two categories.
     * @param categoryOne The first category to be processed that lies on the x-axis of a scatter plot.
     * @param categoryTwo The second category to be processed that lies on the y-axis of a scatter plot.
     * @return            A correlation value between 0 and 1 representing the correlation between the two sets of data.
     */
    public static double calculateCorrelation(double[] categoryOne, double[] categoryTwo){
        double cse142Avg = 0;
        double cse143Avg = 0;
        for(int i = 0; i < categoryOne.length; i++){
            cse142Avg += categoryOne[i];
            cse143Avg += categoryTwo[i];
        }
        cse142Avg /= categoryOne.length;
        cse143Avg /= categoryTwo.length;
        double[] cse142AColumn = new double[categoryOne.length];
        double[] cse143BColumn = new double[categoryTwo.length];
        double[] aColTimesB = new double[categoryOne.length];
        double[] aSquared = new double[categoryOne.length];
        double[] bSquared = new double[categoryTwo.length];
        for(int i = 0; i < categoryTwo.length; i++){
            cse142AColumn[i] = categoryOne[i] - cse142Avg;
            cse143BColumn[i] = categoryTwo[i] - cse143Avg;
            aColTimesB[i] = cse142AColumn[i] * cse143BColumn[i];
            aSquared[i] = cse142AColumn[i] * cse142AColumn[i];
            bSquared[i] = cse143BColumn[i] * cse143BColumn[i];
        }
        double aTimesBTotal, aSquaredTotal, bSquaredTotal;
        aTimesBTotal = aSquaredTotal = bSquaredTotal = 0;
        for(int i = 0; i < categoryTwo.length; i++){
            aTimesBTotal += aColTimesB[i];
            aSquaredTotal += aSquared[i];
            bSquaredTotal += bSquared[i];
        }
        return aTimesBTotal / Math.sqrt(aSquaredTotal * bSquaredTotal);
    }

    /**
     * Rounds a number to n places.
     * @param number  The number to be rounded.
     * @param n       The number of places to round the given number to.
     * @return        The rounded number.
     */
    public static double roundNPlaces(double number, int n){
        return (double) Math.round(number * Math.pow(10, n)) / Math.pow(10, n);
    }

}
