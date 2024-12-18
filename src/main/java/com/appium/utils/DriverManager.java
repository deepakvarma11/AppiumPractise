package com.appium.utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;

public final class DriverManager {

    private TestUtils utils = new TestUtils();

    private ThreadLocal<AppiumDriver> drivertl = new ThreadLocal<>();

    public AppiumDriver getDriver() {
        return drivertl.get();
    }

    public void setDriver(AppiumDriver driver2) {
        drivertl.set(driver2);
    }

    public void initializeDriver() {
        AppiumDriver appiumDriver = new AndroidDriver(new ServerManager().getServer().getUrl(),
                new CapabilitiesManager().getCapabilities());
        setDriver(appiumDriver);
    }

}
