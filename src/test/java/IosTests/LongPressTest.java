package IosTests;

import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class LongPressTest extends FrameworkInitialization {

    @Test
    public void testLongPress(){
        mainMenuPage1.clickSteppers()
                .longPressCustomIncrement();
    }
}