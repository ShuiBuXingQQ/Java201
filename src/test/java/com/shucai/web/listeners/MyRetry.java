package com.shucai.web.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {
    //当前重试次数
    private int retryCount = 0;
    //最大重试次数
    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        //如果当前重试次数大于最大重试次数，不再重试
        if (retryCount < maxRetryCount) {
            //当前次数+1
            retryCount++;
            return true;
        }
        return false;
    }
}
