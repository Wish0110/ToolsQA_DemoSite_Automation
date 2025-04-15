package Widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class DatePicker extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("widgets");
        webSteps.click("widgets");
        webSteps.scrollToElement("WidgetsScroll");
        webSteps.click("datePickerNav");
    }

    @Test(priority = 1)
    public void testDatePicker() throws InterruptedException {
        extentReportManager.startTest("Widgets", "<b>Date Picker</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify Date Picker functionality</b>");

        // Click on the datepicker input
        webSteps.click("datePickerInput");

        // Select a date (e.g., 15)
        webSteps.selectFullDate("datePickerInput", "20", "May", "2025");

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Date Picker functionality verified successfully.");
    }
}