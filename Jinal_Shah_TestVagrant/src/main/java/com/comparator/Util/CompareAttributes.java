package com.comparator.Util;

import static java.lang.Math.abs;

public class CompareAttributes {

    public void compareTemperature(float uiTemp, float apiTemp){

        float tempVariance = DataReader.getTempVariance();

        System.out.println("--------TEMPERATURE------------");
        System.out.println("NDTV website: " + uiTemp + " C"+"\n"+"OpenWeather API: " + apiTemp + " C"+"\n");

        if(abs(uiTemp - apiTemp) <= tempVariance) {
            System.out.println("Temperature matches");
        } else {
            System.out.println("Temperature doesn't match");
        }
    }

    public void compareHumidity(float uiHumidity, float apiHumidity){

        float humidityVariance = DataReader.getHumidityVariance();

        System.out.println("----------HUMIDITY--------------");
        System.out.println("NDTV website: " + uiHumidity + "%"+"\n"+"OpenWeather API: " + apiHumidity + "%"+"\n");

        int PERCENT = 100;
        if ((abs(uiHumidity - apiHumidity)) / PERCENT <= humidityVariance / PERCENT) {
            System.out.println("Humidity matches");
        } else {
            System.out.println("Humidity doesn't match");
        }
    }

}
