package IosTests;

import TestUtils.TestBase;
import org.testng.annotations.Test;

public class LongPressTest extends TestBase {

    //    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void testLongPress() {
        mainMenuPage1.clickSteppers()
                .longPressCustomIncrement();
    }
}
