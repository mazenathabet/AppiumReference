package AndroidTests;

import TestUtils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest extends TestBase {

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
