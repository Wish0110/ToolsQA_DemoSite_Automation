package Forms;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class PracticeForm extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.click("forms");
        webSteps.scrollToElement("formsScroll");
        webSteps.click("practiceForm");
    }

    @Test
    public void fillPracticeForm() throws InterruptedException, AWTException {
        extentReportManager.startTest("Forms", "<b>Practice Form</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify successful submission of the practice form</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Type a first name</b>" +
                "<br><b>Type a last name</b>" +
                "<br><b>Type an email</b>" +
                "<br><b>Select gender</b>" +
                "<br><b>Type a mobile number</b>" +
                "<br><b>Select a date of birth</b>" +
                "<br><b>Select subjects</b>" +
                "<br><b>Select hobbies</b>" +
                "<br><b>Upload a picture</b>" +
                "<br><b>Type an address</b>" +
                "<br><b>Submit the form</b>");

        webSteps.scrollToElement("practiceFormScroll");
        webSteps.type("Wishmi", "formsFirstName");
        webSteps.type("Hiranya", "formsLastName");
        webSteps.type("wishhiranyaco@gmail.com", "formsEmail");
        webSteps.click("formsGender");
        webSteps.type("0775005005", "formsMobile");
        webSteps.scrollToElement("formsMobile");
        webSteps.selectFullDate("formsDateOfBirth", "10", "January", "2002");
        webSteps.click("formsHobbiesMusic");
        webSteps.click("formsHobbiesReading");
        webSteps.uploadFile("profilePic.jpg", "formsUploadPicture");
        webSteps.type("123 Main St, Kandy, SriLanka", "formsAddress"); // Type address
        webSteps.scrollToElement("formsSubmitButton"); // Scroll to the submit button
        webSteps.click("formsSubmitButton"); // Click the submit button

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Practice form submitted successfully.");
    }
}