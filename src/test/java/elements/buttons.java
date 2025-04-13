package elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class buttons extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void buttons() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Buttons</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC004: Verify button click actions</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Buttons section</b>" +
                "<br><b>Click on the Double Click button</b>" +
                "<br><b>Verify the double click action</b>" +
                "<br><b>Click on the Right Click button</b>" +
                "<br><b>Verify the right click action</b>" +
                "<br><b>Click on the Click Me button</b>" +
                "<br><b>Verify the click action</b>");

        webSteps.click("buttonsNav"); // Replace with the actual locator for the Buttons navigation
        webSteps.scrollToElement("btnScroll");

        // Double Click
        webSteps.doubleClick("doubleClickBtn"); // Replace with the actual locator for the Double Click button
        String doubleClickMessage = webSteps.getText("doubleClickMessage"); // Replace with the actual locator for the message after double click
        assert doubleClickMessage.equals("You have done a double click") : "Double click message not found!";

        // Right Click
        webSteps.rightClick("rightClickBtn"); // Replace with the actual locator for the Right Click button
        String rightClickMessage = webSteps.getText("rightClickMessage"); // Replace with the actual locator for the message after right click
        assert rightClickMessage.equals("You have done a right click") : "Right click message not found!";

        // Click Me
        webSteps.click("clickMeBtn"); // Replace with the actual locator for the Click Me button
        String clickMeMessage = webSteps.getText("clickMeMessage"); // Replace with the actual locator for the message after click
        assert clickMeMessage.equals("You have done a dynamic click") : "Click me message not found!";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Button actions verified successfully.");
    }
}