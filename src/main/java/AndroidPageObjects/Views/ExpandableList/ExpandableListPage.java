package AndroidPageObjects.Views.ExpandableList;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ExpandableListPage extends AndroidActions {
    By CUSTOM_ADAPTER = AppiumBy.accessibilityId("1. Custom Adapter");
    By PEOPLE_NAMES = AppiumBy.className("android.widget.TextView");
    By MENU_TITLE = AppiumBy.id("android:id/title");

    public ExpandableListPage(AndroidDriver driver) {
        super(driver);
    }

    public ExpandableListPage clickCustomAdapter() {
        driver.findElement(CUSTOM_ADAPTER).click();
        return this;
    }

    public ExpandableListPage longPressCustomAdapter(int millisecondsToHold) {
        AndroidActions.longPressAction(driver.findElements(PEOPLE_NAMES).get(1), millisecondsToHold);
        return this;
    }

    public String getMenuText() {
        return driver.findElement(MENU_TITLE).getText();
    }
}
