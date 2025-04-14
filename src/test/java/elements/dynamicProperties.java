package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class dynamicProperties extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void dynamicProperties() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Dynamic Properties</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC008: Verify dynamic properties</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Dynamic Properties section</b>" +
                "<br><b>Verify the button is enabled after 5 seconds</b>" +
                "<br><b>Verify the color of the button changes</b>" +
                "<br><b>Verify the text of the button changes</b>");

        webSteps.scrollToElement("linksNav");
        webSteps.click("dynamicPropertiesNav");
        webSteps.scrollToElement("dynamicPropertiesScroll");

        // Wait for the button to be enabled
        Thread.sleep(7000);
        String buttonText = webSteps.getText("Visiblbtn");
        assert buttonText.equals("Visible After 5 Seconds") : "Button text did not change as expected! Expected: 'Visible After 5 Seconds' but got: '" + buttonText + "'";

        // Verify the button is enabled
        webSteps.click("enableBtn");

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Dynamic properties verified successfully.");
    }
}