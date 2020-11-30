package com.comparator;

import com.comparator.APIDataExtractor.ExtractAPIData;
import com.comparator.UIDataExtractor.ExtractUIData;
import com.comparator.UIDataExtractor.ValidateCityAndTemp;
import com.comparator.Util.CompareAttributes;
import com.comparator.Util.DataReader;
import com.comparator.Util.GetWebDriver;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

import static java.lang.Math.abs;

public class WeatherComparator {
    String cityName;
    WebDriver driver;
    Float uiTemp,uiHumidity,apiTemp,apiHumidity;

    public void init() throws InterruptedException {
        cityName = DataReader.getCityName();
        driver = GetWebDriver.getDriverDetails();
    }

    public void execute() {

        ValidateCityAndTemp validateCityAndTemp = new ValidateCityAndTemp(cityName,driver);
        ExtractUIData extractUIData = new ExtractUIData(cityName,driver);
        ExtractAPIData extractAPIData = new ExtractAPIData(cityName);
        CompareAttributes compareAttributes = new CompareAttributes();

        if(validateCityAndTemp.validateCityAndTemp()) {
            uiTemp = extractUIData.getTempValue();
            uiHumidity = extractUIData.getHumidity();

            Response response = extractAPIData.queryParameter();
            apiTemp = extractAPIData.getTempValue(response);
            apiHumidity = extractAPIData.getHumidityValue(response);

            driver.quit();

            compareAttributes.compareTemperature(uiTemp, apiTemp);
            compareAttributes.compareHumidity(uiHumidity, apiHumidity);
        }
        else {
            System.out.println("City name is not valid");
            driver.quit();
        }
    }
}
