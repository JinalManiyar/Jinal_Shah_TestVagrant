package com.comparator.UIDataExtractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ValidateCityAndTemp {

    private final String cityName;
    private final WebDriver driver;

    public ValidateCityAndTemp(String cityName, WebDriver driver) {
        this.cityName = cityName;
        this.driver = driver;
    }
    public boolean validateCityAndTemp(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        weatherWebPage();

        searchAndSelectCityLocator();

        WebElement checkCityElement = driver.findElement(By.xpath("//div[contains(text(),'" + cityName + "')]"));

        WebElement checkTempElement = driver.findElement(By.xpath("//*[@title='" + cityName + "']//span[1][contains(@class,'tempRedText')]"));

        checkCityElement.click();

        return (checkCityElement.isDisplayed()) && (checkTempElement.isDisplayed());
    }

    private  void weatherWebPage(){
        WebElement weatherSearch = driver.findElement(By.id("h_sub_menu"));
        weatherSearch.click();

        WebElement weatherClick = driver.findElement(By.linkText("WEATHER"));
        weatherClick.click();

    }

    private  void searchAndSelectCityLocator(){

        WebElement enterCity = driver.findElement(By.xpath("//input[@id='searchBox']"));
        enterCity.sendKeys(cityName);

        WebElement selectCityElement = driver.findElement(By.cssSelector("#" + cityName));

        if (!selectCityElement.isSelected())
            selectCityElement.click();
    }
}
