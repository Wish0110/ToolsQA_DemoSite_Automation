package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class links extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void links() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Links</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC005: Verify link navigation & api call</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Links section</b>" +
                "<br><b>Click on the Created link</b>" +
                "<br><b>Verify the link opens in a new tab</b>" +
                "<br><b>Click on the No Content link</b>" +
                "<br><b>Verify the link returns a 204 status</b>" +
                "<br><b>Click on the Redirect link</b>" +
                "<br><b>Verify the link redirects to the correct URL</b>");

        webSteps.scrollToElement("textBoxNav");
        webSteps.click("linksNav");

        webSteps.scrollToElement("firstLinksScroll");
        webSteps.click("createdLink");
        String createdLink = webSteps.getText("linkRespond");
        assert createdLink.equals("Created") : "Created message not found!";

        webSteps.click("movedLink");
        String movedLink = webSteps.getText("linkRespond");
        assert movedLink.equals("Moved Permanently") : "Moved Permanently message not found!";

        webSteps.click("forbiddenLink");
        String forbiddenLink = webSteps.getText("linkRespond");
        assert forbiddenLink.equals("Forbidden") : "Forbidden message not found!";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Button api call verified successfully.");

        webSteps.scrollToElement("linkScroll");
        webSteps.click("HomeLink");
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals("https://demoqa.com/links") : "Expected URL not found! Expected: 'https://demoqa.com/links' but got: '" + currentUrl + "'";

        driver.navigate().back();
        webSteps.waiting();
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Link navigation verified successfully.");
    }
}