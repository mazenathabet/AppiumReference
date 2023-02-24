package AndroidTests;

import PageObjects.Preference.PreferenceDependencies;
import TestUtils.FrameworkInitialization;
import Utils.AndroidActions;
import org.testng.annotations.Test;

public class RotateTest extends FrameworkInitialization {

    @Test
    public void rotateDevice(){
        mainMenuPage.clickPreference()
                .clickPreferenceDependencies()
                .enableWifi();
        AndroidActions.rotateDevice(0,0,90); // Landscape
        new PreferenceDependencies(driver)
                .changeWifiName("Super WiFi")
                .saveChanges();
    }
}
