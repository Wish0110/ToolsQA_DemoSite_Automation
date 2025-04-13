package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class brokenLinks extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void brokenLinks() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Broken Links</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC006: Verify broken link behavior</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Broken Links section</b>" +
                "<br><b>Click on the Broken link</b>" +
                "<br><b>Verify the response status is 500</b>");

        webSteps.scrollToElement("textBoxNav");
        webSteps.click("brokenLinksNav");
        webSteps.scrollToElement("brokenLinkScroll");
        webSteps.click("brokenLink");

        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals("https://the-internet.herokuapp.com/status_codes/500") : "Expected URL not found! Expected: 'https://the-internet.herokuapp.com/status_codes/500' but got: '" + currentUrl + "'";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Broken link behavior verified successfully.");
    }
}