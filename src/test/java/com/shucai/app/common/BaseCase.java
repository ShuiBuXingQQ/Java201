package com.shucai.app.common;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

//Cases 的父类  功能是开启APP
public class BaseCase {
    private static Logger logger = Logger.getLogger(BaseCase.class);
    public AndroidDriver androidDriver;

    public void openApp() throws MalformedURLException {
        logger.info("====================打开app==========================");
        //配置设备的信息
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //1、设备平台
        desiredCapabilities.setCapability("platformName", Constants.PLATFORM_NAME);
        //2、设备名称
        desiredCapabilities.setCapability("deviceName", Constants.DEVICE_NAME);
        //3、app包名
        desiredCapabilities.setCapability("appPackage", Constants.APP_PACKAGE);
        //4、app activity 入口名称
        desiredCapabilities.setCapability("appActivity", Constants.APP_ACTIVITY);
        desiredCapabilities.setCapability("noReset", true); //启动APP时 不重置登录信息
        //Appium Server接口地址
        URL remoteUrl = new URL(Constants.REMOTE_URL);
        //创建 Android 驱动
        androidDriver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    public void quit() {
        try {
            logger.info("====================关闭app==========================");
            Thread.sleep(3000);
            androidDriver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
