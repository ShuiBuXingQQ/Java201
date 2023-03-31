package com.shucai.app.page;

import com.shucai.app.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;


//属性 定位信息
//方法 行为，点击，发送，获取文档....
//页面位置：登录页

public class LoginPage extends BasePage {
    //密码登录切换按钮
    private By passwordLoginSwitchBy = MobileBy.xpath("//*[@text='密码登录']");
    //手机号输入框
    private By mobileBy = MobileBy.xpath("//*[@text='手机/用户名']");
    //密码输入框
    private By passwordBy = MobileBy.xpath("//*[@text='密码']");
    //用户协议同意条款
    private By userConsentBtnBy = MobileBy.xpath("//*[@text='已阅读并同意']");
    //登录按钮
    private By loginBtnBy = MobileBy.xpath("//*[@text='登录']");
    //点击登录后弹窗点击 【取消按钮】
    private By noSaveBtnBy = MobileBy.xpath("//*[@text='取消']");
//    private By passwordFailBy = MobileBy.xpath("//*[@text='用户名或密码错误']");
    //左上角【X】关闭按钮  现在定位不到元素，使用固定坐标操作
    private By closeBtnBy = MobileBy.id("android:id/content");


    //属性 定位信息
    //方法 行为 点击，发送，获取文档...
    public LoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }


    public void clickPasswordLoginSwitch() {
        waitElementClickable(passwordLoginSwitchBy).click();
    }
    public void inputMobile(String mobile) {
        input(mobileBy, mobile);
    }

    public void inputPassword(String password) {
        input(passwordBy, password);
    }
    public void clickUserConsentBtn() {
        click(userConsentBtnBy);
    }

    public void clickLoginBtn() {
        click(loginBtnBy);
    }
    public void clicNoSaveBtn() {
        waitElementVisibility(noSaveBtnBy).click();
    }
    public void clickCloseBtn() {
        waitElementVisibility(closeBtnBy).click();
    }


    /**
     * 登录流程
     *
     * @param mobile
     * @param password
     * @param assertText
     */
    public void loginSuccess(String mobile,String password,String assertText) {
        HomePage homePage = new HomePage(androidDriver);
        MyHomePage myHomePage = new MyHomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        //调用行为
        homePage.clickMyHome();
        myHomePage.clickNickName();
        loginPage.clickPasswordLoginSwitch();
        loginPage.inputMobile(mobile);
        loginPage.inputPassword(password);
        loginPage.clickUserConsentBtn();
        loginPage.clickLoginBtn();
        loginPage.clicNoSaveBtn();
//        loginPage.clickCloseBtn();
//        loginPage.pointXY(65, 145);
        //断言
        String actual = myHomePage.getNickName();
        Assert.assertEquals(actual, assertText);
    }

    public void loginFailed(String mobile,String password,String assertText) throws InterruptedException {
        HomePage homePage = new HomePage(androidDriver);
        MyHomePage myHomePage = new MyHomePage(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);
        //调用行为
        homePage.clickMyHome();
        myHomePage.clickNickName();
        loginPage.clickPasswordLoginSwitch();
        loginPage.inputMobile(mobile);
        loginPage.inputPassword(password);
        loginPage.clickUserConsentBtn();
        loginPage.clickLoginBtn();
        loginPage.clicNoSaveBtn();
//        //断言
//        String actual = loginPage.getToastText(assertText);
//        Assert.assertEquals(actual, assertText);
        loginPage.clicNoSaveBtn();
//        loginPage.clickCloseBtn();
        loginPage.pointXY(65, 145);
    }
}