package com.shucai.web.pages;

import com.shucai.web.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Desc： 邮箱首页
 **/
public class EmailHomePage extends BasePage {

    //用户昵称
    private By nickNameBy = By.xpath("//b[@id='useralias']");
    //写信按钮
    private By letterBtnBy = By.linkText("写信");

    public EmailHomePage(WebDriver driver) {
        super(driver);
    }


    //获取登录昵称
    public String getnickName() {
        return getElementText(nickNameBy);
    }

    //点击写信按钮
    public void clickLetterBtn() {
        click(letterBtnBy);
    }




}
