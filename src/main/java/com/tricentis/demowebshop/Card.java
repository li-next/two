package com.tricentis.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Card {

    private WebDriver driver;
    private WebDriverWait wait;
    public Card(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @FindBy(xpath = "//tr[@class='cart-item-row']")
    private WebElement product;

    @FindBy(xpath = "//input[@id='termsofservice']")
    private WebElement checkboxConsent;

    @FindBy(xpath = "//button[@class='button-1 checkout-button']")
    private WebElement checkout;


    public boolean productTrue() {
        return product.isDisplayed();
    }

    public void clickCheckboxConsent() {
        checkboxConsent.click();
    }
    public OnePageCheckout clickCheckout() {
        checkout.click();
        return new OnePageCheckout(driver);
    }
}
