package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for mobile pages used
 */
public class TrackingRequestPage extends PageBase {
    public TrackingRequestPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='I consent']")
    private MobileElement ConsentPermissionAllowBtn;

    public void allowConsent()
    {
        try {
            ConsentPermissionAllowBtn.click();
        }catch (NoSuchElementException e)
        {
            System.out.println("Consent request didn`t appear "+e);
        }
    }
}
