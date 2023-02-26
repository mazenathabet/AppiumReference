package IOSPageObjects;

import IOSPageObjects.AlertViews.AlertViewsPage;
import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class MainMenuPage extends IosActions {

    public MainMenuPage(IOSDriver driver) {
        super(driver);
    }

    By ALERT_VIEWS = AppiumBy.accessibilityId("Alert Views");

    public AlertViewsPage clickAlertViews(){
        driver.findElement(ALERT_VIEWS).click();
        return new AlertViewsPage(driver);
    }
}
