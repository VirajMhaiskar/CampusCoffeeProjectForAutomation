package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.DriverUtility;

public class LoginPage extends WebTestBase {

    @FindBy(id = "username")
    WebElement userNameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(xpath = "//a[text()='Click here']")
    WebElement clickHereToRegister;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void setupClickHereToRegister(){
        DriverUtility.waitUntilElementToBeClickable(clickHereToRegister);
    }

    public void login(String username, String password){
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        DriverUtility.waitUntilElementToBeClickable(loginButton);
    }
}
