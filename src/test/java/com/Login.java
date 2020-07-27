package com;
import org.openqa.selenium.JavascriptExecutor;

public class Login {
    static String pageLoadStatus = null;

    JavascriptExecutor js;
    public Helper wad;
    Login(){}
    public Login(Helper wad) {
        this.wad = wad;

    }

    public void clickLogin(){
        this.wad.waitForElementPresent("//i[@class='icon navigation-icon-user']");
        this.wad.findElementClick("//i[@class='icon navigation-icon-user']");
    }
    public void inputUsernameAndPassword(){
        this.wad.waitForElementPresent("//*[@id=\"loginSubmit\"]");
        this.wad.findElementSendKeys("//*[@id=\"email\"]","odevtest12@gmail.com");
        this.wad.findElementSendKeys("//*[@id=\"password\"]","test-1234");
    }
    public void loginSubmit() throws InterruptedException {
        Thread.sleep(1000);
        this.wad.waitForElementPresent("//*[@id=\"loginSubmit\"]");
        wad.findElementClick("//*[@id=\"loginSubmit\"]");
    }
    public void loginControl(){

            do {

                js = (JavascriptExecutor) wad.driver;

                pageLoadStatus = (String)js.executeScript("return document.readyState");

            } while ( !pageLoadStatus.equals("complete") );

            System.out.println("Page Loaded.");

    }

}
