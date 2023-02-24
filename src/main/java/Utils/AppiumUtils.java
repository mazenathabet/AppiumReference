package Utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppiumUtils {
    private static AppiumDriverLocalService service;
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void startAppiumServer() {
        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        System.out.println("Starting the Appium server ... "+"\n"+df.format(new Date())+
                "\n----------------------------------------------------------------");
        service.start();
    }
    public static void stopAppiumServer(){
        service.stop();
        System.out.println("Tearing down the Appium server ... "+"\n"+df.format(new Date())+
                "\n----------------------------------------------------------------");
    }
}

