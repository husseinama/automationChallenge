package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

/**
 * Responsible for defining the common methods between all mobile tests
 */
public class BaseMobileTest extends BaseTest {
    public static AndroidDriver driver;
    private static AppiumDriverLocalService service;

    //Load the desired capabilities and start the driver
    @BeforeSuite
    public void IntializeSession() throws IOException {
        service = startServer();

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, System.getProperty("deviceName"));
        cap.setCapability("platformName", System.getProperty("platformName"));
        cap.setCapability("appPackage", System.getProperty("appPackage"));
        cap.setCapability("appActivity", System.getProperty("appActivity"));
        //cap.setCapability(MobileCapabilityType.FULL_RESET,System.getProperty("fullReset"));

        driver = new AndroidDriver(new URL(System.getProperty("localHost")), cap);

    }

    //Start Appium server if not running and if running load the same service
    private AppiumDriverLocalService startServer() {
        boolean portFlag = checkIfServerIsRunnning(Integer.parseInt(System.getProperty("port")));
        if (portFlag == false) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    //Check if appium server is running
    private static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    //Close the driver and the appium server after the test
    @AfterSuite
    public void stopAppiumDriver()
    {
        driver.quit();
        service.stop();
    }

}
