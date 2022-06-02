package com.aidash.androidTestPages;

import com.aidash.pages.AndroidLogin;
import com.aidash.pages.CreateTree;
import com.aidash.utilites.TestUtility;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.aidash.base.BaseTest.capabilities;

public class CreateTreeTest {
    AppiumDriver<?> driver;
    CreateTree createTreeObj;
    AndroidLogin objLogin;

    @BeforeTest
    public void setUp() {
        driver = capabilities();
        createTreeObj = new CreateTree(driver);
        objLogin = new AndroidLogin(driver);
    }

    @Test(priority = 1)
    public void imagePageTestCase() throws IOException, InterruptedException {
        //objLogin.androidLoginTest();
        objLogin.andrLogin("sanjay@aidash.com", "aidash@4u", driver);
        String imgPageMsg = createTreeObj.openImagePage();
        if (imgPageMsg != null && imgPageMsg.equalsIgnoreCase("Add Images of the Danger")) {
            Assert.assertEquals(imgPageMsg, "Add Images of the Danger");
        } else {
            TestUtility.takeScreenShort("Error Plus Icon Button", driver);
        }

    }

    @Test(priority = 2, dependsOnMethods = "imagePageTestCase")
    public void moveToPlanDetailTest() throws IOException {
        String planDetailPageMsg = createTreeObj.moveToImagePage();
        if (planDetailPageMsg != null && planDetailPageMsg.equalsIgnoreCase("Tree Details")) {
            Assert.assertEquals(planDetailPageMsg, "Tree Details");
        } else {
            TestUtility.takeScreenShort("Error Image detail Page", driver);
        }
    }

    @Test(priority = 3, dependsOnMethods = "moveToPlanDetailTest")
    public void testMoveToLocationDetailPage() throws IOException, InterruptedException {
        String msgLocationPage = createTreeObj.moveToTreeDetailPage(driver);
        if (msgLocationPage != null && msgLocationPage.equalsIgnoreCase("Location Details")) {
            Assert.assertEquals(msgLocationPage, "Location Details");
        } else {
            TestUtility.takeScreenShort("Error tree detail Page", driver);
        }
    }

    @Test(priority = 4, dependsOnMethods = "testMoveToLocationDetailPage")
    public void testReportTree() throws IOException {
        String treeCreateDone = createTreeObj.moveToLocationDetailPage();
        if (treeCreateDone != null && treeCreateDone.equalsIgnoreCase("Completed")) {
            Assert.assertEquals(treeCreateDone, "Completed");
        } else {
            TestUtility.takeScreenShort("Error location detail Page", driver);
        }
    }

    @AfterTest
    public void closeApp() throws InterruptedException {
        Thread.sleep(4000);
       // driver.quit();
        driver.closeApp();
    }
}
