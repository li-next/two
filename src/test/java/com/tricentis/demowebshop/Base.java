package com.tricentis.demowebshop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    protected static WebDriver driver;

    @BeforeClass
    public static void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://demowebshop.tricentis.com/");
    }


    @AfterClass
    public static void end() {
        System.out.println("end");
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        //driver.quit();
    }
}
