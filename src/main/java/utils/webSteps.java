package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static dataProviders.repositoryFileReader.constructElement;
import static dataProviders.repositoryFileReader.findElementRepo;

public class webSteps {
    protected WebDriver driver; // Use instance variable instead of static
    private final String emailSuperAdmin;
    private final String passwordSuperAdmin;
    private final String emailCustomer;
    private final String passwordCustomer;
    private final String emailSubCustomer;
    private final String passwordSubCustomer;

    // Constructor to initialize the WebDriver and load credentials
    public webSteps(WebDriver driver) {
        this.driver = driver; // Assign the passed driver to the instance variable

        // Load email and password from properties file
        Properties properties = PropertyLoader.loadProperties("src/main/resources/dataset.properties");
        this.emailSuperAdmin = properties.getProperty("emailSuperAdmin");
        this.passwordSuperAdmin = properties.getProperty("passwordSuperAdmin");
        this.emailCustomer = properties.getProperty("emailCustomer");
        this.passwordCustomer = properties.getProperty("passwordCustomer");
        this.emailSubCustomer = properties.getProperty("emailSubCustomer");
        this.passwordSubCustomer = properties.getProperty("passwordSubCustomer");
    }

    // Common method to type text into an input field
    public void type(String text, String locator) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement inputField = driver.findElement(xpath);
        inputField.clear();
        inputField.sendKeys(text);
        waiting();
    }


    // Common method to click an element
    public void click(String locator) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement button =  driver.findElement(xpath);
        button.click();
        waiting();
    }


    // Common method to get text from an element
    public String getText(String locator) {
        By xpath = constructElement(findElementRepo(locator));
        return driver.findElement(xpath).getText();
    }

    // Method to wait 2000ms
    public void waiting() throws InterruptedException {
        Thread.sleep(2000);
    }

    // Method for scroll to given element
    public void scrollToElement(String locator) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
        waiting();

    }

    // Method to generate random personal email address
    public String randomPersonalEmailAddress(){
        return ("example" + ThreadLocalRandom.current().nextInt(0, 10000) + "@gmail.com");
    }

    public void select(String locator, int loop, int bool) throws InterruptedException, AWTException {
        By xpath = constructElement(findElementRepo(locator));
        click(locator);

        Robot robot = new Robot();

        if(bool==1){
            for (int i=1;i<=loop; i++){
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);

                Thread.sleep(100);
            }

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);


        }else if(bool==0){
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } else {
            System.out.println("The boolean value is invalid");
        }

        waiting();
    }

    // Method for wait until an element to be clickable
    public void waitUntilElementToBeClickable(String locator){
        By xpath = constructElement(findElementRepo(locator));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

    public void select2(String locator) throws InterruptedException, AWTException {
        By xpath = constructElement(findElementRepo(locator));
        click(locator);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        waiting();
    }

    public void implicitWait(String locator){
        By xpath = constructElement(findElementRepo(locator));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        } catch (TimeoutException e) {
            System.out.println("Element not found after login: " + e.getMessage());

        }
    }

    // Common method to upload a file from resources folder
    public void uploadFile(String fileName, String locator) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement uploadElement = driver.findElement(xpath);

        // Construct the absolute path to the file
        String resourcePath = "src/main/resources/assets/" + fileName;
        File file = new File(resourcePath);

        if (!file.exists()) {
            throw new RuntimeException("File not found: " + resourcePath);
        }

        // Use the sendKeys method to upload the file
        uploadElement.sendKeys(file.getAbsolutePath());
        waiting(); // Optional: wait after uploading
    }

    // Helper method to generate a random string
    public String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }

    //date picker
    public void selectDate(String datePickerLocator, String date) throws InterruptedException {

        click(datePickerLocator);

        // Wait for the calendar to be visiblee
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@role, 'grid')]")));

        // Locate the button for the specified date
        String dateButtonXPath = String.format("//button[@name='day' and text()='%s']", date);
        WebElement dateButton = driver.findElement(By.xpath(dateButtonXPath));

        // Click the date button
        dateButton.click();
        waiting();
    }

    //Generate Random Number
    public int generateRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound + 1);
    }

    // Method to get the locator based on your locator strategy
    private By getLocator(String locator) {
        // Implement your locator strategy here (e.g., by ID, name, XPath, etc.)
        // Example:
        return By.id(locator); // Adjust this based on your locator strategy
    }

    public boolean isElementEnabled(String locator) {
        try {
            WebElement element = driver.findElement(getLocator(locator));
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + locator);
            return false; // Return false if the element is not found
        }
    }

    public String getCssValue(String locator, String propertyName) {
        try {
            WebElement element = driver.findElement(getLocator(locator));
            return element.getCssValue(propertyName);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + locator);
            return null; // Return null if the element is not found
        }
    }

    //clear text field
    public void clearText(String locator) {
        try {
            WebElement element = driver.findElement(getLocator(locator));
            element.clear(); // Clear the text field
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + locator);
        }
    }

    public void doubleClick(String locator) {
        try {
            WebElement element = driver.findElement(getLocator(locator));
            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform(); // Perform double click
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + locator);
        }
    }

    public void rightClick(String locator) {
        try {
            WebElement element = driver.findElement(getLocator(locator));
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform(); // Perform right click
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + locator);
        }
    }

    // Method to select an option from a dropdown using visible text
    public void selectByVisibleText(String locator, String visibleText) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement dropdownElement = driver.findElement(xpath);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
        waiting();
    }

    // Method to select an option from a dropdown using index
    public void selectByIndex(String locator, int index) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement dropdownElement = driver.findElement(xpath);
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
        waiting();
    }

    // Method to select an option from a dropdown using value
    public void selectByValue(String locator, String value) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement dropdownElement = driver.findElement(xpath);
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
        waiting();
    }

    // Method to select a full date (day, month, year) from a date picker
    public void selectFullDate(String datePickerLocator, String day, String month, String year) throws InterruptedException {

        click(datePickerLocator);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));

        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(month);

        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select")); // Adjust based on the actual class name
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);

        String dayXPath = String.format("//div[contains(@class, 'react-datepicker__day') and text()='%s']", day);
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXPath)));
        dayElement.click();

        waiting();
    }

    // Method to press the Enter key
    public void pressEnter() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        waiting(); // Optional: wait after pressing Enter
    }

    public void typewithenter(String text, String locator) throws InterruptedException, AWTException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement inputField = driver.findElement(xpath);
        inputField.clear();
        inputField.sendKeys(text);
        waiting();
        pressEnter(); // Press Enter after typing
    }

    public void switchToFrame(String frameNameOrId) {
        try {
            driver.switchTo().defaultContent(); // Always switch back to main content before switching frames
            driver.switchTo().frame(frameNameOrId);
            System.out.println("Switched to frame: " + frameNameOrId);
        } catch (NoSuchFrameException e) {
            System.err.println("Frame not found: " + frameNameOrId);
            throw e;
        }
    }

    public boolean isDisplayed(String locatorKey) {
        try {
            // Retrieve the locator from your locator repository using the locatorKey
            By locator = getLocator(locatorKey); // Implement getLocator to return By object based on locatorKey
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void dragSlider(String sliderHandleLocator, int value) throws InterruptedException {
        By xpath = constructElement(findElementRepo(sliderHandleLocator));
        WebElement sliderHandle = driver.findElement(xpath);

        // Get the current position of the slider handle
        int currentX = sliderHandle.getLocation().getX();
        int sliderWidth = sliderHandle.getSize().getWidth();

        // Calculate the new position based on the desired value
        // Assuming the slider's range is from 0 to 100, adjust as necessary
        int newPosition = currentX + (value * sliderWidth / 100); // Adjust this calculation based on the slider's actual range

        // Create an Actions object to perform the drag-and-drop
        Actions action = new Actions(driver);
        action.clickAndHold(sliderHandle) // Click and hold the slider handle
                .moveByOffset(newPosition - currentX, 0) // Move to the new position
                .release() // Release the handle
                .perform(); // Execute the action

        waiting(); // Optional: wait after dragging
    }

    // Method to hover over an element
    public void hover(String locator) throws InterruptedException {
        By xpath = constructElement(findElementRepo(locator));
        WebElement elementToHover = driver.findElement(xpath);

        // Create an Actions object
        Actions actions = new Actions(driver);

        // Perform the hover action
        actions.moveToElement(elementToHover).perform();

        // Optional: wait for a short duration to ensure the tooltip appears
        waiting(); // You can adjust this wait time as necessary
    }

    public void overloadSelect(String locator, String optionText) {
        By xpath = constructElement(findElementRepo(locator));
        WebElement dropdown = driver.findElement(xpath);
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText); // Select by visible text
    }

}