package AndroidTests;

import AndroidPageObjects.MainMenuPage;
import AndroidPageObjects.Preference.PreferenceDependencies;
import TestUtils.TestBase;
import org.testng.annotations.Test;

public class ClipboardTest extends TestBase {

    @Test
    public void clipboardTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickPreference()
                .clickPreferenceDependencies()
                .enableWifi();
        driver.setClipboardText("Clipboard Text");
        new PreferenceDependencies(driver)
                .changeWifiName(driver.getClipboardText())
                .saveChanges();
    }
}
