package AlrtsFramesWindows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class Frames extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("AlertsFramesWindows");
        webSteps.scrollToElement("firstScrollAlert");
        webSteps.click("framesNav");
    }

    @Test
    public void handleFrames() throws InterruptedException, AWTException {
        extentReportManager.startTest("Frames", "<b>Frames Test</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify handling of frames</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Switch to first frame</b>" +
                "<br><b>Verify the text inside the first frame</b>" +
                "<br><b>Switch back to the main content</b>" +
                "<br><b>Switch to second frame</b>" +
                "<br><b>Verify the text inside the second frame</b>" +
                "<br><b>Switch back to the main content</b>");

        // Switch to first frame and verify text
        webSteps.switchToFrame("frame1");
        String frame1Text = webSteps.getText("frame1Heading");
        if ("This is a sample page".equals(frame1Text)) {
            extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>First frame text is correct.");
        } else {
            extentReportManager.testSteps("<b><font color='red'>Test Failed: </font></b>First frame text is incorrect.");
        }
        driver.switchTo().defaultContent();

        // Switch to second frame and verify text
        webSteps.switchToFrame("frame2");
        String frame2Text = webSteps.getText("frame2Heading");
        if ("This is a sample page".equals(frame2Text)) {
            extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Second frame text is correct.");
        } else {
            extentReportManager.testSteps("<b><font color='red'>Test Failed: </font></b>Second frame text is incorrect.");
        }
        driver.switchTo().defaultContent();

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Switched back to main content after frame verifications.");
    }
}