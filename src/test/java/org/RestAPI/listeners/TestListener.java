package org.RestAPI.listeners;

import io.qameta.allure.Allure;
import org.RestAPI.Base.CommontoAll;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends CommontoAll
        implements ITestListener {

    @Override
    public void onTestStart(
            ITestResult result) {

        System.out.println(
                "STARTED : "
                        + result.getName()
        );
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        System.out.println(
                "PASSED : "
                        + result.getName()
        );
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        System.out.println(
                "FAILED : "
                        + result.getName()

        );
        Allure.addAttachment(
                "Failed Response",
                response.asString()
        );

    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        System.out.println(
                "SKIPPED : "
                        + result.getName()
        );
    }
}