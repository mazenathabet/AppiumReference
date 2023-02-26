package IosTests;

import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class AlertsViewsTests extends FrameworkInitialization {

    @Test
    public void changeTextEntryAlert(){
        mainMenuPage1
                .clickAlertViews()
                .clickTextEntry()
                .typeText("Test Message")
                .SaveTextEntryChanges();
    }
}
