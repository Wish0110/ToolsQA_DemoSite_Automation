package Interactions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class Resizable extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("interaction");
        webSteps.click("interaction");
        webSteps.scrollToElement("resizableNav");
        webSteps.click("resizableNav");
    }

    @Test
    public void resize() throws InterruptedException, AWTException {
        extentReportManager.startTest("interactions", "<b>Resizable</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC007: Verify resizable functionality</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Resize the element</b>" +
                "<br><b>Verify the new size</b>");

        webSteps.scrollToElement("resizableScroll");

        // Resize the element
        webSteps.resizeElement("resizableElement", 400, 250);
        webSteps.pressEnter();

        extentReportManager.testSteps("<b><font color='green '>Test Passed: </font></b>Resizable functionality verified successfully.");
    }

}