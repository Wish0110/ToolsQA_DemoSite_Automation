package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class textBox extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void textBox() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Text Box</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify successful submission of the text box form</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Type a full name</b>" +
                "<br><b>Type a email</b>" +
                "<br><b>Type current address</b>" +
                "<br><b>Type Permanent Address</b>" +
                "<br><b>Submit the form</b>");

        webSteps.click("textBoxNav");
        webSteps.type("Wishmi Hiranya", "fullName");
        webSteps.type("wishhiranyaco@gmail.com", "email");
        webSteps.type("123 Main St, Kandy, Sri Lanka", "currentAddress");
        webSteps.type("456 Elm St, Colombo, Sri Lanka", "permanentAddress");
        webSteps.scrollToElement("submitButton");
        webSteps.click("submitButton");
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Text box form submit successfully.");
    }
}