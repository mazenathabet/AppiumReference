package Utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IosActions extends AppiumUtils{

    protected static IOSDriver driver;
    protected WebDriverWait wait;

    public IosActions(IOSDriver driver) {
        IosActions.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
