package com.shucai.web.cases;

import com.shucai.web.common.BaseCase;
import com.shucai.web.common.Constants;
import com.shucai.web.pages.EmailHomePage;
import com.shucai.web.pages.LetterPage;
import com.shucai.web.pages.LoginPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigDecimal;
import java.util.Set;

/*
 * @Desc： 写信用例
 */

public class LetterCase extends BaseCase {

    @BeforeTest
    public void setupClass() throws InterruptedException {
        //打开浏览器、访问登录页面、网页最大化
        driver = open(Constants.BROWSER_TYPE);
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccess("自己账号","自己密码");
        Thread.sleep(20000);
    }

    //输入收件人、主题、正文内容
    @Test
    public void test01() throws InterruptedException {
        EmailHomePage emailHomePage = new EmailHomePage(driver);
        LetterPage letterPage = new LetterPage(driver);
        driver.switchTo().defaultContent();
        emailHomePage.clickLetterBtn();
        driver.switchTo().frame("mainFrame");
        letterPage.clickAddresseeBox();
        letterPage.inputAddresseeBox("邱");
        letterPage.clickSubjectBox();
        letterPage.inputSubjectBox("输入主题");
        WebElement webElement = driver.findElement(By.xpath("//div[1]/table[1]/tbody[1]/tr[2]/td[1]/iframe[1]"));
        driver.switchTo().frame(webElement);
        letterPage.clickMainBodyBox();
        letterPage.inputMainBodyBox("输入正文");
        String getMainBodyBox = letterPage.getMainBodyBox();
        Assert.assertEquals(getMainBodyBox,"输入正文");
        driver.switchTo().defaultContent();


    }

    //添加附件
    @Test
    public void test02() throws Exception {
        EmailHomePage emailHomePage = new EmailHomePage(driver);
        LetterPage letterPage = new LetterPage(driver);
        emailHomePage.clickLetterBtn();
        driver.switchTo().frame("mainFrame");
        letterPage.inputUpload("D:\\logcat.log");
//        letterPage.inputUpload3("D:\\tupian.exe");
        driver.switchTo().defaultContent();

    }

    //添加日程，保存
    @Test
    public void test03() {
        EmailHomePage emailHomePage = new EmailHomePage(driver);
        LetterPage letterPage = new LetterPage(driver);
        emailHomePage.clickLetterBtn();
        driver.switchTo().frame("mainFrame");
        letterPage.clickSchedule();
        letterPage.inputscheduleTheme("添加日程弹窗（主题）");
        letterPage.clickscheduleSave();
        driver.switchTo().defaultContent();
    }



    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        close(driver);
//        driver.close();

    }

}
