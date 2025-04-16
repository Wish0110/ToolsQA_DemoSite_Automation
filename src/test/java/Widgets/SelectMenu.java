package Widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class SelectMenu extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("widgets");
        webSteps.click("widgets");
        webSteps.scrollToElement("selectMenuNav");
        webSteps.click("selectMenuNav");
    }

    @Test
    public void testSelectMenu() throws InterruptedException, AWTException {
        extentReportManager.startTest("Widgets", "<b>Select Menu</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify Select Menu functionality</b>");

        webSteps.scrollToElement("selectMenuScroll");
        // Select an option from the dropdown
        webSteps.select("selectMenuElement",1, 1);
        webSteps.waiting();

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Select Value functionality verified successfully.");

        // Select an option from the dropdown
        webSteps.select("selectOne",1, 1);
        webSteps.waiting();

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Select Select One dropdown functionality verified successfully.");

        // Select an option from the dropdown
        webSteps.select("OldStyleMenuSelect",1, 1);
        webSteps.waiting();

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Select Old Style menu functionality verified successfully.");

        // Select an option from the dropdown
        webSteps.select("MultiMenuSelect",1, 1);
        webSteps.select("MultiMenuSelect",1, 2);
        webSteps.waiting();

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Select Multi Option functionality verified successfully.");
    }
}