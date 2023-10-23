package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.DriverUtility;

import java.io.IOException;

public class HomePage extends WebTestBase {

    @FindBy(xpath = "//a[@class = 'user-controls__ul__li__a']")
    WebElement loginElement;

    @FindBy(xpath = "//button[@title = 'Close']")
    WebElement closeFirstAd;

    @FindBy(xpath = "//a[@class = 'newsletter__close newsletter__trigger']")
    WebElement closeSecondAd;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void closedFirstAd() {
        DriverUtility.waitUntilElementToBeClickable(closeFirstAd);
    }

    public void closedSecondAd() {
        DriverUtility.waitUntilElementToBeClickable(closeSecondAd);
    }

    public void clickOnLoginButton() {
        DriverUtility.waitUntilElementToBeClickable(loginElement);
    }

    public void takeScreenshot() throws IOException {
        DriverUtility.screenshot();
    }
}
