package data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class DataAndFunctions {
    private static long ke = (long) 9E9;

    // Calculate the distance between 2 charges
    public static double calcDistance (double q1, double q2, double f) {
        return (Math.sqrt(((ke*q1*q2)/f)));
    }

    // Calculate the distance between 3 charges
    @Contract("_, _, _, _, _ -> new")
    public static double @NotNull [] calcDistance (double q1, double q2, double q3, double f1, double f2) {
        double q1Toq2Distance = Math.sqrt(((ke*q1*q2)/f1));
        double q2Toq3Distance = Math.sqrt(((ke*q2*q3)/f2));
        return new double[]{q1Toq2Distance, q2Toq3Distance};
    }

    // Calculate the force between 2 charges
    public static double calcForce (double q1, double q2, double d) {
        return ((ke*q1*q2)/(Math.pow(d, 2)));
    }


    /*
    * CalcForce()
    *
    * This will calculate the resultant force between 3 charges.
    *
    * First will get the value of the three charges and then will calculate the resultant force between q1 and q2;
    * after that, will calculate the resultant force between q2 and q3; then will change for its absolute value
    *
    * Once the 2 values are obtained will calculate if the charges will add or subtract an then will return the final value
    *
    * @author: Ricardo Soriano
    * */
    public static double calcForce (double q1, double q2, double q3, double d1, double d2) {
        double q1Toq2Force = Math.abs(((ke*q1*q2)/(Math.pow(d1, 2))));
        double q2Toq3Force = Math.abs(((ke*q2*q3)/(Math.pow(d2, 2))));

        if (q1 > 0 && q2 < 0) {
            q1Toq2Force *= -1;
        }
        if (q1 < 0 && q2 > 0) {
                q1Toq2Force *= -1;
        }

        if (q2 < 0 && q3 < 0) {
            q2Toq3Force *= -1;
        }
        if (q2 > 0 && q3 > 0) {
            q2Toq3Force *= -1;
        }

        return q1Toq2Force + q2Toq3Force;
    }


    // Will calculate the force between 2 charges
    public static double calcCharge (double q1, double f, double d) {
        return ((f * Math.pow(d, 2))/(ke * q1));
    }
}
