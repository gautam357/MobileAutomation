package com.aidash.listener;

import com.aidash.base.BaseTest;
import com.aidash.reports.ExtentReport;
import com.aidash.utilites.TestUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReport.extentReport();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    AppiumDriver<RemoteWebElement> driver = BaseTest.capabilities();

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        // TODO Auto-generated method stub
        // Screenshot
       // extentTest.get().fail(result.getThrowable());

        String testMethodName = result.getMethod().getMethodName();
        System.out.println("87687687676uyhgfjhgjhgvhjvjhvit787");
        System.out.println("87687687676uyhgfjhgjhgvhjvjhvit787"+testMethodName);
//        try {
//            TestUtility.takeScreenShort(testMethodName, driver);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//		try {
//			driver =   result.getTestClass().getRealClass().getDeclaredField(driver).get(result.getInstance());
//		} catch (Exception e) {
//
//		}
//        try {
//            extentTest.get().addScreenCaptureFromPath(TestUtility.takeScreenShort(testMethodName, driver),
//                    result.getMethod().getMethodName());
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();

    }
}
