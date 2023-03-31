package com.shucai.app.cases;

import com.shucai.app.common.BaseCase;
import com.shucai.app.page.HomePage;
import com.shucai.app.page.MyHomePage;
import com.shucai.app.page.SearchPage;
import com.shucai.app.page.LoginPage;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * 登录用例
 **/
public class LoginCase extends BaseCase {


    @BeforeTest
    public void setUp() throws MalformedURLException {
        openApp();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void loginTest() throws InterruptedException {
        //创建出页面.
        HomePage homePage = new HomePage(androidDriver);
        MyHomePage myHomePage = new MyHomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        //调用行为
        homePage.clickMyHome();
        myHomePage.clickNickName();
        loginPage.clickPasswordLoginSwitch();
        //工具无法打开页面查找元素，可以通过getPageSource()方法，看到页面源码
//            Thread.sleep(2000);
//            System.out.println(androidDriver.getPageSource());
        loginPage.inputMobile("13323235555");
        loginPage.inputPassword("123456");
        loginPage.clickUserConsentBtn();
        loginPage.clickLoginBtn();
        loginPage.clicNoSaveBtn();
        //断言
        String actual = loginPage.getToastText("用户名或密码错误");
        Assert.assertEquals(actual, "用户名或密码错误");
        loginPage.clicNoSaveBtn();
//        loginPage.clickCloseBtn();
        loginPage.pointXY(65, 145);

    }

    //执行优先级 不写默认0 ，0级最先执行
    @Test(priority = 1)
    public void loginSuccess01() throws InterruptedException {
        //创建出页面
        LoginPage loginPage = new LoginPage(androidDriver);
        //登录流程
        loginPage.loginSuccess("正确手机号", "正确密码", "书材0v0");

    }


//    @Test(dataProvider = "datas")
    public void loginFailed02(String mobile,String password,String toastExpected)  {
        //创建出页面
        LoginPage loginPage = new LoginPage(androidDriver);

            try {
                //登录流程
                loginPage.loginFailed(mobile,password,toastExpected);
                loginPage.pointXY(65, 145);
                //   loginPage.clickCloseBtn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    @DataProvider
    public Object[][] datas() {
        Object[][] datas = {
                {"123456789", "123123", "用户名或密码错误"},
                {"Q", "t", "用户名或密码错误"},
                {"13323234123456789545", "13323234123456789545", "用户名或密码错误"},
                {"@#$", "=", "用户名或密码错误"}
        };
        return datas;
    }

    //    @AfterTest
    public void tearDown() {
        quit();
    }


}
