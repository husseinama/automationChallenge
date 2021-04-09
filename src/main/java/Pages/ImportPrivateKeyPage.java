package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for mobile pages used
 */
public class ImportPrivateKeyPage extends PageBase {
    public ImportPrivateKeyPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    public MobileElement backBtn;

    public void skipPrivateKeyPage()
    {
        backBtn.click();
    }
}
