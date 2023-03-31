package com.shucai.app.page;

import com.shucai.app.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


//属性 定位信息
//方法 行为，点击，发送，获取文档....
//页面位置：我的模块页

public class MyHomePage extends BasePage {
    //未登录 昵称
    private By nickNameBy = MobileBy.xpath("//*[@text='立即登录']");
    //登录后 昵称
    private By nickName2By = MobileBy.xpath("//*[contains(@text,'书材')]");


    public MyHomePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickNickName() {
        waitElementClickable(nickNameBy).click();
    }

    public String getNickName() {
        return waitElementVisibility(nickName2By).getText();
    }


}