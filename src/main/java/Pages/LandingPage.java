package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for mobile pages used
 */
public class LandingPage extends PageBase {
    public LandingPage(AppiumDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    public MobileElement sideMenuBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Activity']")
    public MobileElement landingPageTitle;


}
