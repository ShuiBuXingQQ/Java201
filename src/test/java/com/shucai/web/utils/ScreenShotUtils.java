package com.shucai.web.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * @Desc： 截图工具类
 **/
public class ScreenShotUtils {

    /**
     * 截图方法
     * @param driver                浏览器驱动
     * @param destFileName          目标文件名称
     */
    public static void screenShot(WebDriver driver, String destFileName) {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        System.out.println(srcFile.getAbsolutePath());
        //srcFile 剪切
        File destFile = new File("src/test/resources/" + destFileName);
        try {
            FileUtils.moveFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
