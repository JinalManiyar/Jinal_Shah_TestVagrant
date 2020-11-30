package com.comparator;

import com.comparator.APIDataExtractor.ExtractAPIData;
import com.comparator.UIDataExtractor.ExtractUIData;
import com.comparator.UIDataExtractor.ValidateCityAndTemp;
import com.comparator.Util.DataReader;
import com.comparator.Util.GetWebDriver;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class Runner {

    WeatherComparator weatherComparator = new WeatherComparator();

    public static void main(String[] args) throws InterruptedException {

        Runner runner = new Runner();

        runner.weatherComparator.init();

        runner.weatherComparator.execute();
    }
}
