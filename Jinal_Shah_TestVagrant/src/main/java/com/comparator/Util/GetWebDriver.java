package com.comparator.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GetWebDriver {

    public static WebDriver getDriverDetails() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ndtv.com");

        try {
            WebDriverWait wait = new WebDriverWait(driver,50);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='notnow']")));
            driver.findElement(By.xpath("//a[@class='notnow']")).click();
        } catch (Exception e) {}
        return driver;
    }
}
