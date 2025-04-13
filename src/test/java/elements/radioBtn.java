package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class radioBtn extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void radioButton() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Radio Button</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC003: Verify radio button selection</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Radio Button section</b>" +
                "<br><b>Select a radio button</b>" +
                "<br><b>Verify the selected radio button</b>");

        webSteps.click("radioButtonNav");
        webSteps.click("yesRadio");

        String selectedRadioText = webSteps.getText("selectedRadioOutput");
        String expectedRadioMessage = "You have selected Yes";
        assert selectedRadioText.equals(expectedRadioMessage) : "Expected message not found! Expected: '" + expectedRadioMessage + "' but got: '" + selectedRadioText + "'";
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Radio button selection verified successfully.");
    }
}