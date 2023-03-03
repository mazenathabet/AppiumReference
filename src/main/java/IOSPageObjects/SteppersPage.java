package IOSPageObjects;

import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class SteppersPage extends IosActions {
    public SteppersPage(IOSDriver driver) {
        super(driver);
    }
    By CUSTOM_INCREMENT = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]");

    public SteppersPage longPressCustomIncrement(){
        IosActions.longPress(driver.findElement(CUSTOM_INCREMENT),5000);
        return this;
    }
}
