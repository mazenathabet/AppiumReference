package PageObjects;

import PageObjects.Preference.PreferencePage;
import PageObjects.Views.ViewsPage;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainMenuPage extends AndroidActions {
    /**
     * AppiumBy -> exclusively for appium
     * By. -> generic locators
     */
    By Animation = AppiumBy.accessibilityId("Animation");
    By Preference = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]");
    By Views = AppiumBy.accessibilityId("Views");
    public MainMenuPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickAnimation() {
        driver.findElement(Animation).click();
    }

    public PreferencePage clickPreference() {
        driver.findElement(Preference).click();
        return new PreferencePage(driver);
    }

    public ViewsPage clickViews() {
        driver.findElement(Views).click();
        return new ViewsPage(driver);
    }

}
