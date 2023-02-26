package IOSPageObjects.AlertViews;

import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class AlertViewsPage extends IosActions {
    public AlertViewsPage(IOSDriver driver) {
        super(driver);
    }

    By SIMPLE_ALERT = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Simple'`]");
    //Class chain locator is more like xpath because xpath is very slow in IOS compared to Android because the native source code of IOS is not XML
    By TEXT_ENTRY = AppiumBy.iOSNsPredicateString("label == 'Text Entry'");
    By TEXT_AREA = AppiumBy.iOSClassChain("**/XCUIElementTypeCell");
    By TEXT_ENTRY_OK_BUTTON = AppiumBy.accessibilityId("OK");

    public AlertViewsPage clickSimpleAlert(){
        driver.findElement(SIMPLE_ALERT).click();
        return this;
    }
    public AlertViewsPage clickTextEntry(){
        driver.findElement(TEXT_ENTRY).click();
        return this;
    }
    public AlertViewsPage typeText(String text){
        driver.findElement(TEXT_AREA).sendKeys(text);
        return this;
    }
    public AlertViewsPage SaveTextEntryChanges(){
        driver.findElement(TEXT_ENTRY_OK_BUTTON).click();
        return this;
    }
}
