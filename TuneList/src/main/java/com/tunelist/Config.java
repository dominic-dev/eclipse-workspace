package com.tunelist;

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
            input = new FileInputStream("/home/dominic/eclipse-workspace/TuneList/config/config.properties");
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
