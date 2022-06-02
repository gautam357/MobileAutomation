package com.aidash.base;

import com.aidash.config.ConfigReader;
import com.aidash.reports.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest{
    public static Properties prop;

    public static AppiumDriver<RemoteWebElement> capabilities() {
        AppiumDriver<RemoteWebElement> driver = null;
        prop = new Properties();
        InputStream input;
        try {
            prop = new Properties();
            input = new FileInputStream(
                    "/Users/gautamsingh/Documents/MobTestAutomation/src/main/java/com/aidash/config/config.properties");

            prop.load(input);
        } catch (Exception exp) {

            System.out.println(exp.getMessage());

            System.out.println(exp.getCause());

            exp.printStackTrace();

        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String plateform = "android";
        switch (plateform) {
//
//                case "ios":
//                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getIphoneDeviceName());
//                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getPlateFormName());
//                    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getIOSPlateformVersion());
//                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//                    capabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getIOSApp());
//                    try {
//                        driver = new IOSDriver<RemoteWebElement>(new URL(ConfigReader.getAppiumURL()), capabilities);
//                    } catch (MalformedURLException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                    break;


            case "android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getAndroidDeviceName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.platFormName());
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.androidAutomationName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getPlatFormVersion());
               // capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                capabilities.setCapability(MobileCapabilityType.APP, "/Users/gautamsingh/Downloads/IVMS-RM-avistaTest-09May2022-1239.apk");
                try {
                    driver = new AppiumDriver<RemoteWebElement>(new URL(ConfigReader.getAppiumURL()), capabilities);
                } catch (MalformedURLException e) {

                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

}
