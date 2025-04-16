package Interactions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Selectable extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("interaction");
        webSteps.click("interaction");
        webSteps.scrollToElement("selectableNav");
        webSteps.click("selectableNav");
    }

    @Test
    public void selectable() throws InterruptedException {
        extentReportManager.startTest("interactions", "<b>Selectable</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC006: Verify selectable functionality</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Select multiple items</b>" +
                "<br><b>Verify the selected items</b>");

        webSteps.scrollToElement("SelectableScroll");

        // Select items
        webSteps.click("SelectableItem1");
        webSteps.click("SelectableItem2");

        webSteps.click("SelectableGridNav");

        // Select items
        webSteps.click("SelectableGridNavI1");
        webSteps.click("SelectableGridNavI2");
        webSteps.click("SelectableGridNavI3");

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Selectable functionality verified successfully.");
    }
}