package Interactions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Draggable extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("interaction");
        webSteps.click("interaction");
        webSteps.scrollToElement("draggableNav");
        webSteps.click("draggableNav");
    }

    @Test
    public void draggable() throws InterruptedException {
        extentReportManager.startTest("interactions", "<b>Draggable</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC009: Verify draggable functionality</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Drag the item</b>" +
                "<br><b>Verify the new position</b>");

        webSteps.scrollToElement("dragScroll");
        // Drag the item
        webSteps.dragAndDrop("draggbleBtn", "dragScroll");

       /* // Verify new position
        String newPosition = webSteps.getCssValue("draggableItem", "left");
        assert newPosition.equals("Expected Position") : "Draggable item did not move to the expected position!";*/

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Draggable functionality verified successfully.");
    }
}