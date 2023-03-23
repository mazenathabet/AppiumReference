package AndroidTests;

import TestUtils.TestBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;

public class HybridAppHandlingTest extends TestBase {


    @Test
    public void handleHybridApp() {
        driver.findElement(AppiumBy.id("nameField")).click();
        driver.hideKeyboard();
        driver.findElement(AppiumBy.id("nameField")).sendKeys("Mazen Ahmed");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // switching to web view
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            System.out.println(context);
            //WEBVIEW_com.androidsample.generalstore
            //NATIVE_APP
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Rahul shetty");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); // redirect to the native app again
    }
}
