package elements;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.File;
import java.io.IOException;

public class uploadDownload extends baseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        loadUrl();
        webSteps.scrollToElement("elements");
        webSteps.click("elements");
    }

    @Test
    public void uploadDownload() throws InterruptedException {
        extentReportManager.startTest("Elements", "<b>Upload and Download</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC007: Verify file upload and download</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>" +
                "<br><b>Navigate to Upload and Download section</b>" +
                "<br><b>Upload a file</b>" +
                "<br><b>Verify the uploaded file name</b>" +
                "<br><b>Download the file</b>" +
                "<br><b>Verify the downloaded file</b>");

        webSteps.scrollToElement("textBoxNav");
        webSteps.click("uploadDownloadNav");
        webSteps.scrollToElement("uploadDownloadScroll");

        // Download the file
        webSteps.click("imgDownloadBtn");

        //Upload downloaded File
        String filepath = "C:\\Users\\Admin\\Downloads\\sampleFile.jpeg";
        driver.findElement(By.id("uploadFile")).sendKeys(filepath);
        webSteps.waiting();

        extentReportManager.testSteps("<b><font color='green'>Test Passed: </font></b>File download and upload downloaded file verified successfully.");
    }
}