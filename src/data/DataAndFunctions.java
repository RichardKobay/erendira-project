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

    // Calculate the force between 2 charges
    public static double calcForce (double q1, double q2, double d) {
        return ((ke*q1*q2)/(Math.pow(d, 2)));
    }

    public static double calcForce (double q1, double q2, double q3, double d1, double d2) {
        double q1Toq2Force = ((ke*q1*q2)/(Math.pow(d1, 2)));
        double q2Toq3Force = ((ke*q2*q3)/(Math.pow(d2, 2)));

        double res = 0;

        if ((q1 > 0) && (q2 > 0) && (q3 > 0)) {
            res = q1Toq2Force - q2Toq3Force;
        }

        if ((q1 > 0) && (q2 < 0) && (q3 > 0)) {
            res = q1Toq2Force - q2Toq3Force;
        }

        if ((q1 > 0) && (q2 > 0) && (q3 < 0)) {
            res = q1Toq2Force + q2Toq3Force;
        }

        if ((q1 > 0) && (q2 < 0) && (q3 < 0)) {
            res = q1Toq2Force + q2Toq3Force;
        }

        if ((q1 < 0) && (q2 > 0) && (q3 > 0)) {
            res = q1Toq2Force + q2Toq3Force;
        }

        if ((q1 < 0) && (q2 < 0) && (q3 > 0)) {
            res = q1Toq2Force + q2Toq3Force;
        }

        if ((q1 < 0) && (q2 > 0) && (q3 < 0)) {
            res = q1Toq2Force + q2Toq3Force;
        }

        if ((q1 < 0) && (q2 < 0) && (q3 < 0)) {
            res = q1Toq2Force - q2Toq3Force;
        }

        return res;
    }

    public static double calcCharge (double q1, double f, double d) {
        /*
        * Formula:
        * ((f * Math.pow(d, 2))/(ke * q1))
        * */
        return ((f * Math.pow(d, 2))/(ke * q1));
    }
}
