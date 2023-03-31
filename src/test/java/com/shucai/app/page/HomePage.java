package com.shucai.app.page;

import com.shucai.app.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//属性 定位信息
//方法 行为，点击，发送，获取文档....
//页面位置：首页

public class HomePage extends BasePage {
    //首页homeicon
    private By homeIconBy = MobileBy.id("me.ele:id/img_1_substitute");
    //我的模块icon
    private By myHomeBy = MobileBy.id("me.ele:id/img_4_lottie");
    //首页扫码图标
    private By qrcodeIconBy = MobileBy.AccessibilityId("扫码");
    //搜索框
    private By searchBoxBy = MobileBy.id("me.ele:id/search");

    public HomePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickHomeIcon() {
        waitElementClickable(homeIconBy).click();
    }
    public String getHomeIcon() {
        return waitElementVisibility(homeIconBy).getText();
    }

    public void clickMyHome() {
        waitElementClickable(myHomeBy).click();
    }
    public String getMyHome() {
        return waitElementVisibility(myHomeBy).getText();
    }

    public void clickQrcodeIcon() {
        waitElementClickable(qrcodeIconBy).click();
    }
    public String getQrcodeIcon() {
        return waitElementVisibility(qrcodeIconBy).getText();
    }

    public void clickSearchBox() {
        waitElementClickable(searchBoxBy).click();
    }
    public String getSearchBox() {
        return waitElementVisibility(searchBoxBy).getText();
    }



}