package AndroidTests;

import AndroidPageObjects.Preference.PreferenceDependencies;
import TestUtils.FrameworkInitialization;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.Test;

public class AndroidKeyEvents extends FrameworkInitialization {
    @Test
    public void clipboardTest() {
        mainMenuPage.clickPreference()
                .clickPreferenceDependencies()
                .enableWifi();
        new PreferenceDependencies(driver)
                .changeWifiName("Super WiFi");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        new PreferenceDependencies(driver)
                .saveChanges();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
