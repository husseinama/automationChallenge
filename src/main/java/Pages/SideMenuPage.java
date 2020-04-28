package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

/**
 * Page object for mobile pages used
 */
public class SideMenuPage extends PageBase {
    public SideMenuPage(AppiumDriver driver) {
        super(driver);
    }
    @FindBy(id = "eu.uvita:id/item_home_menu_text_view")
    public MobileElement settingsBtn;

    @FindBy(id = "eu.uvita:id/logout")
    public MobileElement logOutBtn;

    @FindBy(id = "eu.uvita:id/positive_action")
    public MobileElement logOutNowBtn;

    LandingPage landingPage;

    public void logout(AndroidDriver driver)
    {
        landingPage = new LandingPage(driver);
        landingPage.sideMenuBtn.click();
        settingsBtn.click();
        TouchAction t = new TouchAction(driver);
        t.longPress(PointOption.point(170,1350)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(170,1100)).release().perform();
        logOutBtn.click();
        logOutNowBtn.click();
    }
}
