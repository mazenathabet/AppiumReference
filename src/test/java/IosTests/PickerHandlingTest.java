package IosTests;

import IOSPageObjects.PickerViewPage;
import TestUtils.FrameworkInitialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PickerHandlingTest extends FrameworkInitialization {

    @Test
    public void handlePickerView() {
        String blueNumber = mainMenuPage1.clickPickerView()
                .setRedNumber("80")
                .setGreenNumber("220")
                .setBlueNumber("110")
                .getNumber("blue");
        Assert.assertEquals(blueNumber, "110");
        String greenNumber = new PickerViewPage(iosDriver).getNumber("green");
        String redNumber = new PickerViewPage(iosDriver).getNumber("red");
        Assert.assertEquals(greenNumber, "220");
        Assert.assertEquals(redNumber, "80");
    }
}
