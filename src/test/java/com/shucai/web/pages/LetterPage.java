package com.shucai.web.pages;

import com.shucai.web.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * @Desc： 写信页
 **/
public class LetterPage extends BasePage {

    //收件人输入框
    private By addresseeBoxBy = By.xpath("//*[@id='toAreaCtrl']/div[2]/input");
    //主题输入框
    private By subjectBoxBy = By.xpath("//*[@id=\"subject\"][@title=\"主题是一封邮件的标题，可不填。\"]");
    //正文输入框
    private By mainBodyBoxBy = By.xpath("//*[@aria-label='正文']/div[1]");
    //添加附件（上传）
    private By uploadBy = By.xpath("//span[@id='sAddAtt1']");
    //添加日程
    private By scheduleBy = By.xpath("//a[contains(text(),'日程')]");
    //添加日程弹窗（主题）
    private By scheduleThemeBy = By.xpath("//*[@placeholder='输入日程主题']");

    //添加日程弹窗（开始日历）
    private By scheduleTimeBy = By.xpath("//*[text()='开始']/following::*/div");

    //添加日程弹窗（保存）
    private By scheduleSaveBy = By.xpath("//*[text()='保存']");

    public LetterPage(WebDriver driver) {
        super(driver);
    }

    //点击收件人输入框
    public void clickAddresseeBox() {
        click(addresseeBoxBy);
    }

    //收件人输入框
    public void inputAddresseeBox(String string) {
        input(addresseeBoxBy, string);
        inputKey(addresseeBoxBy, Keys.ENTER);
    }

    //点击主题输入框
    public void clickSubjectBox() {
        click(subjectBoxBy);
    }

    //主题输入框
    public void inputSubjectBox(String string) {
        input(subjectBoxBy, string);
    }

    //点击正文输入框
    public void clickMainBodyBox() {
        click(mainBodyBoxBy);
    }

    //正文输入框
    public void inputMainBodyBox(String string) {
        input(mainBodyBoxBy, string);
    }

    //获取正文输入内容
    public String getMainBodyBox() {
        return getElementText(mainBodyBoxBy);
    }

    //添加附件（上传）
    public void inputUpload(String string) {
        input(uploadBy, string);
    }

    //添加附件（第三方工具 AutoIT上传）
    public void inputUpload3(String string) throws InterruptedException, IOException {
        waitElementVisibility(uploadBy).click();
        Runtime runtime = Runtime.getRuntime();
        //执行auto2.exe  -> 定位窗口输入内容，点击打开。
        runtime.exec(string);
        Thread.sleep(500);
    }


    //添加日程
    public void clickSchedule() {
        click(scheduleBy);
    }
    //添加日程弹窗（主题）
    public void inputscheduleTheme(String string) {
        input(scheduleThemeBy, string);
    }
    //添加日程弹窗（保存）
    public void clickscheduleSave() {
        click(scheduleSaveBy);
    }


}
