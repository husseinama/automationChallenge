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
    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    public MobileElement settingsBtn;

    @FindBy(id = "")
    public MobileElement logOutBtn;

    public void logout(AndroidDriver driver)
    {
        settingsBtn.click();
        TouchAction t = new TouchAction(driver);
        t.longPress(PointOption.point(170,1350)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(170,1100)).release().perform();
        logOutBtn.click();
    }
}
