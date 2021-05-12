package com.tricentis.demowebshop;

import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


public class DemoWebShopTest extends Base{


    @Test
    public void signUp() {
        HomePage homePage = new HomePage(driver);
        SignUp signUp = homePage.clickSignUp();
        assertEquals(ReadProperties.getProperty("signUp"), signUp.getH1());
    }

    @Test
    public void signIn() {
        HomePage homePage = new HomePage(driver);
        SignIn signIn = homePage.clickSignIn();
        assertEquals(ReadProperties.getProperty("signIn"), signIn.h1());
        signIn.inputUser(ReadProperties.getProperty("email"), ReadProperties.getProperty("password"));
        assertEquals(ReadProperties.getProperty("email"), signIn.inputSuccessfully());
    }

}
