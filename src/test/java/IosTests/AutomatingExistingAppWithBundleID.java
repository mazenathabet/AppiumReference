package IosTests;

import TestUtils.FrameworkInitialization;
import Utils.IosActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AutomatingExistingAppWithBundleID extends FrameworkInitialization {


    //    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void swipePhotos() {
        iosDriver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        List<WebElement> allPhotos = iosDriver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        iosDriver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
        for (int i = 0; i < allPhotos.size(); i++) {
            IosActions.swipe("left");
        }
        iosDriver.navigate().back();
        iosDriver.findElement(AppiumBy.accessibilityId("Albums")).click();
    }
}
