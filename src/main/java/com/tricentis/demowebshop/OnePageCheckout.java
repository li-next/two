package com.tricentis.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OnePageCheckout {

    private WebDriver driver;
    private WebDriverWait wait;
    public OnePageCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//select[@data-val-required='Country is required.']")
    private WebElement country;

    @FindBy(xpath = "//select[@id='BillingNewAddress_StateProvinceId']")
    private WebElement stateProvince;

    @FindBy(xpath = "//input[@data-val-required='City is required']")
    private WebElement city;

    @FindBy(xpath = "//input[@data-val-required='Street address is required']")
    private WebElement address1;

    @FindBy(xpath = "//input[@data-val-required='Zip / postal code is required']")
    private WebElement zipCode;

    @FindBy(xpath = "//input[@data-val-required='Phone is required']")
    private WebElement phone;

    @FindBy(xpath = "//div[@id='checkout-step-billing']//input[@title='Continue']")
    private WebElement firstButton;

    @FindBy(xpath = "//div[@id='checkout-step-shipping']//input[@title='Continue']")
    private WebElement secondButton;

    @FindBy(xpath = "//div[@id='checkout-step-shipping-method']//input[@value='Continue']")
    private WebElement threeButton;

    @FindBy(xpath = "//div[@id='checkout-step-payment-method']//input[@value='Continue']")
    private WebElement fourButton;

    @FindBy(xpath = "//div[@id='checkout-step-payment-info']//input[@value='Continue']")
    private WebElement fiveButton;

    @FindBy(xpath = "//input[@value='Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//ul[@class='details']/li")
    private WebElement orderNumber;

    @FindBy(xpath = "//div[@class='title']/strong")
    private WebElement makeOrderSuccess;

    @FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
    private WebElement finishButton;


    public void selectCountry(String str) {
        Select countryDropbox = new Select(country);
        countryDropbox.selectByVisibleText(str);
    }
    public void selectStateProvince(String str) {
        Select stateProvinceDropbox = new Select(stateProvince);
        stateProvinceDropbox.selectByVisibleText(str);
    }
    public void inputCity(String str) {
        city.sendKeys(str);
    }
    public void inputAddress1(String str) {
        address1.sendKeys(str);
    }
    public void inputZipCode(String str) {
        zipCode.sendKeys(str);
    }
    public void inputPhone(String str) {
        phone.sendKeys(str);
    }
    public void clickButton() {
        firstButton.click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        secondButton.click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        threeButton.click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        fourButton.click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        fiveButton.click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        confirmButton.click();
    }

    public String getMakeOrderSuccess() {
        return makeOrderSuccess.getText().trim();
    }

    public String getOrderNumber() {
        return orderNumber.getText().split(":")[1].trim();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

}
