package AndroidTests;

import AndroidPageObjects.Preference.PreferenceDependencies;
import TestUtils.FrameworkInitialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class change_wifi_name_test extends FrameworkInitialization {

    @Test
    public void appium_test() {
        String actualTitle = mainMenuPage.clickPreference()
                .clickPreferenceDependencies()
                .enableWifi()
                .changeWifiName("Super Wifi")
                .getAlertTitle();
        Assert.assertEquals(actualTitle, "WiFi settings", "Alert title is not correct!");
        new PreferenceDependencies(driver).saveChanges();
    }
}
