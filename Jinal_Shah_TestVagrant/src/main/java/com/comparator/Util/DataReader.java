package com.comparator.Util;

import java.util.Scanner;

import static java.lang.StrictMath.abs;

public class DataReader {
    Scanner sc = new Scanner(System.in);
    public String getCityName() {
        System.out.print("Enter city name: ");
        if(sc.hasNext()){
            // convert city name in the format of 1st letter capital word regardless of how user entered it
        String name = sc.next().toLowerCase();
        String cityName = name.substring(0, 1).toUpperCase() + name.substring(1);
        return cityName;
        }
        else{
            System.out.println("No input found");
        }
     return null;
    }
    public float getTempVariance() {
        System.out.print("Enter temperature Variance: ");
        String tempValue = sc.next();
        float tempVariance = Float.parseFloat(tempValue);
        return (abs(tempVariance));
    }

    public float getHumidityVariance() {
        System.out.print("Enter humidity Variance: ");
        String humidityValue = sc.next();
        float humidityVariance = Float.parseFloat(humidityValue);
        return (abs(humidityVariance));
    }
}
