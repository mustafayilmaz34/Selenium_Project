package com;

public class Search {
    private Helper wad;
    Search(){}
    public Search(Helper wad){
        this.wad = wad;
    }

    public void searchText(){
        this.wad.waitForElementPresent("//*[@id=\"accountBtn\"]/div[1]/a/i");
        this.wad.findElementSendKeys("//*[@id=\"auto-complete-app\"]/div/div/input","Bilgisayar");
    }
    public void clickSearchButton() throws InterruptedException {
            Thread.sleep(500);
            this.wad.findElementClick("//*[@id=\"auto-complete-app\"]/div/div/i");
    }
}
