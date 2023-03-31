package com.shucai.web.cases;

import com.shucai.web.common.BaseCase;
import com.shucai.web.common.Constants;
import com.shucai.web.pages.EmailHomePage;
import com.shucai.web.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc： 登录用例
 **/

public class LoginCase extends BaseCase {

    @BeforeTest
    public void setUp() {
        //打开浏览器、访问登录页面、网页最大化
        driver = open(Constants.BROWSER_TYPE);
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
    }

    //账号输入不对，错误提示
    @Test
    public void testFailed01() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.switchTo().frame("login_frame");
        loginPage.inputQq("123456");
        loginPage.inputPassword("12");
        loginPage.clickLoginBtn();
        Thread.sleep(1000);
        String actual = loginPage.getCenterErrorText();
        String expected = "请输入正确的账号!";
        //断言
        Assert.assertEquals(actual, expected);
    }

    //切换一下 扫码登录Tab
    @Test
    public void testFailed02() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickwxLoginTab();
        driver.switchTo().frame("login_wx_iframe");
        String actual = loginPage.getwxLoginTabText();
        Assert.assertEquals(actual, "使用微信扫一扫登录");
    }

    //登录成功
    @Test(priority = 2)
    public void testSuccess02() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.switchTo().frame("login_frame");
        loginPage.inputQq("693@qq.com");
        loginPage.inputPassword("自己密码");
        loginPage.clickLoginBtn();
        Thread.sleep(1000);
        EmailHomePage emailHomePage = new EmailHomePage(driver);
        String actual = emailHomePage.getnickName();
        //断言
        Assert.assertEquals(actual, "睡不醒");
    }

    @Test(dataProvider = "datas")
    public void testFailed03(String phone, String password, String expected) throws InterruptedException {
        //没有输入手机号码
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputQq(phone);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();
        String actual = loginPage.getCenterErrorText();
        //断言
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] datas() {
        Object[][] datas = {
                {"", "12312312", ""},
                {"1585901925", "", "你还没有输入密码!"},
                {"158590192534", "123123123", "请输入正确的账号!"}
        };
        return datas;
    }


    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        close(driver);
    }

}




