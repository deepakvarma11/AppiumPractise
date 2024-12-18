package com.appium.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class ServerManager {

    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void stopAppiumServer(){
        if(server.get() != null){
            server.get().stop();
            server.remove();
        }
    }

    public static void startServer(){
        AppiumDriverLocalService appiumDriverLocalService = WindowsGetAppiumService();
        appiumDriverLocalService.start();
        if(appiumDriverLocalService == null || !appiumDriverLocalService.isRunning()){
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        appiumDriverLocalService.clearOutPutStreams(); // -> Comment this if you want to see server logs in the console
        server.set(appiumDriverLocalService);
    }

    private static AppiumDriverLocalService WindowsGetAppiumService() {
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File("src/main/resources/Logs/Server.log")));
    }
}
