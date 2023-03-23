package IosTests;

import IOSPageObjects.AlertViews.AlertViewsPage;
import TestUtils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsViewsTests extends TestBase {

    //    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void changeTextEntryAlert() {
        String actualConfirmationMessage = mainMenuPage1
                .clickAlertViews()
                .clickTextEntry()
                .typeText("Test Message")
                .SaveTextEntryChanges()
                .clickConfirmCancel()
                .getConfirmationAlertMessage();
        Assert.assertEquals(actualConfirmationMessage, "A message should be a short, complete sentence.");
        new AlertViewsPage(iosDriver).clickConfirm();
    }
}
