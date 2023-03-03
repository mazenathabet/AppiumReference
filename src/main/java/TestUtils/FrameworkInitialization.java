package TestUtils;

import AndroidPageObjects.MainMenuPage;
import IOSPageObjects.TestAppPage;
import Utils.AppiumUtils;
import Utils.IosActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class FrameworkInitialization extends AppiumUtils {


    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected AndroidDriver driver;
    protected IOSDriver iosDriver;
    protected MainMenuPage mainMenuPage;
    protected TestAppPage testAppPage ;
    protected IOSPageObjects.MainMenuPage mainMenuPage1;

    @BeforeSuite(alwaysRun = true)
    public void startServer() throws IOException {
        AppiumUtils.startAppiumServer();
    }

    @BeforeMethod(alwaysRun = true)
    public void startDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//data.properties");
        properties.load(fis);
        String platform = properties.getProperty("Platform");
        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : properties.getProperty("ipAddress");

        if (platform.equalsIgnoreCase("Android")) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(properties.getProperty("AndroidDeviceName")); // name of the device or the emulator
            options.setApp(System.getProperty("user.dir") + properties.getProperty("AppiumBasicsApk")); // path of the apk
            options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
//            options.setCapability("browserName","Chrome"); to automate web apps
            driver = new AndroidDriver(new URL("http://" + ipAddress + ":" + Integer.parseInt(properties.getProperty("port"))), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            mainMenuPage = new MainMenuPage(driver);
        } else if (platform.equalsIgnoreCase("IOS")) {
            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName(properties.getProperty("IosDeviceName"));
//            options.setApp(System.getProperty("user.dir") + properties.getProperty("TestApp"));
//            options.setApp(System.getProperty("user.dir") + properties.getProperty("UIKitCatalogApp"));
            options.setPlatformVersion("16.2");
            // Appium will install WebDriverAgent in the Apple device so this WebDriverAgent will help to automate in IOS apps
            options.setWdaLaunchTimeout(Duration.ofSeconds(20));
            iosDriver = new IOSDriver(new URL("http://" + ipAddress + ":" + Integer.parseInt(properties.getProperty("port"))), options);
            //https://support.apple.com/en-eg/guide/deployment/depece748c41/web for all the bundleId
            iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            mainMenuPage1 = new IOSPageObjects.MainMenuPage(iosDriver);
            testAppPage = new TestAppPage(iosDriver);
            IosActions.lunchApp("com.apple.mobileslideshow");
        }
        System.out.println("Starting " + platform + " driver ... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        if(driver != null){driver.quit();}
        if(iosDriver != null){iosDriver.quit();}
        System.out.println("Tearing down the driver ... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
    }

    @AfterSuite(alwaysRun = true)
    public void stopServer() {
        AppiumUtils.stopAppiumServer();
    }
}
