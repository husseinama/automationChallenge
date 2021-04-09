package helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Read Properties file and load it to System
 */
public class PropertyFileHandler {


    public void loadPropertiesFile(String filePath)
    {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


}
