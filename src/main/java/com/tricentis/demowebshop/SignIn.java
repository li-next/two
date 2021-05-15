package com.tricentis.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignIn {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passInput;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    private WebElement buttonInput;

    @FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
    private WebElement signInSuccessfully;

    @FindBy(xpath = "//div[@class='validation-summary-errors']/span")
    private WebElement signInErrSpan;

    @FindBy(xpath = "//div[@class='validation-summary-errors']//li")
    private WebElement signInErrLi;


    @FindBy(xpath = "//h1")
    private WebElement h1;

    public String h1() {
        return h1.getText();
    }

    public void inputUser(String email, String password) {
        emailInput.sendKeys(email);
        passInput.sendKeys(password);
        buttonInput.click();

    }
    public String inputSuccessfully() {
        return signInSuccessfully.getText();
    }
    public String inputErrMsgSpan() {
        return signInErrSpan.getText();
    }
    public String inputErrMsgLi() {
        return signInErrLi.getText();
    }
}
