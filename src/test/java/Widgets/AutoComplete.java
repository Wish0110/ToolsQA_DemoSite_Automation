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

public class AutoComplete extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("widgets");
        webSteps.scrollToElement("autoCompleteNav");
        webSteps.click("autoCompleteNav");
    }

    @Test
    public void testAutoComplete() throws InterruptedException, AWTException {
        extentReportManager.startTest("Widgets", "<b>Auto Complete</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify Auto Complete functionality</b>");

        // Enter text in the auto-complete input field
        String inputText = "R";
        webSteps.sendKeys("autoCompleteInput", inputText);
        webSteps.waiting();

        // Select the first suggestion
        webSteps.click("suggestion1");

        // Verify the selected value
        String expectedText = "Apple";
        String actualText = webSteps.getText("autoCompleteInput");
        assert actualText.equals(expectedText) : "Expected text not found! Expected: '" + expectedText + "' but got: '" + actualText + "'";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Auto Complete functionality verified successfully.");
    }
}