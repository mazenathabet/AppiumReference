package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Utils.AppiumUtils.getScreenshotPath;

public class AndroidListeners implements ITestListener {

    ExtentReports extentReports = ExtentReportNG.getReporterObject();
    ExtentTest test;
    AppiumDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        test.log(Status.PASS, "Test Passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        try {driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());}
        catch (Exception e) {e.printStackTrace();}
        try {test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver),
                result.getMethod().getMethodName());}
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
//        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}