package com.shucai.web.listeners;

import com.shucai.web.common.BaseCase;
import com.shucai.web.utils.ScreenShotUtils;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @Desc： 截图监听类
 **/
public class ScreenShotListener implements IHookable {

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        //callBack 用来执行@Test方法的
        //testResult  @Test方法的结果 (@Test对象、方法名、是否抛出异常...)
        callBack.runTestMethod(testResult);
        //testResult
        Throwable throwable = testResult.getThrowable();
        if(throwable != null) {
            //throwable 不等于空说明@Test出现异常了，执行截图
            //通过 loginCase 取 driver
            //获取当前@Test对象
            Object object = testResult.getInstance();
            BaseCase baseCase = (BaseCase)object;
            //获取当前@Test方法名
            String methodName = testResult.getName();
            //获取当前@Test类名
            String className = testResult.getInstanceName();
            String destFileName = className + "_" + methodName + "_" + System.currentTimeMillis() + ".png";
            ScreenShotUtils.screenShot(baseCase.driver,destFileName);
        }
    }
}
