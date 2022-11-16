package com.example.railways.common.utilities.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.helpers.ConfigFileReader;

public class ExtentManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(Utilities.getProjectPath() + ConfigFileReader.getValue("exportExtendsReportPath"));
        reporter.config().setReportName("Railways Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java");
        extentReports.setSystemInfo("Author", "Hang Vo");
        return extentReports;
    }
}