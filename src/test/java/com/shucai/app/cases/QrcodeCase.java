package com.shucai.app.cases;

import com.shucai.app.page.*;
import com.shucai.app.common.BaseCase;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * 扫描二维码用例，扫描app活动邀请码，跳转至对应的活动
 **/

public class QrcodeCase extends BaseCase {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        openApp();
//        //1、登录（只需做一次）
//        LoginPage loginPage = new LoginPage(androidDriver);
//        loginPage.loginSuccess("正确手机号", "正确密码", "书材0v0");
    }

    //默认取当前列表的第一个图片
    @Test
    public void qrcodeTest01() throws InterruptedException {
        //创建出页面
        HomePage homePage = new HomePage(androidDriver);
        QrcodePage qrcodePage = new QrcodePage(androidDriver);
        //调用行为
        homePage.clickHomeIcon();
        homePage.clickQrcodeIcon();
        qrcodePage.clickPhotoBtn();
        qrcodePage.clickPhotoBtn2();
        qrcodePage.clickAllPhotoBtn();
        qrcodePage.clickPhotoList();
        qrcodePage.clickToHomeBtn();
    }


    //相册列表的第3张图片   randomClickPhotoList 方法
    @Test
    public void qrcodeTest02() {
        //创建出页面
        HomePage homePage = new HomePage(androidDriver);
        QrcodePage qrcodePage = new QrcodePage(androidDriver);
        //调用行为
        homePage.clickQrcodeIcon();
        qrcodePage.clickPhotoBtn();
        qrcodePage.clickPhotoBtn2();
        qrcodePage.clickAllPhotoBtn();
        qrcodePage.randomClickPhotoList();
    }


    @AfterTest
    public void tearDown() {
        quit();
    }

}
