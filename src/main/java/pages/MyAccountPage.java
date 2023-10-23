package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.DriverUtility;


public class MyAccountPage extends WebTestBase {

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountText;

    @FindBy(xpath = "//a[text() = 'Account details']")
    WebElement accountDetails;

    // Account Details

    @FindBy(xpath = "//input[@id = 'account_first_name']")
    WebElement updateFirstName;

    @FindBy(xpath = "//input[@id = 'account_last_name']")
    WebElement updateLastName;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement saveChangesBtn;

    // Shop
    @FindBy(xpath = "//a[text() = 'Shop']")
    WebElement shopPage;

    @FindBy(xpath = "//a[text() = 'Coffee']")
    WebElement selectFromHover;

    @FindBy(xpath = "//div[text()= 'Dark City']")
    WebElement productForPurchase;

    @FindBy(xpath = "//select[@class = 'pa_weight']")
    WebElement selectFromDropDown;

    @FindBy(xpath = "//a[@class = 'newsletter__close newsletter__trigger']")
    WebElement closeSecondAdInShop;

    @FindBy(xpath = "//div[text()= 'Whole Beans']")
    WebElement selectGrind;

    @FindBy(xpath = "//div[text()= 'Once off']")
    WebElement selectOnceOff;

    @FindBy(xpath = "//a[@class = 'button add-to-cart__button button--primary']")
    WebElement addToCart;

    public void navigateShopPage() throws InterruptedException {
        DriverUtility.hoverOverElement(shopPage); //Hover
        DriverUtility.waitUntilElementToBeClickable(selectFromHover);  // Select from hover
        DriverUtility.waitUntilElementToBeClickable(productForPurchase);
        DriverUtility.scroll(0,150); // scroll
        Thread.sleep(4000);
        DriverUtility.waitUntilElementToBeClickable(closeSecondAdInShop);
        DriverUtility.waitUntilElementToBeClickable(selectFromDropDown); // dropdown
        DriverUtility.selectOptionFromDropdown(selectFromDropDown,"250g"); // Select from DropDown
        DriverUtility.scroll(0,250); //scroll
        DriverUtility.waitUntilElementToBeClickable(selectGrind);
        DriverUtility.waitUntilElementToBeClickable(selectOnceOff);
        DriverUtility.waitUntilElementToBeClickable(addToCart);
    }

    public void saveChanges(String firstName, String lastName){
        updateFirstName.sendKeys(firstName);
        updateLastName.sendKeys(lastName);
        DriverUtility.waitUntilElementToBeClickable(saveChangesBtn);
    }

    public void MyAccountDetails() {
        DriverUtility.waitUntilElementToBeClickable(accountDetails);
//        DriverUtility.scroll("window.scrollBy(0,350)", "");
    }

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public String textOfMyAccount() {
        return DriverUtility.getTextOfElement(myAccountText);
    }

}
