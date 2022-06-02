package com.aidash.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.touch.TouchActions;
//import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class CreateTree {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.aidash.vegetative.cycle.managment:id/nav_empty']")
    WebElement plusIcon;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@index='0']//android.widget.LinearLayout[@index='0']")
    WebElement reportTreeLink;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
    WebElement allowToPicFromDevice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Images of the Danger']")
    WebElement msgAddImagePage;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    WebElement skipButtonAddImage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Ok']")
    WebElement arDeviceMsg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tree Details']")
    WebElement msgConfirmOfTreeDetailPage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']//android.widget.FrameLayout[@index='2']//androidx.recyclerview.widget.RecyclerView[@index='1']//android.widget.LinearLayout[@index='0']")
    WebElement selectDistanceToLine;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.aidash.vegetative.cycle.managment:id/rv_tree_details_breastHeightRecycler']//android.widget.LinearLayout[@index='0']")
    WebElement diameterBreastHeight;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
    WebElement nextButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location Details']")
    WebElement msgLocationPage;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@index='3']//android.widget.LinearLayout[@index='0']")
    WebElement noOfPhases;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
    WebElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Completed']")
    WebElement confirmMsgTreeCreate;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='DONE']")
    WebElement doneButton;

    public String confirmImagePage() {
        return msgAddImagePage.getText();
    }

    public String confirmTreeDetailPage() {
        return msgConfirmOfTreeDetailPage.getText();
    }

    public String confirmLocationPage() {
        return msgLocationPage.getText();
    }

    public String confirmCompletedCreateTree() {
        return confirmMsgTreeCreate.getText();
    }

    public CreateTree(AppiumDriver<?> driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String openImagePage() throws InterruptedException {
        plusIcon.click();
        Thread.sleep(1000);
        reportTreeLink.click();
        allowToPicFromDevice.click();
        return confirmImagePage();
    }

    public String moveToImagePage() {
        skipButtonAddImage.click();
        arDeviceMsg.click();
        return confirmTreeDetailPage();
    }

    public String moveToTreeDetailPage(AppiumDriver driver) throws InterruptedException {
        selectDistanceToLine.click();
       // Thread.sleep(100);
        //Vertical Scroll
        MobileElement elm = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Diameter at Breast Height\"))"));
       // elm.click();

        //Horizontal Scroll
//        MobileElement elm1 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator
//                ("new UiScrollable(new UiSelector().resourceId(\"com.aidash.vegetative.cycle.managment:id/tv_onscreen_filter_item_text\").scrollable(true)).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"Diameter at Breast Height\"))"));


        diameterBreastHeight.click();
        nextButton.click();
        return confirmLocationPage();

    }

    public String moveToLocationDetailPage() {
        noOfPhases.click();
        submitButton.click();
        return confirmCompletedCreateTree();
    }

    public void completeCreateTreePage() {
        doneButton.click();
    }

}
