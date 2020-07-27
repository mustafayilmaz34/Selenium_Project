package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Helper {
    WebDriver driver;
    WebDriverWait wait;

    public Helper() {
    }

    public Helper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    void waitForElementPresent(String x) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x)));
    }

    void findElementSendKeys(String x, String y) {
        driver.findElement(By.xpath(x)).sendKeys(y);
    }

    String findElementGetText(String x) {
        return driver.findElement(By.xpath(x)).getText();
    }

    void getSite(String x) {
        driver.get(x);
    }

    void findElementClick(String x) {
        driver.findElement(By.xpath(x)).click();
    }
    public void openBrowser(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
        driver = new ChromeDriver(capabilities);
        wait=new WebDriverWait(driver,10000);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    public void closeBrowser(){
        driver.quit();
    }
}
