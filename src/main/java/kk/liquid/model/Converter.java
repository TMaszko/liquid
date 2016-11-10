package kk.liquid.model;

import java.util.Map;

/**
 * Created by tkrzy on 09.11.2016.
 */
public  class Converter {
    // all units scales with default scale but values are in meters
    private final String ERROR_MSG_WRONG_UNIT = "wrong unit";
    private final String ERROR_MSG_WRONG_NUM = "wrong number";
    private final static double DEFAULT_SCALE_UNIT = 1000;
    private final double MILI = 0.001;
    private final double DEC = 10;
    private final double HEKTO = 100;
    private final double KILO = 1000;
    private double currentScaleUNIT;
    private final int ERROR = -1;
    private Map<String,Double> unitMap;
    public Converter(){
        this(DEFAULT_SCALE_UNIT);
    }
    public Converter(double scale){
        currentScaleUNIT = scale;
        initializeUnitMap();
    }
    public double convertNumber(double numToConvert,String unitFrom,String unitTo){
        if (unitFrom != "") {
            if (!isErrorPositiveNum(numToConvert) && !isErrorGettingUnitFromMap(unitFrom)
                    && !isErrorGettingUnitFromMap(unitTo)) {
                return unitMap.get(unitFrom) / unitMap.get(unitTo) * numToConvert;
            } else {
                return numToConvert/unitMap.get(unitTo);
            }
        }
        return ERROR;
    }
    public double convertNumberToPercent(double numToConvert){
       return  convertNumber(numToConvert,"","%");
    }
    public void initializeUnitMap() {
        unitMap.put("mg", currentScaleUNIT *MILI);
        unitMap.put("g", currentScaleUNIT *1);
        unitMap.put("dag", currentScaleUNIT *DEC);
        unitMap.put("kg", currentScaleUNIT *KILO);
        unitMap.put("ml", currentScaleUNIT *MILI);
        unitMap.put("l", currentScaleUNIT *1);
        unitMap.put("hl", currentScaleUNIT *HEKTO);
        unitMap.put("%",0.01);
    }
    public void checkValue(double numToConvert) throws Exception {
        if(numToConvert < 0 || numToConvert == Double.POSITIVE_INFINITY) {
            throw new Exception(ERROR_MSG_WRONG_NUM);
        }
    }
    public boolean isErrorPositiveNum(double numToConvert) {
        try {
            checkValue(numToConvert);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
    public void setNewScale(double newScale) {
        currentScaleUNIT = newScale;
        unitMap.clear();
        initializeUnitMap();
    }
    public double getScaleUNIT() {
        return currentScaleUNIT;
    }
    public boolean isErrorGettingUnitFromMap(String key){
        try {
            checkUnitsMap(key);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
    public void checkUnitsMap(String key) throws Exception {
        if (!unitMap.containsKey(key)) {
            throw new Exception(ERROR_MSG_WRONG_UNIT);
        }
    }
}
