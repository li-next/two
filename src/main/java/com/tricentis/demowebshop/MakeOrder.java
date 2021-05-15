package com.tricentis.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MakeOrder {

    private WebDriver driver;
    private WebDriverWait wait;
    public MakeOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }



    @FindBy(xpath = "//select[@id='products-orderby']")
    private WebElement orderBy;

    @FindBy(xpath = "//div[@class='item-box']//input[1]")
    private WebElement firstProduct;



    @FindBy(xpath = "//li[@id='topcartlink']//span[@class='cart-label']")
    private WebElement shoppingCard;

    public void selectDropdown(int x) {
        Select dropdown = new Select(orderBy);
        dropdown.selectByIndex(x);
    }

    public void clickFirstProduct() {
        firstProduct.click();
    }


    public Card clickShoppingCard() {
        shoppingCard.click();
        return new Card(driver);
    }









}
