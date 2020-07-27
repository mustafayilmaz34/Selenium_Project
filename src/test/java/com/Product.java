package com;

import java.util.Random;

public class Product {
    Helper wad;
    int index;
    String priceOnPage, priceOnBasket;

    Product() {
    }

    public Product(Helper wad) {
        this.wad = wad;
    }

    public void chooseProduct() {
        this.wad.waitForElementPresent("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/a/div[1]/div/img");
        Random rnd = new Random();
        index = rnd.nextInt(24) + 1;
    }

    public void clickProduct() {
        this.wad.findElementClick("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[" + index
                + "]/div[1]/a/div[1]/div/img");
    }

    public void priceOnPage() throws InterruptedException {
        Thread.sleep(2000);
        this.wad.waitForElementPresent("(//*[@class='pr-bx-w']//span[@class='prc-slg'])[1]");
        String price = this.wad.findElementGetText("(//*[@class='pr-bx-w']//span[@class='prc-slg'])[1]");
        priceOnPage = price;
    }

    public void addToBasket() {
        this.wad.waitForElementPresent("//div[@class='add-to-bs-tx']");
        this.wad.findElementClick("//div[@class='add-to-bs-tx']");
    }

    public void navigateToBasket() {
        this.wad.waitForElementPresent("//i[@class='icon navigation-icon-basket']");
        this.wad.findElementClick("//i[@class='icon navigation-icon-basket']");
    }

    public void priceOnBasket() {
        this.wad.waitForElementPresent("//dd[@class='total-price']");
        String totalPrice = this.wad.findElementGetText("//dd[@class='total-price']");
        priceOnBasket = totalPrice;
    }
    public void assertPrices() {
        if (priceOnPage.equals(priceOnBasket)) {
            System.out.println("Prices are the same");
        } else {
            System.out.println("Prices are not the same");
        }
    }

    public void increaseProduct() throws InterruptedException {
            Thread.sleep(1000);
            this.wad.findElementClick("//*[@class='ty-numeric-counter-button']");
    }

    public void deleteProduct() throws InterruptedException {
        Thread.sleep(1000);
        this.wad.waitForElementPresent("//i[@class='i-trash']");
        this.wad.findElementClick("//i[@class='i-trash']");
        this.wad.waitForElementPresent("//span[@ng-if='!isLoading.remove']");
        this.wad.findElementClick("//span[@ng-if='!isLoading.remove']");
    }

}
