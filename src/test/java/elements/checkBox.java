package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class checkBox extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void checkBox() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Check Box</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC002: Verify checkbox selection</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Check Box section</b>" +
                "<br><b>Expand the checkbox tree</b>" +
                "<br><b>Select a checkbox</b>" +
                "<br><b>Verify the selected checkbox</b>");

        webSteps.click("checkBoxNav");
        webSteps.click("expandAllButton");
        webSteps.click("homeCheckbox");
        webSteps.scrollToElement("selectedCheckboxOutput");

        String selectedCheckboxText = webSteps.getText("selectedCheckboxOutput");
        String expectedMessage = "You have selected :";
        assert selectedCheckboxText.equals(expectedMessage) : "Expected message not found! Expected: '" + expectedMessage + "' but got: '" + selectedCheckboxText + "'";
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Checkbox select successfully.");
    }


}