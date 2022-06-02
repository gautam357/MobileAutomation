package com.aidash.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
    private static final String OUTPUT_FOLDER = "./Report/";
    private static final String FILE_NAME = "ExtentReport1.html";
    static ExtentReports extent;

    public static ExtentReports extentReport() {
        // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        extent = new ExtentReports();
        htmlReporter.config().setReportName("Web Automation Results");
        htmlReporter.config().setDocumentTitle("Test Results");
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Report");
        extent.setSystemInfo("Environment", "Test Avista");
        extent.setSystemInfo("Tester", "Gautam Singh");
        extent.tryResolveMediaPath();
        extent.getStats();
        return extent;
    }

    public static void reportTearDown(){
        extent.flush();
    }
}
