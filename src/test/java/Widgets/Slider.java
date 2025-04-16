package Widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Slider extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("widgets");
        webSteps.click("widgets");
        webSteps.scrollToElement("WidgetsScroll");
        webSteps.click("sliderNav");
    }

    @Test(priority = 1)
    public void testSlider() throws InterruptedException {
        extentReportManager.startTest("Widgets", "<b>Slider</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC001: Verify Slider functionality</b>");

        // Get the initial value of the slider
        String initialValue = webSteps.getText("sliderValue");
        System.out.println("Initial Slider Value: " + initialValue);

        webSteps.waiting();
        webSteps.click("sliderValue");

        // Verify the new value of the slider
        String newValue = webSteps.getAttribute("sliderValue", "value"); // Use getAttribute to get the value attribute
        assert newValue.equals("50") : "Expected slider value not found! Expected: '50' but got: '" + newValue + "'";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Slider functionality verified successfully.");
    }
}