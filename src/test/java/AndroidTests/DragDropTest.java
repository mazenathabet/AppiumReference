package AndroidTests;

import TestUtils.FrameworkInitialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest extends FrameworkInitialization {

    @Test
    public void DragDropDemo() {
        String actualResultText = mainMenuPage
                .clickViews()
                .clickDragDrop()
                .dragAndDropSource()
                .getResultText();
        Assert.assertEquals(actualResultText,
                "Dropped!",
                "Result Text is not correct ");
    }
}
