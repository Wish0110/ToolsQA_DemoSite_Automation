package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class Accordian extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("widgets");
        webSteps.scrollToElement("firstScrollAlert");
        webSteps.click("accordionNav");
    }

    @Test
    public void testAccordion() throws InterruptedException, AWTException {
        extentReportManager.startTest("Widgets", "<b>Accordion</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify Accordion functionality</b>");

        // Expand the first accordion item
        webSteps.scrollToElement("accordionScroll");
        webSteps.click("accordionItem1");
        webSteps.waiting();

        // Verify the content of the first accordion item
        String expectedText = "What is Lorem Ipsum?";
        String actualText = webSteps.getText("accordionContent1");
        assert actualText.equals(expectedText) : "Expected text not found! Expected: '" + expectedText + "' but got: '" + actualText + "'";
        webSteps.click("accordionItem1");
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Accordion functionality verified successfully.");

        // Expand the scnd accordion item
        webSteps.scrollToElement("accordionItem1");
        webSteps.click("accordionItem2");
        webSteps.waiting();

        // Verify the content of the first accordion item
        expectedText = "Where does it come from?";
        actualText = webSteps.getText("accordionContent2");
        assert actualText.equals(expectedText) : "Expected text not found! Expected: '" + expectedText + "' but got: '" + actualText + "'";
        webSteps.click("accordionItem2");
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Accordion functionality verified successfully.");

    }

}