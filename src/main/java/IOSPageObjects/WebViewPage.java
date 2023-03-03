package IOSPageObjects;

import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class WebViewPage extends IosActions {
    public WebViewPage(IOSDriver driver) {
        super(driver);
    }

    By BACK_BUTTON = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]");

    public MainMenuPage goBackHome(){
        driver.findElement(BACK_BUTTON).click();
        return new MainMenuPage(driver);
    }
}
