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

    By CONFIRM_CANCEL = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'");
/*
    By CONFIRM_CANCEL = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'");
    By CONFIRM_CANCEL = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH 'Confirm'");
    Check this https://github.com/facebookarchive/WebDriverAgent/wiki/Predicate-Queries-Construction-Rules for more guidance
*/
    By CONFIRM_BUTTON = AppiumBy.iOSNsPredicateString("label == 'Confirm'");
    By CONFIRMATION_ALERT_MESSAGE = AppiumBy.iOSNsPredicateString("label BEGINSWITH 'A message'");
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
    public AlertViewsPage clickConfirmCancel(){
        driver.findElement(CONFIRM_CANCEL).click();
        return this;
    }
    public String getConfirmationAlertMessage(){
        return driver.findElement(CONFIRMATION_ALERT_MESSAGE).getText();
    }
    public AlertViewsPage clickConfirm(){
        driver.findElement(CONFIRM_BUTTON).click();
        return this;
    }

}
