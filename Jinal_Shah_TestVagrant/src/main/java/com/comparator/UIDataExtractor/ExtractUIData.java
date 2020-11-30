package com.comparator.UIDataExtractor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtractUIData {
    public static Float getTempValue (String name, WebDriver driver){
        // Check for webelement for temperature value in pop up
        WebElement tempValueElement = driver.findElement(By.xpath("//span[contains(text()," + name + ")]/following::span//b[contains(text(),'Temp in Degrees:')]"));
        String tempInDegrees = tempValueElement.getText();
        //parse temperature value from webelement
        String tempNumber = tempInDegrees.replaceAll("[^0-9]", "");
        //Cast to float data type for better comparison
        Float uiTemp = Float.parseFloat(tempNumber);
        return uiTemp;
    }

    public static Float getHumidity (String name, WebDriver driver){
        WebElement humidityValueElement = driver.findElement(By.xpath("//span[contains(text()," + name + ")]/following::span//b[contains(text(),'Humidity: ')]"));
        String uiHumidityString1 = humidityValueElement.getText();
        String uiHUmidityString2 = uiHumidityString1.replaceAll("[^0-9]", "");
        Float uiHumidity = Float.parseFloat(uiHUmidityString2);
        return uiHumidity;
    }
}
