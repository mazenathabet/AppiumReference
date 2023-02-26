package AndroidTests;

import AndroidPageObjects.Preference.PreferenceDependencies;
import TestUtils.FrameworkInitialization;
import Utils.AndroidActions;
import org.testng.annotations.Test;

public class appPackageActivityTest extends FrameworkInitialization {
    @Test
    public void appPackageActivityTest() {
        AndroidActions.StartAndroidActivity(driver,
                "io.appium.android.apis",
                "io.appium.android.apis.preference.PreferenceDependencies");
        new PreferenceDependencies(driver)
                .enableWifi()
                .changeWifiName("Super Wifi")
                .getAlertTitle();
    }
}
