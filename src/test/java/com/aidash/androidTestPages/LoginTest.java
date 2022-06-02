package com.aidash.androidTestPages;

import com.aidash.config.ConfigReader;
import com.aidash.pages.AndroidLogin;
import com.aidash.utilites.TestUtility;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.aidash.base.BaseTest.capabilities;

public class LoginTest {
    AndroidLogin andrLoginObject;
    AppiumDriver<?> driver;

    @BeforeTest
    public void setUp() {
        driver = capabilities();
        andrLoginObject = new AndroidLogin(driver);
    }

    @Test(priority = 1)
    public void androidLoginTest() throws InterruptedException, IOException {
        String confirmOpenLoginPage = andrLoginObject.openLoginPage();
        if (confirmOpenLoginPage.equalsIgnoreCase("adash")) {
            Assert.assertEquals(confirmOpenLoginPage, "aidash");
        } else {
            TestUtility.takeScreenShort("Open Login Page", driver);
        }
        String confirmLogin = andrLoginObject.andrLogin(ConfigReader.getUserName(), ConfigReader.getUserPassword(), driver);
        if (confirmLogin.equalsIgnoreCase("List View")) {
            Assert.assertEquals(confirmLogin, "List View");
        } else {
            TestUtility.takeScreenShort("User Login", driver);
        }

    }

    @AfterTest
    public void closeApp() throws InterruptedException {
        Thread.sleep(4000);
       // driver.quit();
        driver.closeApp();
    }
}
