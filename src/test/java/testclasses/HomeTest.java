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

import java.io.IOException;

public class HomeTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public RegisterPage registerPage;

    HomeTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        registerPage = new RegisterPage();
    }

    @Test
    public void screenshotTest() throws IOException {
        homePage.closedFirstAd();
        homePage.closedSecondAd();
        homePage.takeScreenshot();
        System.out.println("ScreenShot Taken!!!");
    }

    @Test
    public void verifyURL() {
        SoftAssert softAssert = new SoftAssert();
        String urlEntered = "https://camposcoffe.com/";
        String actualURL = driver.getCurrentUrl();
        softAssert.assertEquals(urlEntered, actualURL, "URL Matched!!");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
