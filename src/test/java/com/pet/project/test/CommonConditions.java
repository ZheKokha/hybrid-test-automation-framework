package com.pet.project.test;

import com.pet.project.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

    protected WebDriver driver;
    protected static final String USER_NAME = "AutoTestUser9";
    protected static final String PASSWORD = "Te13579@";

    @BeforeMethod()
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverManager.closeDriver();
    }
}
