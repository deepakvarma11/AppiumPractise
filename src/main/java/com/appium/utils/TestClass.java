package com.appium.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;

public class TestClass {

    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setPlatformName("Android")
                .setDeviceName("Pixel_3a")
                .setApp("C:\\Users\\Deepak_Battini\\eclipse-workspace\\AppiumPractise\\src\\main\\resources\\App\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity("com.swaglabsmobileapp.SplashActivity");

        AppiumDriver appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);

        ((InteractsWithApps)appiumDriver).activateApp(String.valueOf(options.getAppActivity()));
//        AppiumDriverLocalService appiumDriverLocalService = AppiumDriverLocalService.buildService()
    }
}
