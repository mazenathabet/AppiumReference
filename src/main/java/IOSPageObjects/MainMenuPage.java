package IOSPageObjects;

import IOSPageObjects.AlertViews.AlertViewsPage;
import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class MainMenuPage extends IosActions {

    By ALERT_VIEWS = AppiumBy.accessibilityId("Alert Views");
    By STEPPERS = AppiumBy.accessibilityId("Steppers");
    By WEB_VIEW = AppiumBy.accessibilityId("Web View");
    By PICKER_VIEW = AppiumBy.accessibilityId("Picker View");

    public MainMenuPage(IOSDriver driver) {
        super(driver);
    }

    public AlertViewsPage clickAlertViews() {
        driver.findElement(ALERT_VIEWS).click();
        return new AlertViewsPage((IOSDriver) driver);
    }

    public SteppersPage clickSteppers() {
        driver.findElement(STEPPERS).click();
        return new SteppersPage((IOSDriver) driver);
    }

    public WebViewPage clickWebViewAndGoBack() {
        IosActions.scrollToWebElement(driver.findElement(WEB_VIEW), "down");
        driver.findElement(WEB_VIEW).click();
        return new WebViewPage((IOSDriver) driver);
    }

    public PickerViewPage clickPickerView() {
        driver.findElement(PICKER_VIEW).click();
        return new PickerViewPage((IOSDriver) driver);
    }
}
