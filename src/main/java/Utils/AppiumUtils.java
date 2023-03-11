package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class AppiumUtils {
    protected static AppiumDriver driver;
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static AppiumDriverLocalService service;

    public AppiumUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void startAppiumServer() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//data.properties");
        properties.load(fis);
        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : properties.getProperty("ipAddress");
        service = new AppiumServiceBuilder().withAppiumJS(new File("/Users/mazenathabet/Desktop/Programs/node-v18.14.2-darwin-x64/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAddress).usingPort(Integer.parseInt(properties.getProperty("port"))).build();
        System.out.println("Starting the Appium server on port " + properties.getProperty("port") + "... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
        service.start();
    }

    public static void stopAppiumServer() {
        service.stop();
        System.out.println("Tearing down the Appium server ... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
    }

}

