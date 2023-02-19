package data;

public class DataAndFunctions {
    private static long ke = (long) 9E9;

    // Calculate the distance between 2 charges
    public static double calcDistance (double q1, double q2, double f) {
        return (Math.sqrt(((ke*q1*q2)/f)));
    }

    // Calculate the distance between 3 charges
    public static double[] calcDistance (double q1, double q2, double q3, double f1, double f2) {
        double q1Toq2Distance = Math.sqrt(((ke*q1*q2)/f1));
        double q2Toq3Distance = Math.sqrt(((ke*q2*q3)/f2));
        return new double[]{q1Toq2Distance, q2Toq3Distance};
    }

    public static double calcForce (double q1, double q2, double d) {
        return ((ke*q1*q2)/(Math.pow(d, 2)));
    }
}
