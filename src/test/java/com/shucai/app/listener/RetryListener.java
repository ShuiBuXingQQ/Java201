package com.shucai.app.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Desc： 重试注解属性监听类
 **/
public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
        if(retryAnalyzer == null) {
            //@Test 没有设置 retryAnalyzer 属性，帮你设置一个属性
            annotation.setRetryAnalyzer(MyRetry.class);
        }
    }
}
