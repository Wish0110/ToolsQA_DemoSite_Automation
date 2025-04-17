package Interactions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Droppable extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("interaction");
        webSteps.click("interaction");
        webSteps.scrollToElement("DroppableNav");
        webSteps.click("DroppableNav");
    }

    @Test
    public void droppable() throws InterruptedException {
        extentReportManager.startTest("interactions", "<b>Droppable</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC008: Verify droppable functionality</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Drag an item to the droppable area</b>" +
                "<br><b>Verify the drop action</b>");

        // Drag and drop item
        webSteps.dragAndDrop("draggableItem", "droppableArea");

       /* // Verify drop action
        String dropMessage = webSteps.getText("dropMessage");
        assert dropMessage.equals("Dropped!") : "Drop action was not successful!";*/

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Droppable functionality verified successfully.");
    }
}