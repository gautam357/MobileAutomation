package com.aidash.pages;

import com.aidash.config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidLogin {
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='email']")
    WebElement emailText;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    WebElement pwdText;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='btn-login']")
    WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='While using the app']")
    WebElement locationPopUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='List View']")
    WebElement getTextLoginConfirm;

    @AndroidFindBy(xpath = "//android.widget.Image[@text='aidash']")
    WebElement openLoginPageVerification;

    public AndroidLogin(AppiumDriver<?> driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String openLoginPage() throws InterruptedException {
        Thread.sleep(200);
        return openLoginPageVerification.getText();
    }

    public String andrLogin(String usr, String pwd, AppiumDriver<?> driver) throws InterruptedException {
        Thread.sleep(100);
//        String getLocationPermission = ConfigReader.getLocationPermission();
//        String actualLocationPermission = driver.findElementByAccessibilityId(getLocationPermission).getText();
//        try {
//            if(actualLocationPermission.equalsIgnoreCase(getLocationPermission)) {
//                driver.findElementByAccessibilityId(getLocationPermission).click();
//            }
//        }
//        catch (Exception NoSuchElementException) {
//            emailText.sendKeys(usr);
//            pwdText.sendKeys(pwd);
//            loginButton.click();
//            driver.findElementByAccessibilityId(getLocationPermission).click();
//        }
        emailText.sendKeys(usr);
        pwdText.sendKeys(pwd);
        Thread.sleep(100);
        loginButton.click();
        Thread.sleep(4000);
        locationPopUp.click();
        return getTextLoginConfirm.getText();
    }
}
