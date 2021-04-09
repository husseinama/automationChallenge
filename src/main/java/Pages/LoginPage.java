package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for mobile pages used
 */
public class LoginPage extends PageBase {
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    @FindBy(id = "eu.uvita:id/email")
    public MobileElement loginEmailTxt;

    @FindBy(id = "eu.uvita:id/password")
    public MobileElement loginPasswordTxt;

    @FindBy(id = "eu.uvita:id/login_fragment_sign_in_button")
    public MobileElement loginSignInBtn;

    @FindBy(id = "eu.uvita:id/snackbar_text")
    public MobileElement loginSnackBarTxt;

    public void login (String email, String password)
    {
        loginEmailTxt.sendKeys(email);
        loginPasswordTxt.sendKeys(password);
        loginSignInBtn.click();
    }

}
