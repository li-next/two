package com.tricentis.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//a[@class='ico-register']")
    private WebElement signUpLocated;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement signInLocated;

    public SignUp clickSignUp() {
        signUpLocated.click();
        return new SignUp(driver);
    }

    public SignIn clickSignIn() {
        signInLocated.click();
        return  new SignIn(driver);
    }
}
