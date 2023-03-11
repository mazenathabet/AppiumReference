package AndroidTests;

import AndroidPageObjects.MainMenuPage;
import AndroidPageObjects.Preference.PreferenceDependencies;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class RotateTest extends FrameworkInitialization {

    @Test
    public void rotateDevice() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickPreference()
                .clickPreferenceDependencies()
                .enableWifi();
//        AndroidActions.rotateDevice(0, 0, 90); // Landscape
        new PreferenceDependencies(driver)
                .changeWifiName("Super WiFi")
                .saveChanges();
    }
}
