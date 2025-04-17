package BookStoreApplication;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Login extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("bookStore");
        webSteps.click("bookStore");
        webSteps.scrollToElement("LoginNav");
        webSteps.click("LoginNav");
    }

    @Test
    public void login() throws InterruptedException {
        extentReportManager.startTest("Book Store Application", "<b>Login</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify user login</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Enter username</b>" +
                "<br><b>Enter password</b>" +
                "<br><b>Click on login button</b>" +
                "<br><b>Verify successful login</b>");

       /* webSteps.scrollToElement("LoginScroll");
        webSteps.click("newUserBtn");
        webSteps.scrollToElement("registerScroll");

        // Enter username and password
        webSteps.type("Wishmi", "registerFirstName");
        webSteps.type("Hiranya", "registerScndName");
        webSteps.type("Wish123", "registerUserName");
        webSteps.type("123456", "registerPassword");

        webSteps.click("registerBtn");
        webSteps.click("registerBckToLogin");*/

        webSteps.scrollToElement("LoginScroll");
        webSteps.type("Wish@123","loginUserName");
        webSteps.type("Wishmi@123456","loginPassword");

        //webSteps.click("captcha");
        webSteps.click("loginBtn");
        webSteps.waiting();

        // Verify successful login
        String welcomeMessage = webSteps.getText("loggedusercheck");
        assert welcomeMessage.equals("Wish@123") : "Login failed! Welcome message not found.";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>User logged in successfully.");
    }
}