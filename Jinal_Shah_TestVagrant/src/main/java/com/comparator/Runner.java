package com.comparator;

import com.comparator.APIDataExtractor.ExtractAPIData;
import com.comparator.UIDataExtractor.ExtractUIData;
import com.comparator.UIDataExtractor.ValidateCityAndTemp;
import com.comparator.Util.DataReader;
import com.comparator.Util.GetWebDriver;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class Runner {

    private static DataReader dataReader = new DataReader();
    private static ValidateCityAndTemp validateCityAndTemp = new ValidateCityAndTemp();
    private static float uiTemp, uiHumidity, apiTemp, apiHumidity;

    private static ExtractAPIData extractAPIData = new ExtractAPIData();
    private static WeatherComparator weatherComparator = new WeatherComparator();

    public static void main(String[] args) {

        //Get city name from user
        String cityName = dataReader.getCityName();

        WebDriver driver = GetWebDriver.getDriverDetails();

        //Search,select,validate and get value for temperature and humidity for entered city from NDTV website
        getUIData(cityName, driver);

        //Get API response and extract value for temperature and humidity for entered city by passing city in query
        getAPIData(cityName);

        driver.quit();

        //Print values of temperature and humidity from website and API
        printWeatherData();

        //Compare values of temperature and humidity
        weatherComparator.compareTemperature(uiTemp, apiTemp);
        weatherComparator.compareHumidity(uiHumidity,apiHumidity);


    }

    public static void getUIData(String cityName, WebDriver driver) {
        boolean check = validateCityAndTemp.searchAndSelectCity(cityName,driver);
        if(check) {
            uiTemp = ExtractUIData.getTempValue(cityName, driver);
            uiHumidity = ExtractUIData.getHumidity(cityName, driver);
        }
    }

    private static void getAPIData(String cityName) {
        Response response = extractAPIData.queryParameter(cityName);
        apiTemp = extractAPIData.getTempValue(response);
        apiHumidity = extractAPIData.getHumidityValue(response);
    }

    public static void printWeatherData () {
        System.out.println("--------TEMPERATURE------------");
        System.out.println("NDTV website: " + uiTemp + " C");
        System.out.println("OpenWeather API: " + apiTemp + " C");
        System.out.println();
        System.out.println("----------HUMIDITY--------------");
        System.out.println("NDTV website: " + uiHumidity + "%");
        System.out.println("OpenWeather API: " + apiHumidity + "%");
        System.out.println();
        System.out.println("-----------VARIANCE DETAILS----------");
    }
}
