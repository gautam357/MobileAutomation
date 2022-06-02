package com.aidash.utilites;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtility {

    public static final long WAIT = 10;

    public static String takeScreenShort(String testCaseName, AppiumDriver<?> driver) throws IOException {
        System.out.println("fgdggdfgfdgfdg3545346545645//////////" +testCaseName);
        TakesScreenshot screen = (TakesScreenshot) driver;
        System.out.println("this is screenshot page");
        File source = screen.getScreenshotAs(OutputType.FILE);
        System.out.println("fgdggdfgfdgfdg35453465456dfdsf45");
        String scrnShot = "./Screenshot/" + testCaseName + ".png";
        System.out.println("fgdggdfgfdgfdg35453465456454545445");
        FileUtils.copyFile(source, new File(scrnShot));
//        System.out.println("fgdggdfgfdgfdg3545346545645");
//        File srcFile=driver.getScreenshotAs(OutputType.FILE);
//        System.out.println("fgdggdfgfdgfdg3545346545645ggg");
//        String filename= UUID.randomUUID().toString();
//        System.out.println("fgdggdfgfdgfdg3545346545645jjjj");
//        File targetFile=new File("./Screenshot/" + filename +".jpg");
//        System.out.println("fgdggdfgfdgfdg35453465456459999999");
//        FileUtils.copyFile(srcFile,targetFile);
//        System.out.println("fgdggdfgfdgfdg354534654564599999999999999");
//        return String.valueOf(targetFile);
        return scrnShot;
    }


}