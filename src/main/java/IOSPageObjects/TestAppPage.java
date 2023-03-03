package IOSPageObjects;

import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class TestAppPage extends IosActions {
    public TestAppPage(IOSDriver driver) {
        super(driver);
    }

    By SLIDER = AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == \"AppElem\"`]");

    public TestAppPage handleSlider(String percentage){
        driver.findElement(SLIDER).sendKeys(percentage);
        return this;
    }

    public String getSliderPercentage(){
        return driver.findElement(SLIDER).getAttribute("value");
    }
}
