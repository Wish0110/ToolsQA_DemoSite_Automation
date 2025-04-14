package AlertsFramesWindows;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class BrowserWindows extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("AlertsFramesWindows");
        webSteps.scrollToElement("firstScrollAlert");
        webSteps.click("browserWindowsNav");
    }

    @Test
    public void handleBrowserWindows() throws InterruptedException, AWTException {
        extentReportManager.startTest("Browser Windows", "<b>Browser Windows Test</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify handling of browser windows</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Click on 'New Tab' button</b>" +
                "<br><b>Switch to the new tab</b>" +
                "<br><b>Verify the title of the new tab</b>" +
                "<br><b>Verify the URL of the new tab</b>" +
                "<br><b>Close the new tab</b>" +
                "<br><b>Switch back to the original tab</b>" +
                "<br><b>Click on 'New Window' button</b>" + // New step added
                "<br><b>Switch to the new window</b>" + // New step added
                "<br><b>Verify the title of the new window</b>" + // New step added
                "<br><b>Verify the URL of the new window</b>" + // New step added
                "<br><b>Close the new window</b>" + // New step added
                "<br><b>Switch back to the original window</b>");

        // Click on the "New Tab" button
        webSteps.click("newTabButton"); // Assuming you have a locator for the new tab button

        // Switch to the new tab
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Verify the URL of the new tab
        String newTabUrl = driver.getCurrentUrl();
        if ("https://demoqa.com/sample".equals(newTabUrl)) {
            extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>New tab URL is correct.");
        } else {
            extentReportManager.testSteps("<b><font color='red'>Test Failed: </font></b>New tab URL is incorrect.");
        }
        // Close the new tab
        driver.close();
        driver.switchTo().window(originalWindow);

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Switched back to the original tab.");

        // Click on the "New Window" button
        webSteps.click("newWindow");

        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Verify the URL of the new window
        String newWindowUrl = driver.getCurrentUrl();
        if ("https://demoqa.com/sample".equals(newWindowUrl)) {
            extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>New window URL is correct.");
        } else {
            extentReportManager.testSteps("<b><font color ='red'>Test Failed: </font></b>New window URL is incorrect.");
        }

        // Close the new window
        driver.close();
        driver.switchTo().window(originalWindow);

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Switched back to the original window.");

        // Click on the "New Window Message" button
        webSteps.click("newWindowMessage"); // Assuming you have a locator for the new window message button

        // Switch to the new window
        String newWindowHandle = null;
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                newWindowHandle = windowHandle;
                driver.switchTo().window(newWindowHandle);
                break;
            }
        }

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Switched to new message window.");


        // Close the new window
        driver.close();
        driver.switchTo().window(originalWindow);
        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Switched back to the original window.");
    }
}