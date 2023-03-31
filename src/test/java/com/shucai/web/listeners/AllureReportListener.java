package com.shucai.web.listeners;

import com.shucai.web.common.BaseCase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @Desc： Allure报表截图类
 **/
public class AllureReportListener implements IHookable {

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        //执行@Test方法
        callBack.runTestMethod(testResult);
        Throwable throwable = testResult.getThrowable();
        if(throwable != null) {
            //throwable 不等于空说明@Test出现异常了，执行截图
            //获取@Test执行类对象
            Object object = testResult.getInstance();
            //转出BaseCase
            BaseCase baseCase = (BaseCase)object;
            //把driver转出可截图对象
            TakesScreenshot screenshot = (TakesScreenshot)baseCase.driver;
            //截图并返回字符数组（文件流）
            byte[] screenShot = screenshot.getScreenshotAs(OutputType.BYTES);
            //allure收集图片信息
            saveScreenshot(screenShot);
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }


}
