package testclasses;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;
import testbase.WebTestBase;

public class MyAccountTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public MyAccountPage myAccountPage;

    MyAccountTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test
    public void enterAccountDetails() {
        SoftAssert softAssert = new SoftAssert();
        homePage.closedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String myAccountPageText = myAccountPage.textOfMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text Should Be Matched Here!");
        myAccountPage.MyAccountDetails();
        myAccountPage.saveChanges(prop.getProperty("firstName"), prop.getProperty("lastName"));
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
