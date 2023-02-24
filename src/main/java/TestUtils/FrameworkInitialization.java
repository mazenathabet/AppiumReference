package TestUtils;

import PageObjects.MainMenuPage;
import Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class FrameworkInitialization extends AppiumUtils {

    String platform = "AndroidTests";
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected AndroidDriver driver;
    protected MainMenuPage mainMenuPage;
    @BeforeSuite(alwaysRun = true)
    public void startServer(){
        AppiumUtils.startAppiumServer();
    }
    @BeforeMethod(alwaysRun = true)
    public void startDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        if (platform.equalsIgnoreCase("AndroidTests")) {
            options.setDeviceName("Pixel4API30");
            options.setApp(System.getProperty("user.dir") + "//src//main//resources//ApiDemos-debug.apk");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } else if (platform.equalsIgnoreCase("IOS")) {
            System.out.println("IOS driver");
        }
        System.out.println("Starting "+platform+" driver ... "+"\n"+df.format(new Date())+
                "\n----------------------------------------------------------------");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainMenuPage = new MainMenuPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        driver.quit();
        System.out.println("Tearing down the driver ... "+"\n"+df.format(new Date())+
                "\n----------------------------------------------------------------");    }
    @AfterSuite(alwaysRun = true)
    public void stopServer(){
        AppiumUtils.stopAppiumServer();
    }
}
