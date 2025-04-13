package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class webTables extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void webTables() throws InterruptedException {

        //01
        extentReportManager.startTest("Elements", "<b>Web Tables</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC003_01: Verify adding a new user to the web table</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Web Tables section</b>" +
                "<br><b>Add a new user</b>" +
                "<br><b>Verify the new user is added</b>");

        webSteps.click("webTablesNav");
        webSteps.scrollToElement("scrollWebTables");
        webSteps.click("addButton");

        webSteps.type("Wishmi", "firstName");
        webSteps.type("Hiranya", "lastName");
        webSteps.type("wishhiranyaco@gmail.com", "email");
        webSteps.type("23", "age");
        webSteps.type("15000", "salary");
        webSteps.type("QA Department", "Department");
        webSteps.click("webTableSubmit");

        webSteps.scrollToElement("scrollWebTables");

        String selectedCheckboxText = webSteps.getText("tableOutput");
        String expectedMessage = "Wishmi";
        assert selectedCheckboxText.equals(expectedMessage) : "Expected message not found! Expected: '" + expectedMessage + "' but got: '" + selectedCheckboxText + "'";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Added user successfully.");

        //02
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC003_02: Verify added user edited</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Click user edit</b>" +
                "<br><b>Edit salary</b>" +
                "<br><b>Submit updates</b>" +
                "<br><b>Verify the user updated</b>");

        webSteps.click("addedUserEdit");
        webSteps.clearText("salary");
        webSteps.type("200000", "salary");
        webSteps.click("webTableSubmit");

        webSteps.scrollToElement("scrollWebTables");

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>User edited successfully.");

        //03
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC003_02: Verify delete user</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Click user delete</b>" +
                "<br><b>Submit updates</b>" +
                "<br><b>Verify the user deleted</b>");

        webSteps.click("addedUserDelete");

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>User deleted successfully.");
    }
}