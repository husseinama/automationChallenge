package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for mobile pages used
 */
public class EnterPinFromSmsPage extends PageBase {
    public EnterPinFromSmsPage(AppiumDriver driver) {
        super(driver);
    }
    @FindBy(id = "eu.uvita:id/button_confirm")
    public MobileElement continueBtn;
}
