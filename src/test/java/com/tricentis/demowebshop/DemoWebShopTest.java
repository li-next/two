package com.tricentis.demowebshop;

import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DemoWebShopTest extends Base{


    @Test
    public void signUp() {
        homePage = new HomePage(driver);
        signUp = homePage.clickSignUp();
        assertEquals(ReadProperties.getProperty("signUp"), signUp.getH1());
    }



    @Test
    public void signIn() {
        homePage = new HomePage(driver);
        signIn = homePage.clickSignIn();
        assertEquals(ReadProperties.getProperty("signIn"), signIn.h1());
        signIn.inputUser(ReadProperties.getProperty("emailValid"), ReadProperties.getProperty("passwordValid"));
        assertEquals(ReadProperties.getProperty("emailValid"), signIn.inputSuccessfully());
    }

    @Test
    public void signInErr() {
        homePage = new HomePage(driver);
        signIn = homePage.clickSignIn();
        assertEquals(ReadProperties.getProperty("signIn"), signIn.h1());
        signIn.inputUser(ReadProperties.getProperty("emailNotValid"), ReadProperties.getProperty("passwordNotValid"));
        assertEquals(ReadProperties.getProperty("signInErrMsgSpan"), signIn.inputErrMsgSpan());
        assertEquals(ReadProperties.getProperty("signInErrMsgLi"), signIn.inputErrMsgLi());
    }

    @Test
    public void makeOrderProduct() {
        signIn();
        makeOrder = homePage.clickApparelShoes();
        assertEquals(ReadProperties.getProperty("apparelShoes"), driver.getTitle());
        makeOrder.selectDropdown(3);
        makeOrder.clickFirstProduct();
        card = makeOrder.clickShoppingCard();
        assertEquals(ReadProperties.getProperty("shoppingCard"), driver.getTitle());
        assertTrue(card.productTrue());
        card.clickCheckboxConsent();
        onePageCheckout = card.clickCheckout();
        assertEquals(ReadProperties.getProperty("checkout"), driver.getTitle());
        onePageCheckout.selectCountry(ReadProperties.getProperty("country"));
        onePageCheckout.selectStateProvince(ReadProperties.getProperty("stateProvince"));
        onePageCheckout.inputCity(ReadProperties.getProperty("city"));
        onePageCheckout.inputAddress1(ReadProperties.getProperty("address1"));
        onePageCheckout.inputZipCode(ReadProperties.getProperty("zipCode"));
        onePageCheckout.inputPhone(ReadProperties.getProperty("phone"));
        onePageCheckout.clickButton();
        assertEquals(ReadProperties.getProperty("makeOrderSuccess"), onePageCheckout.getMakeOrderSuccess());
        System.out.println("Order" + onePageCheckout.getOrderNumber());
        onePageCheckout.clickFinishButton();



    }

}
