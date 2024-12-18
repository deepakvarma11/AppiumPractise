package com.appium.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    TestUtils utils = new TestUtils();
    ThreadLocal<Properties> prop = new ThreadLocal<>();

    public void setProps()  {
        Properties properties = new Properties();

        InputStream inputStream = null;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream("configs/config.properties");
            properties.load(inputStream);
            prop.set(properties);
        } catch (IOException e) {
            e.printStackTrace();
            utils.log().fatal("Failed to load the config properties..! " + e.toString());
            throw new RuntimeException(e);
        }
    }

    public Properties getProps(){
        if(prop.get() == null){
            setProps();
        }
        return prop.get();
    }

    public void clearProperties(){
        if(prop.get() != null){
            prop.remove();
        }
    }
}
