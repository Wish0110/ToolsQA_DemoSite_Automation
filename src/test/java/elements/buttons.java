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

        webSteps.click("buttonsNav");
        webSteps.scrollToElement("btnScroll");

        // Double Click
        webSteps.doubleClick("doubleClickBtn");
        String doubleClickMessage = webSteps.getText("doubleClickMessage");
        assert doubleClickMessage.equals("You have done a double click") : "Double click message not found!";

        // Right Click
        webSteps.rightClick("rightClickBtn");
        String rightClickMessage = webSteps.getText("rightClickMessage");
        assert rightClickMessage.equals("You have done a right click") : "Right click message not found!";

        // Click Me
        webSteps.click("clickMeBtn");
        String clickMeMessage = webSteps.getText("clickMeMessage");
        assert clickMeMessage.equals("You have done a dynamic click") : "Click me message not found!";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Button actions verified successfully.");
    }
}