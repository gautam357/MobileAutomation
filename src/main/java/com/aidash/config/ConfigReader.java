package com.aidash.config;

import com.aidash.base.BaseTest;

public class ConfigReader extends BaseTest {
    public static String getAppiumURL() {

        return prop.getProperty("appiumURL");
    }

    public static String androidAutomationName() {

        return prop.getProperty("androidAutomationName");
    }

    public static String platFormName() {

        return prop.getProperty("platFormName");
    }

    public static String getAndroidAppActivity() {

        return prop.getProperty("androidAppActivity");
    }

    public static String getAndroidAppLocation() {

        return prop.getProperty("androidAppLocation");
    }

    public static String getOpenVerificationLoginPage() {

        return prop.getProperty("openVerificationLoginPage");
    }

    public static String getAndroidAutomationName() {
        return prop.getProperty("androidAutomationName");
    }

    public static String getAndroidDeviceName() {
        return prop.getProperty("androidDeviceName");
    }

    public static String getUserName() {
        return prop.getProperty("userName");
    }

    public static String getUserPassword() {
        return prop.getProperty("userPassword");
    }

    public static String getPlatFormVersion() {
        return prop.getProperty("platFormVersion");
    }



}
