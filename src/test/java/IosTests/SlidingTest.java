package IosTests;

import TestUtils.FrameworkInitialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SlidingTest extends FrameworkInitialization {

    @Test
    public void handlingSliding(){
        String actualPercentage = testAppPage.handleSlider("0")
                .getSliderPercentage();
        Assert.assertEquals(actualPercentage,"0%");
        String actualNewPercentage = testAppPage.handleSlider("1")
                .getSliderPercentage();
        Assert.assertEquals(actualNewPercentage,"100%");
    }
}
