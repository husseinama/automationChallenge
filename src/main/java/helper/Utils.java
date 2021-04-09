package helper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Wait method - till visible
 */
public class Utils {
    protected static WebDriverWait wait;

    public void waitUntillVisibleForElement(AndroidDriver driver, MobileElement element)
    {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
