package com.shucai.web.pages;

import com.shucai.web.common.BasePage;
import com.shucai.web.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

/**
 * @Desc： 登录页面
 **/
public class LoginPage extends BasePage {
    //对象的属性（全局变量） == web页面的元素（定位方式、定位值）
    //默认展示 账号密码登录TAB
    private By qqLoginTabBy = By.xpath("//div[@id='qqLoginTab']");
    //切换展示 微信扫码TAB
    private By wxLoginTabBy = By.xpath("//div[@id='wxLoginTab']");
    //微信扫码TAB  提示文案：使用微信扫一扫登录
    private By wxLoginTabTextBy = By.xpath("//*[@id=\"wx_default_tip\"]/p[1]");
    //qq号元素定位信息
    private By qqBy = By.xpath("//input[@id=\"u\"]");
    //password元素定位信息
    private By passwordBy = By.xpath("//input[@id=\"p\"]");
    //登录按钮元素定位信息
    private By loginBtnBy = By.xpath("//input[@value=\"登录\"][@class=\"btn\"]");
    //登录错误提示
    private By centerErrorBy = By.xpath("//*[@id=\"err_m\"]");

    //webDriver对象,通过业务传给页面
    public LoginPage(WebDriver driver) {
        //调用父类的构造
        super(driver);
    }

    //对象的行为（方法）== web页面元素的操作

    //账号密码登录TAB
    public void clickqqLoginTab() {
        click(qqLoginTabBy);
    }

    //切换展示 微信扫码TAB
    public void clickwxLoginTab() {
        click(wxLoginTabBy);
    }

    //微信扫码TAB  提示文案：使用微信扫一扫登录
    public String getwxLoginTabText() {
        return getElementText(wxLoginTabTextBy);
    }

    //对手机框进行输入
    public void inputQq(String phone) {
        input(qqBy, phone);
    }

    //对密码框进行输入
    public void inputPassword(String password) {
        input(passwordBy, password);
    }

    //点击登录按钮
    public void clickLoginBtn() {
        click(loginBtnBy);
    }

    //获取页面登录错误提示
    public String getCenterErrorText() {
        return getElementText(centerErrorBy);
    }


    public void loginSuccess(String qq,String password) {
        //登录成功
        LoginPage loginPage = new LoginPage(driver);
        driver.switchTo().frame("login_frame");
        loginPage.inputQq(qq);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();
    }




/*
    //可以获得该元素的颜色值 （了解即可）
    String cssValue = driver.findElement(By.xpath("//div[@id='qqLoginTab']")).getCssValue("color");
        System.out.println(cssValue);
    Color color = Color.fromString(cssValue);
        System.out.println(color.asHex());
*/

}
