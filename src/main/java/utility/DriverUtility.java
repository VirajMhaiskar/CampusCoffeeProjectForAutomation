package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.WebTestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class DriverUtility extends WebTestBase {

    public static final long PAGE_LOAD_TIME = 20;
    public static final long IMPLICIT_WAIT = 20;
    public static final long EXPLICIT_WAIT = 20;
    public  static WebDriverWait wait;
    public static JavascriptExecutor js;
    // Create a Select object
    public static Select select;
    public static Actions actions = new Actions(driver);
    public static void waitUntilElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public static String getTextOfElement(WebElement element){
        return element.getText();
    }

    // For Scrolling
    public static void scroll(int xOffset, int yOffset) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + xOffset + "," + yOffset + ")");
    }

    // For Selecting the Element
    public static boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    // For Hovering Over Element
    public static void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    //Take new ScreenShot
    public static void screenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotName = "screenshot_" + timestamp + ".png";
        File targetFile = new File(System.getProperty("user.dir") + "/" + screenshotName);
        FileHandler.copy(file, targetFile);
    }

    // For Displaying the WebElement
    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    // For Selecting From DropDown
    public static void selectOptionFromDropdown(WebElement dropdownElement, String optionText) {
        select = new Select(dropdownElement);
        // Select By Visible Text
        select.selectByVisibleText(optionText);
    }
}
