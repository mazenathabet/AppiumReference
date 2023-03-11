package IOSPageObjects;

import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class PickerViewPage extends IosActions {
    By RED_COLOR_LIST = AppiumBy.accessibilityId("Red color component value");
    By GREEN_COLOR_LIST = AppiumBy.accessibilityId("Green color component value");
    By BLUE_COLOR_LIST = AppiumBy.accessibilityId("Blue color component value");
    public PickerViewPage(IOSDriver driver) {
        super(driver);
    }

    public PickerViewPage setRedNumber(String number) {
        driver.findElement(RED_COLOR_LIST).sendKeys(number);
        return this;
    }

    public PickerViewPage setGreenNumber(String number) {
        driver.findElement(GREEN_COLOR_LIST).sendKeys(number);
        return this;
    }

    public PickerViewPage setBlueNumber(String number) {
        driver.findElement(BLUE_COLOR_LIST).sendKeys(number);
        return this;
    }

    public String getNumber(String color) {
        String number = null;
        if (color.equalsIgnoreCase("red")) {
            number = driver.findElement(RED_COLOR_LIST).getText();
        } else if (color.equalsIgnoreCase("blue")) {
            number = driver.findElement(BLUE_COLOR_LIST).getText();
        } else if (color.equalsIgnoreCase("green")) {
            number = driver.findElement(GREEN_COLOR_LIST).getText();
        }
        return number;
    }
}
