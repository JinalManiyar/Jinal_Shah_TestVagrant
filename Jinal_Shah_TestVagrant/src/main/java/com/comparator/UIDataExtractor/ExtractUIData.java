package com.comparator.UIDataExtractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtractUIData {

    private final String cityName;
    private final WebDriver driver;

    public ExtractUIData(String cityName, WebDriver driver) {
        this.cityName = cityName;
        this.driver = driver;
    }

    public Float getTempValue (){

        WebElement tempValueElement = driver.findElement(By.xpath("//span[contains(text()," + cityName + ")]/following::span//b[contains(text(),'Temp in Degrees:')]"));
        String tempInDegrees = tempValueElement.getText();

        String tempNumber = tempInDegrees.replaceAll("[^0-9]", "");

        return Float.parseFloat(tempNumber);
    }

    public Float getHumidity (){
        WebElement humidityValueElement = driver.findElement(By.xpath("//span[contains(text()," + cityName + ")]/following::span//b[contains(text(),'Humidity: ')]"));
        String uiHumidityString1 = humidityValueElement.getText();
        String uiHumidityString2 = uiHumidityString1.replaceAll("[^0-9]", "");
        return Float.parseFloat(uiHumidityString2);
    }
}
