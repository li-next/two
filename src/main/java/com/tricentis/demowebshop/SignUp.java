package com.tricentis.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignUp {

    private WebDriver driver;
    private WebDriverWait wait;
    public SignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//h1")
    private WebElement h1Located;

    public String getH1() {
        return h1Located.getText();
    }
}
