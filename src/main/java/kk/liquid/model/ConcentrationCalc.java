package kk.liquid.model;

import static kk.liquid.model.LiquidBottle.ONE_DROP_WEIGHT;

/**
 * Created by tkrzy on 09.11.2016.
 */
public class ConcentrationCalc {
    private Converter converter;
    public ConcentrationCalc() {
        converter = new Converter(); // default scale to mili 1g = 1000mg
    }

    public double calculateConcentration(double firstVolumeML, double firstConcentrationPERCENT, double secondVolumeML, double secondConcentrationPERCENT) {
        return ((firstVolumeML * firstConcentrationPERCENT) + (secondVolumeML * secondConcentrationPERCENT)) / (firstVolumeML + secondVolumeML)*100;
    }

    public double calculateConcentration(int firstDropsNUM, double firstConcentrationPERCENT, int secondDropsNUM, double secondConcentrationPERCENT) {
        double firstVolumeML = firstDropsNUM* ONE_DROP_WEIGHT;
        double secondVolumeML = secondDropsNUM*ONE_DROP_WEIGHT;

        return calculateConcentration(firstVolumeML,firstConcentrationPERCENT,secondVolumeML,secondConcentrationPERCENT);
    }
}
