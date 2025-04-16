package Widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class ToolTips extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("widgets");
        webSteps.click("widgets");
        webSteps.scrollToElement("toolTipsNav");
        webSteps.click("toolTipsNav");
    }

    @Test
    public void testToolTips() throws InterruptedException {
        extentReportManager.startTest("Widgets", "<b>ToolTips</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify ToolTips functionality</b>");

        // Hover over the element to display the tooltip
        webSteps.hover("BtnTooltipElement");
        webSteps.waiting(); // Wait for the tooltip to appear

        // Verify the tooltip text
        String expectedTooltipText = "You hovered over the Button";
        String actualTooltipText = webSteps.getText("tooltipText");
        assert actualTooltipText.equals(expectedTooltipText) : "Expected tooltip text not found! Expected: '" + expectedTooltipText + "' but got: '" + actualTooltipText + "'";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>ToolTips functionality verified successfully.");
    }
}