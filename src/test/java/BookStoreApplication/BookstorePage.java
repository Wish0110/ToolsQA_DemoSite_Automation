package BookStoreApplication;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class BookstorePage extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.waiting();
        webSteps.scrollToElement("bookStore");
        webSteps.click("bookStore");
    }

    @Test
    public void bookstore() throws InterruptedException {
        extentReportManager.startTest("Book Store Application", "<b>Bookstore</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC002: Verify bookstore functionality</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Bookstore</b>" +
                "<br><b>Search a book</b>" +
                "<br><b>Verify the book is searched</b>" +
                "<br><b>Select a book</b>");

        // Verify the list of books
        webSteps.type("Eloquent JavaScript","bookStoreSearch");

        // Select a book
        // Verify the book is added
        String confirmationMessage = webSteps.getText("selectBook");
        assert confirmationMessage.equals("Eloquent JavaScript, Second Edition") : "Book was not found.";

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>Bookstore functionality verified successfully.");
    }
}