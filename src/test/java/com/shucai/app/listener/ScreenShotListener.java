package com.shucai.app.listener;

import com.shucai.app.common.BaseCase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

/**
 * @Desc： 截图监听类
 **/
public class ScreenShotListener implements IHookable {

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if(testResult.getThrowable() != null) {
            //发生异常
            //截图 driver
            Object object = testResult.getInstance();
            //把Case对象强转成父类BaseCase
            BaseCase baseCase = (BaseCase)object;
            TakesScreenshot screenshot = (TakesScreenshot)baseCase.androidDriver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("src/test/resources/"+System.currentTimeMillis()+".png");
            try {
                FileUtils.copyFile(srcFile,destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
