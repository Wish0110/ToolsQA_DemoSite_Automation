package Widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class ProgressBar extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("widgets");
        webSteps.click("widgets");
        webSteps.scrollToElement("progressBarNav");
        webSteps.click("progressBarNav");
    }

    @Test
    public void testProgressBar() throws InterruptedException {
        extentReportManager.startTest("Widgets", "<b>Progress Bar</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify Progress Bar functionality</b>");

        // Start the progress bar
        webSteps.click("startProgressButton");
        webSteps.waiting();

        // Verify the progress bar is visible and has started
        String progressValue = webSteps.getText("progressBarValue");
        assert !progressValue.equals("0%") : "Progress bar did not start! Current value: " + progressValue;

        // Optionally, wait for the progress to complete
        webSteps.progressBarWaiting();

        // Verify the progress bar has reached 100%
        progressValue = webSteps.getText("progressBarValue");
        assert progressValue.equals("100%") : "Expected progress value not found! Expected: '100%' but got: '" + progressValue + "'";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Progress Bar functionality verified successfully.");
    }
}