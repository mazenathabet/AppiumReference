package AndroidPageObjects.Preference;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PreferencePage extends AndroidActions {
    By PreferenceDependencies = AppiumBy.accessibilityId("3. Preference dependencies");

    public PreferencePage(AndroidDriver driver) {
        super(driver);
    }

    public PreferenceDependencies clickPreferenceDependencies() {
        driver.findElement(PreferenceDependencies).click();
        return new PreferenceDependencies(driver);
    }
}
