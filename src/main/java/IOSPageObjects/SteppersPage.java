package IOSPageObjects;

import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class SteppersPage extends IosActions {
    By CUSTOM_INCREMENT = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]");

    public SteppersPage(IOSDriver driver) {
        super(driver);
    }

    public SteppersPage longPressCustomIncrement() {
        IosActions.longPress(driver.findElement(CUSTOM_INCREMENT), 5000);
        return this;
    }
}
