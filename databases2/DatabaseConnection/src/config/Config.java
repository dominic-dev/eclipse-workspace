package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config{
    public Properties prop;
    
    public Config() {
        InputStream input = null;
        prop = new Properties();
              

        try{
            input = new FileInputStream(System.getProperty("user.dir") + "/config/config.properties");
            prop.load(input);
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key){
        return prop.getProperty(key);
    }

}
