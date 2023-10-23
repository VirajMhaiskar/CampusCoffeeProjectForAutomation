package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.DriverUtility;

public class RegisterPage extends WebTestBase {

    @FindBy(id = "reg_email")
    WebElement emailBox;

    @FindBy(id = "reg_password")
    WebElement passwordBox;

    @FindBy(name = "mailchimp_woocommerce_newsletter")
    WebElement checkBox;

    @FindBy(xpath = "//strong[text()='Error:']")
    WebElement errorTextMessage;

    @FindBy(name = "register")
    WebElement registerButton;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    public void register(String userName, String password) {
        emailBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        DriverUtility.waitUntilElementToBeClickable(registerButton);
    }

    public boolean displayErrorMessage() {
        return DriverUtility.isDisplayed(errorTextMessage);
    }

}
