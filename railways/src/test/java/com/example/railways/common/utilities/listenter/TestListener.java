package com.example.railways.common.utilities.listenter;

import com.example.railways.common.utilities.Log;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info(result.getName() + " - Failed");
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("----------------------------------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName() + " - Passed");
    }
}
