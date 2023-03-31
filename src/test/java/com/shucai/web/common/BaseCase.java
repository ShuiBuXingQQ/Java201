package com.shucai.web.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * @Desc： 用例父类
 *
 **/
public class BaseCase {

    public WebDriver driver ;

    /**
     * 关闭驱动
     * @param driver
     * @throws InterruptedException
     */
    public static void close(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /**
     * 打开浏览器
     * @param type          浏览器类型
     * @return
     */
    public static WebDriver open(String type) {
        WebDriver driver = null;
        if("chrome".equalsIgnoreCase(type)) {
            System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            //设置chrome为无头浏览器模式
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");
//            driver = new ChromeDriver(chromeOptions);

        }else if("ie".equalsIgnoreCase(type)) {
            //1、设置ie启动项
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //1.1、忽略 缩放
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
            //1.2、忽略 保护模式
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //1.3、设置初始化浏览器地址
            capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://www.baidu.com");
            //2、设置浏览器驱动位置
            System.setProperty("webdriver.ie.driver","src/test/resources/IEDriverServer.exe");
            //3、创建IE驱动对象
            driver = new InternetExplorerDriver(capabilities);
        }else if("firef4ox".equalsIgnoreCase(type)) {
            System.setProperty("webdriver.firefox.bin","D:\\azrj\\Mozilla Firefox\\firefox.exe");
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
//            System.setProperty("webdriver.firefox.bin", SpiderConfig.getValue("webdriver.firefox.bin"));
//            FirefoxProfile firefoxProfile = new FirefoxProfile(new File(SpiderConfig.getValue("webdriver.firefox.profile.path")));
//             driver = new FirefoxDriver(firefoxProfile);
        }
        return driver;
    }
}
