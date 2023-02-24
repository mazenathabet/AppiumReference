package AndroidTests;

import PageObjects.Preference.PreferenceDependencies;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class ClipboardTest extends FrameworkInitialization {

    @Test
    public void clipboardTest(){
        mainMenuPage.clickPreference()
                .clickPreferenceDependencies()
                .enableWifi();
        driver.setClipboardText("Clipboard Text");
        new PreferenceDependencies(driver)
                .changeWifiName(driver.getClipboardText())
                .saveChanges();
    }
}
