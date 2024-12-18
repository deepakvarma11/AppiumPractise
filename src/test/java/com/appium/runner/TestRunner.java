package com.appium.runner;

import com.appium.utils.DriverManager;
import com.appium.utils.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={
                "pretty","html:target/cucumber/report.html"
        },
        features = {"src/test/resources/features/Login.feature"},
        glue = {"com.appium.stepdefs"},
        dryRun = false

)
public class TestRunner {


        @BeforeClass
        public static void initialise(){
                new ServerManager().startServer();
                new DriverManager().initializeDriver();
        }

        @AfterClass
        public static void quit(){
                if(new DriverManager().getDriver() != null){
                        new DriverManager().getDriver().quit();
                        new DriverManager().setDriver(null);
                }
                new ServerManager().stopAppiumServer();
        }
}
