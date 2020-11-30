package com.comparator.UIDataExtractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ValidateCityAndTemp {

    public boolean searchAndSelectCity(String cityName, WebDriver driver){

        weatherWebPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchCity(cityName, driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        selectCity(cityName, driver);

        return validateCityAndTemp(cityName, driver);
    }

    private static void weatherWebPage (WebDriver driver){
       //Find 3 dots to click to view menu where "Weather" is visible
        WebElement weatherSearch = driver.findElement(By.id("h_sub_menu"));
        weatherSearch.click();
        //Click on Weather menu
        WebElement weatherClick = driver.findElement(By.linkText("WEATHER"));
        weatherClick.click();
    }

    private static void searchCity (String name, WebDriver driver){
        // Under Pin your city search for given city name
        WebElement enterCity = driver.findElement(By.xpath("//input[@id='searchBox']"));
        enterCity.sendKeys(name);
    }

    private static void selectCity (String name, WebDriver driver){
        //select value based on search
        WebElement selectCityElement = driver.findElement(By.cssSelector("#" + name));
        //if the city is already checked then should not be selected
        if (!selectCityElement.isSelected()) {
            selectCityElement.click();
        }
    }

    private static boolean validateCityAndTemp (String name, WebDriver driver){
        //Validate presence of searched city element in map
        WebElement checkCityElement = driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]"));

        //Validate presence of temperature element in map w.r.t city
        WebElement checkTempElement = driver.findElement(By.xpath("//*[@title='" + name + "']//span[1][contains(@class,'tempRedText')]"));

        //click on city to get weather info
        checkCityElement.click();

        if ((checkCityElement.isDisplayed()) && (checkTempElement.isDisplayed()))
            return true;
        return false;
    }

}
