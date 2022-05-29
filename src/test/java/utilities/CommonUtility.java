package utilities;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CommonUtility {
    public String readProperty(String key){
        FileInputStream fileInputStream = null;
        Properties prop = null;
        String value = null;
        try{
            fileInputStream = new FileInputStream("src/test/resources/properties/DEV/dev.properties");
            prop = new Properties();
            prop.load(fileInputStream);
            value = prop.getProperty(key);
        }catch (Exception e){
             Logs.getErrorLogs(e.getMessage());
        }
        return value;
    }

}
