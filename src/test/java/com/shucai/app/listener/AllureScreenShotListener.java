package com.shucai.app.listener;

import com.shucai.app.common.BaseCase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @Desc： Allure报表截图监听
 **/
public class AllureScreenShotListener implements IHookable {

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
            byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screenshotAs);
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }


}
