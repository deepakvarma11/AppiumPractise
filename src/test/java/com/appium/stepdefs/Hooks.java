package com.appium.stepdefs;

import com.appium.pages.BasePage;
import com.appium.utils.DriverManager;
import com.appium.utils.TestCache;
import com.appium.utils.VideoManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class Hooks {
    @Before
    public void launch() {
        BasePage basePage = new BasePage();
        basePage.closeApp();
        basePage.launchApp();

        new VideoManager().startRecording();
        TestCache.initialize();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        TestCache.remove();

        if (scenario.isFailed()) {
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        new VideoManager().stopRecord(scenario.getName());
    }

}
