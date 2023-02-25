package TestUtils;

import PageObjects.MainMenuPage;
import Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
    protected MainMenuPage mainMenuPage;

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
        UiAutomator2Options options = new UiAutomator2Options();
        if (platform.equalsIgnoreCase("Android")) {
            options.setDeviceName(properties.getProperty("AndroidDeviceName")); // name of the device or the emulator
            options.setApp(System.getProperty("user.dir") + properties.getProperty("AppiumBasicsApk")); // path of the apk
            driver = new AndroidDriver(new URL("http://" + ipAddress + ":" + Integer.parseInt(properties.getProperty("port"))), options);
        } else if (platform.equalsIgnoreCase("IOS")) {
            System.out.println("IOS driver");
        }
        System.out.println("Starting " + platform + " driver ... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainMenuPage = new MainMenuPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        driver.quit();
        System.out.println("Tearing down the driver ... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
    }

    @AfterSuite(alwaysRun = true)
    public void stopServer() {
        AppiumUtils.stopAppiumServer();
    }
}
