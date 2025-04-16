package Widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Tabs extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("widgets");
        webSteps.click("widgets");
        webSteps.scrollToElement("tabsNav");
        webSteps.click("tabsNav");
    }

    @Test(priority = 1)
    public void testTabs() throws InterruptedException {
        extentReportManager.startTest("Widgets", "<b>Tabs</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify Tabs functionality</b>");

        // Click on the first tab
        webSteps.click("OriginTab");
        webSteps.waiting();

        // Verify the content of the first tab
        String expectedTab1Content = "Origin";
        String actualTab1Content = webSteps.getText("OriginTabContent");
        assert actualTab1Content.equals(expectedTab1Content) : "Expected content not found for Tab 1! Expected: '" + expectedTab1Content + "' but got: '" + actualTab1Content + "'";

        // Click on the second tab
        webSteps.click("UseTab");
        webSteps.waiting();

        // Verify the content of the second tab
        String expectedTab2Content = "Use";
        String actualTab2Content = webSteps.getText("UseTabContent");
        assert actualTab2Content.equals(expectedTab2Content) : "Expected content not found for Tab 2! Expected: '" + expectedTab2Content + "' but got: '" + actualTab2Content + "'";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Tabs functionality verified successfully.");
    }
}