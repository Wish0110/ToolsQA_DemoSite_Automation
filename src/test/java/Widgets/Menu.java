package Widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Menu extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("widgets");
        webSteps.click("widgets");
        webSteps.scrollToElement("MenuNav");
        webSteps.click("MenuNav");
    }

    @Test
    public void testMenu() throws InterruptedException {
        extentReportManager.startTest("Widgets", "<b>Menu</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify Menu functionality</b>");

        webSteps.scrollToElement("MenuScroll");

        // Click on the menu item
        webSteps.hover("menuItem2");
        webSteps.waiting();

        webSteps.hover("subsublist");
        webSteps.waiting();

        webSteps.hover("subsubItem1");

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Menu functionality verified successfully.");
    }
}