package com.appium.utils;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class VideoManager {

    TestUtils utils = new TestUtils();

    private boolean shouldRecord(){
        Properties properties = new PropertyReader().getProps();
        return Boolean.parseBoolean(properties.getProperty("videoRecording"));
    }

    public void startRecording() {
        if (shouldRecord()) {
            ((CanRecordScreen)new DriverManager().getDriver()).startRecordingScreen();
        }
    }

    public void stopRecord(String scenarioName) throws IOException {
        if(shouldRecord()){
            String media = ((CanRecordScreen) new DriverManager().getDriver()).stopRecordingScreen();
            CapabilitiesManager capabilitiesManager = new CapabilitiesManager();
            String path = capabilitiesManager.getCapabilities().getPlatformName() + "_"
                    + capabilitiesManager.getCapabilities().getDeviceName() + File.separator + "videos";

            File videoDir = new File(path);

            synchronized (videoDir) {
                if (!videoDir.exists()) {
                    videoDir.mkdirs();
                }
            }

            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(videoDir + File.separator + scenarioName + ".mp4");
                outputStream.write(Base64.decodeBase64(media));
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if(outputStream != null){
                    outputStream.close();
                }
            }
        }
    }
}
