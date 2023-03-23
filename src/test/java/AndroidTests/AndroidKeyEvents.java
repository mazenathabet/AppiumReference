package AndroidTests;

import AndroidPageObjects.MainMenuPage;
import AndroidPageObjects.Preference.PreferenceDependencies;
import TestUtils.TestBase;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.Test;

public class AndroidKeyEvents extends TestBase {
    @Test
    public void AndroidKeyEventsTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
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
