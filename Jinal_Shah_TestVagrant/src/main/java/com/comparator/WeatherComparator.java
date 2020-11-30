package com.comparator;

import com.comparator.Util.DataReader;

import static java.lang.Math.abs;

public class WeatherComparator {

    private final int PERCENT = 100;
    private DataReader dataReader = new DataReader();

    public boolean compareTemperature(float uiTemp, float apiTemp){
        //get temperature variance value from user
        float tempVariance = dataReader.getTempVariance();

        //use abs to take care of negative values
        if(abs(uiTemp - apiTemp) <= tempVariance) {
            System.out.println("Temperature matches");
            System.out.println();
            return true;
        } else {
            System.out.println("Temperature doesn't match");
            System.out.println();
            return false;
        }
    }

    public boolean compareHumidity(float uiHumidity, float apiHumidity){
        float humidityVariance = dataReader.getHumidityVariance();

        if ((abs(uiHumidity - apiHumidity)) / PERCENT <= humidityVariance /PERCENT) {
            System.out.println("Humidity matches");
            System.out.println();
            return true;
        } else {
            System.out.println("Humidity doesn't match");
            System.out.println();
            return false;
        }
    }
}
