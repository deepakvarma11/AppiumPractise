package com.appium.utils;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.util.Properties;

public class CapabilitiesManager {

    private Properties properties = new PropertyReader().getProps();

    public UiAutomator2Options getCapabilities() {
        if (properties.getProperty("platform").equals("android")) {
            return getAndroidCapabilities();
        } else {
            return getIOSCapabilities();
        }
    }

    private UiAutomator2Options getAndroidCapabilities() {
        UiAutomator2Options options = new UiAutomator2Options().setPlatformName("Android")
                .setDeviceName("pixel_3a")
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setAppActivity("com.swaglabsmobileapp.SplashActivity")
                .setAppPackage("com.swaglabsmobileapp")
                .setApp(System.getProperty("user.dir") + "/src/main/resources/App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        return options;
    }

    private UiAutomator2Options getIOSCapabilities() {
        UiAutomator2Options iosOptions = new UiAutomator2Options();
        return iosOptions;
    }

}
