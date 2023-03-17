package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Utils.AppiumUtils.getScreenshotPath;

public class IosListeners implements ITestListener {
    ExtentReports extentReports = ExtentReportNG.getReporterObject();
    ExtentTest test;
    AppiumDriver driver;

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
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
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
    }
}
