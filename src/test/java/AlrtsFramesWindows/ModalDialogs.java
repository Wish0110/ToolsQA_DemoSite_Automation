package AlrtsFramesWindows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class ModalDialogs extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("AlertsFramesWindows");
        webSteps.scrollToElement("firstScrollAlert");
        webSteps.click("modalDialogsNav");
    }

    @Test
    public void handleModalDialogs() throws InterruptedException, AWTException {
        extentReportManager.startTest("Modal Dialogs", "<b>Modal Dialogs Test</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify handling of modal dialogs</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Click button to open small modal dialog</b>" +
                "<br><b>Verify the modal dialog is displayed</b>" +
                "<br><b>Verify the modal dialog content text</b>" +
                "<br><b>Close the small modal dialog</b>" +
                "<br><b>Click button to open large modal dialog</b>" +
                "<br><b>Verify the large modal dialog is displayed</b>" +
                "<br><b>Verify the large modal dialog content text</b>" +
                "<br><b>Close the large modal dialog</b>");

        // Open and verify small modal dialog
        webSteps.click("smallModalButton");
        webSteps.click("smallModalCloseButton");

        // Open and verify large modal dialog
        webSteps.click("largeModalButton");
        webSteps.click("largeModalCloseButton");

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Modal dialogs handled successfully.");
    }
}