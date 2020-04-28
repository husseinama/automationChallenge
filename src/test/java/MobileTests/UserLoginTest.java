package MobileTests;

import Base.BaseMobileTest;
import Pages.*;
import com.google.gson.JsonObject;
import helper.JsonHelper;
import helper.Utils;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserLoginTest extends BaseMobileTest {
    LoginPage loginPage;
    TrackingRequestPage trackingRequestPage;
    EnterPinFromSmsPage enterPinFromSmsPage;
    LandingPage landingPage;
    SideMenuPage sideMenuPage;
    ImportPrivateKeyPage importPrivateKeyPage;
    JsonObject testData1;
    JsonHelper jsonHelper;
    Utils utils;


    @BeforeClass
    public void initTest()
    {
        jsonHelper = new JsonHelper();
        loginPage = new LoginPage(driver);
        trackingRequestPage = new TrackingRequestPage(driver);
        enterPinFromSmsPage = new EnterPinFromSmsPage(driver);
        landingPage = new LandingPage(driver);
        sideMenuPage = new SideMenuPage(driver);
        importPrivateKeyPage = new ImportPrivateKeyPage(driver);
        utils = new Utils();
        testData1 = new JsonObject();
        testData1 = jsonHelper.readJsonObjectFromFile("src/main/resources/testData1.json");

    }
    @Test
    public void UserCannotLoginWithInvalidCredentials() {

        loginPage.login(testData1.getAsJsonObject("test1").get("username").getAsString()
                ,testData1.getAsJsonObject("test1").get("password").getAsString());

        trackingRequestPage.allowConsent();

        loginPage.loginSignInBtn.click();

        Assert.assertTrue(loginPage.loginSnackBarTxt.isDisplayed(),"Snackbar didn`t appear");
        Assert.assertTrue(loginPage.loginSnackBarTxt.getText().equals("Invalid input, please try again"),"Snackbar text is not as required");
    }

    @Test
    public void UserCanLoginWithValidCredentials() throws InterruptedException {

        loginPage.login(testData1.getAsJsonObject("test2").get("username").getAsString()
                ,testData1.getAsJsonObject("test2").get("password").getAsString());

        try {
            trackingRequestPage.allowConsent();
            loginPage.loginSignInBtn.click();
        }catch (NoSuchElementException e)
        {
            System.out.println("No consent request");
        }

        Thread.sleep(20000);

        enterPinFromSmsPage.continueBtn.click();

        Thread.sleep(10000);

        importPrivateKeyPage.skipPrivateKeyPage();

        utils.waitUntillVisibleForElement(driver,landingPage.landingPageTitle);

        Assert.assertTrue(landingPage.landingPageTitle.isDisplayed(),"Title is not displayed");

    }

    @AfterMethod
    public void logout()
    {
        try {
            sideMenuPage.logout(driver);
        }catch (NoSuchElementException e)
        {
            System.out.println("Already logged out");
        }
    }
}
