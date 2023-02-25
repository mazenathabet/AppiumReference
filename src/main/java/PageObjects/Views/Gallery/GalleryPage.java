package PageObjects.Views.Gallery;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class GalleryPage extends AndroidActions {
    By PHOTOS = AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Photos']");
    By FIRST_IMAGES = AppiumBy.xpath("(//android.widget.ImageView)[1]");
    public GalleryPage(AndroidDriver driver) {
        super(driver);
    }

    public GalleryPage clickPhotos() {
        driver.findElement(PHOTOS).click();
        return this;
    }

    public boolean isFirstImageFocused() {
        return driver.findElement(FIRST_IMAGES).getAttribute("focusable").equals("true");
    }

    public GalleryPage swipeImagesLeft() {
        AndroidActions.swipeElement(driver.findElement(FIRST_IMAGES), "left");
        return this;
    }
}
