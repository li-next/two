package com.tricentis.demowebshop;

import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


public class DemoWebShopTest extends Base{


    @Test
    @Parameterized.Parameters()
    public void signUp() {
        HomePage homePage = new HomePage(driver);
        SignUp signUp = homePage.clickSignUp();
        assertEquals("Register", signUp.getH1());
    }

}
