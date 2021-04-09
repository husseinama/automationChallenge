package Base;

import helper.PropertyFileHandler;
import org.testng.annotations.BeforeSuite;

/**
 * Responsible for defining the common methods between all tests
 */
public class BaseTest {

    PropertyFileHandler propertyFileHandler;

    @BeforeSuite
    public void InitPropertyFile()
    {
        propertyFileHandler = new PropertyFileHandler();
        propertyFileHandler.loadPropertiesFile("src/main/resources/TestConfig.properties");

    }
}
