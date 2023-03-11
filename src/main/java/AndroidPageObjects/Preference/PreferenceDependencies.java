package AndroidPageObjects.Preference;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PreferenceDependencies extends AndroidActions {
    By WIFI_CHECKBOX = AppiumBy.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']");
    By WIFI_SETTINGS = AppiumBy.xpath("(//android.widget.RelativeLayout)[2]");
    By WIFI_NAME = AppiumBy.id("android:id/edit");
    By BUTTONS = AppiumBy.className("android.widget.Button");
    By ALERT_TITLE = AppiumBy.id("android:id/alertTitle");

    public PreferenceDependencies(AndroidDriver driver) {
        super(driver);
    }

    public PreferenceDependencies enableWifi() {
        boolean wifiEnabled = driver.findElement(WIFI_CHECKBOX).getAttribute("checked").equals("true");
        if (!wifiEnabled) {
            driver.findElement(WIFI_CHECKBOX).click();
        }
        return this;
    }

    public PreferenceDependencies changeWifiName(String wifiName) {
        driver.findElement(WIFI_SETTINGS).click();
        driver.findElement(WIFI_NAME).sendKeys(wifiName);
        return this;
    }

    public String getAlertTitle() {
        return driver.findElement(ALERT_TITLE).getText();
    }

    public PreferenceDependencies saveChanges() {
        driver.findElements(BUTTONS).get(1).click();
        return this;
    }
}
