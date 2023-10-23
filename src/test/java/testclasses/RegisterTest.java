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

public class RegisterTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public MyAccountPage myAccountPage;

    RegisterTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(description = "Register new user successfully.")
    public void registerUser() {
        SoftAssert softAssert = new SoftAssert();
        homePage.closedFirstAd();
        homePage.closedSecondAd();
        homePage.clickOnLoginButton();
        loginPage.setupClickHereToRegister();
        registerPage.register("temporarymail@gmail.com", "password");
        String myAccountPageText = myAccountPage.textOfMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Register Successfully");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
