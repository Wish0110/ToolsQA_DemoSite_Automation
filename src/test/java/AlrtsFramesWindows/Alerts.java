package AlrtsFramesWindows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;
import org.openqa.selenium.Alert;

import java.awt.*;
import java.io.IOException;

public class Alerts extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("AlertsFramesWindows");
        webSteps.scrollToElement("firstScrollAlert");
        webSteps.click("alertsNav");
    }

    @Test
    public void handleAlerts() throws InterruptedException, AWTException {
        extentReportManager.startTest("Alerts", "<b>Alerts Test</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify handling of alerts</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Click on 'Simple Alert' button</b>" +
                "<br><b>Accept the alert</b>" +
                "<br><b>Click on 'Confirmation Alert' button</b>" +
                "<br><b>Dismiss the alert</b>" +
                "<br><b>Click on 'Prompt Alert' button</b>" +
                "<br><b>Send input to the prompt</b>" +
                "<br><b>Accept the prompt</b>");

        webSteps.scrollToElement("alertsScroll");

        // Handle Simple Alert
        webSteps.click("alertBtn");
        Alert simpleAlert = driver.switchTo().alert();
        extentReportManager.testSteps("<b><font color='blue'>Simple Alert Text: </font></b>" + simpleAlert.getText());
        simpleAlert.accept();
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Simple alert accepted.");

        // Handle Confirmation Alert
        webSteps.click("confirmBoxBtn");
        Alert confirmationAlert = driver.switchTo().alert();
        extentReportManager.testSteps("<b><font color='blue'>Confirmation Alert Text: </font></b>" + confirmationAlert.getText());
        confirmationAlert.dismiss();
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Confirmation alert dismissed.");

        // Handle Prompt Alert
        webSteps.click("promptBtn");
        Alert promptAlert = driver.switchTo().alert();
        extentReportManager.testSteps("<b><font color='blue'>Prompt Alert Text: </font></b>" + promptAlert.getText());
        promptAlert.sendKeys("Test Input");
        promptAlert.accept();
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Prompt alert accepted with input.");
    }
}