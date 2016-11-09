package kk.liquid.model;

/**
 * Created by tkrzy on 09.11.2016.
 */
public class ConcentrationCalc {
    private final double ONE_DROP_WEIGHT = 40 / 1000; // mg -> g

    ConcentrationCalc() {
    }

    public double calculate(double weight1, double concentration1, double weight2, double concentration2) {
        return ((weight1 * concentration1) + (weight2 * concentration2)) / weight1 + weight2;
    }

    public double calculate(int drops1, double concentration1, int drops2, double concentration2) {
        double weight1 = (drops1*ONE_DROP_WEIGHT);
        double weight2 = (drops2*ONE_DROP_WEIGHT);

        return calculate(weight1,concentration1,weight2,concentration2);
    }
}
