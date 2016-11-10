package kk.liquid.model;

/**
 * Created by tkrzy on 09.11.2016.
 */
public class LiquidBottle {
    // weight in g but scales  in converter
    public static  final double ONE_DROP_WEIGHT = 0.004;
    private double currentDropVolume;
    private double capacity;

    public LiquidBottle(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {

        this.capacity = capacity;
    }
}
