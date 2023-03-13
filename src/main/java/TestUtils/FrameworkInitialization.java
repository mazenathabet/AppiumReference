package TestUtils;

import AndroidPageObjects.MainMenuPage;
import IOSPageObjects.TestAppPage;
import Utils.AppiumUtils;
import Utils.DriverContext;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class FrameworkInitialization {


    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected AndroidDriver driver;
    protected IOSDriver iosDriver;
    protected TestAppPage testAppPage;
    protected IOSPageObjects.MainMenuPage mainMenuPage1;
    protected MainMenuPage mainMenuPage;
    Properties properties = new Properties();

    @BeforeSuite(alwaysRun = true)
    public void startServer() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//data.properties");
        properties.load(fis);
        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : properties.getProperty("ipAddress");
        int port = System.getProperty("port") != null ? Integer.parseInt(System.getProperty("port")) : Integer.parseInt(properties.getProperty("port"));

        AppiumUtils.startAppiumServer(ipAddress,port);
    }

    @BeforeMethod(alwaysRun = true)
    public void startDriver() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//data.properties");
        properties.load(fis);
        String platform = properties.getProperty("Platform");

        if (platform.equalsIgnoreCase("Android")) {
            driver = DriverContext.getAndroidDriver();
            mainMenuPage = new MainMenuPage(driver);
        } else if (platform.equalsIgnoreCase("IOS")) {
            iosDriver = DriverContext.getIosDriver();
            mainMenuPage1 = new IOSPageObjects.MainMenuPage(iosDriver);
            testAppPage = new TestAppPage(iosDriver);
//            IosActions.lunchApp("com.apple.mobileslideshow");
        }
        System.out.println("Starting " + platform + " driver ... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
        if (iosDriver != null) {
            iosDriver.quit();
        }
        System.out.println("Tearing down the driver ... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
    }

    @AfterSuite(alwaysRun = true)
    public void stopServer() {
        AppiumUtils.stopAppiumServer();
    }
}
