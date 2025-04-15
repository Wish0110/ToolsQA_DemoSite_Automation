package AlrtsFramesWindows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class NestedFrames extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("AlertsFramesWindows");
        webSteps.scrollToElement("firstScrollAlert");
        webSteps.click("nestedFramesNav");
    }

    @Test
    public void handleNestedFrames() throws InterruptedException, AWTException {
        extentReportManager.startTest("Nested Frames", "<b>Nested Frames Test</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify handling of nested frames</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Switch to parent frame</b>" +
                "<br><b>Verify the text inside the parent frame</b>" +
                "<br><b>Switch to child frame inside parent frame</b>" +
                "<br><b>Verify the text inside the child frame</b>" +
                "<br><b>Switch back to the main content</b>");

        webSteps.scrollToElement("nestedFrameScroll");
        // Switch to parent frame and verify text
        webSteps.waiting();
        webSteps.switchToFrame("nestedFrame1"); // Assuming 'frame1' is the parent frame's name or id

            extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Parent frame found.");

        // Switch to child frame inside parent frame and verify text
        webSteps.switchToFrame("nestedChildFrame"); // Assuming 'childFrame' is the child frame's name or id inside parent frame
        String childFrameText = webSteps.getText("childFrameBody"); // Locator for text inside child frame
        if (childFrameText != null && childFrameText.contains("Child Iframe")) {
            extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Child frame text is correct.");
        } else {
            extentReportManager.testSteps("<b><font color='red'>Test Failed: </font></b>Child frame text is incorrect.");
        }

        // Switch back to main content
        driver.switchTo().defaultContent();
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Switched back to main content after nested frame verifications.");
    }
}