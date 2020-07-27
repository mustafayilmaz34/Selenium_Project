package com;

public class Start {
    Helper wad;

    Start() {
    }

    public Start(Helper wad) {
        this.wad = wad;
    }

    public void navigateToTrendyolPage() {
        this.wad.getSite("https://www.trendyol.com/");
    }

    public void closePopup() {
        this.wad.waitForElementPresent("//*[@title='Close']");
        this.wad.findElementClick("//*[@title='Close']");
    }

    public void controlPageIsLoaded() {
        this.wad.waitForElementPresent("//img[@src='https://cdn.dsmcdn.com/web/logo/ty-logo.svg']");
    }

}