package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Resizable extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("interactions");
        webSteps.click("interactions");
        webSteps.scrollToElement("resizable");
        webSteps.click("resizable");
    }

    @Test
    public void resize() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Resizable</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC007: Verify resizable functionality</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Resize the element</b>" +
                "<br><b>Verify the new size</b>");

        // Resize the element
        webSteps.dragAndDrop("resizableHandle", "newPosition"); // Adjust as necessary

        // Verify new size
        String newSize = webSteps.getCssValue("resizableElement", "width");
        assert newSize.equals("Expected Width") : "Resizable element did not resize correctly!";

        extentReportManager.testSteps("<b><font color='green '>Test Passed: </font></b>Resizable functionality verified successfully.");
    }
}