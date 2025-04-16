package Interactions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Sortable extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("interaction");
        webSteps.click("interaction");
        webSteps.scrollToElement("sortableNav");
        webSteps.click("sortableNav");
    }

    @Test
    public void sortable() throws InterruptedException {
        extentReportManager.startTest("interactions", "<b>Sortable</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC005: Verify sortable functionality</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Drag and drop items to reorder them</b>" +
                "<br><b>Verify the order of items</b>");

        // Drag and drop items
        webSteps.dragAndDrop("SortItem1", "SortItem2");

        // Verify the order
        String firstItemText = webSteps.getText("SortItem1");
        String secondItemText = webSteps.getText("SortItem2");

        // Verify the order
        assert firstItemText.equals("Two") : "Item 1 is not in the expected position!";
        assert secondItemText.equals("One") : "Item 2 is not in the expected position!";

        webSteps.click("GridNav");

        webSteps.dragAndDrop("GridSortItem1", "GridSortItem9");

        // Verify the order
        firstItemText = webSteps.getText("GridSortItem1");
        secondItemText = webSteps.getText("GridSortItem9");

        // Verify the order
        assert firstItemText.equals("Two") : "Item 1 is not in the expected position!";
        assert secondItemText.equals("One") : "Item 2 is not in the expected position!";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Sortable functionality verified successfully.");
    }
}