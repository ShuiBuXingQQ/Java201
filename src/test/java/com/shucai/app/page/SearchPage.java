package com.shucai.app.page;

import com.shucai.app.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;


//属性 定位信息
//方法 行为，点击，发送，获取文档....
//页面位置：搜索页

public class SearchPage extends BasePage {
    //搜索框
    private By searchBox2By = MobileBy.id("me.ele:id/editor");
    //搜索结果 清空按钮
    private By searchClearBy = MobileBy.id("me.ele:id/clear_iv");
    //左上角 返回按钮
    private By searchToHomeBtnBy = MobileBy.id("me.ele:id/back");
    //右上角 搜索按钮
    private By searchBtnBy = MobileBy.xpath("//*[@text='搜索']");
    //商铺列表
    private By shopListBy = MobileBy.xpath("//android.view.ViewGroup");

    public SearchPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void inputSearchBox2(String shopName) {
        waitElementClickable(searchBox2By).sendKeys(shopName);
    }
    public String getSearchBox2() {
        return waitElementVisibility(searchBox2By).getText();
    }

    public void clickSearchClearBtn() {
        waitElementClickable(searchClearBy).click();
    }
    public void clickToHomeBtn() {
        waitElementClickable(searchToHomeBtnBy).click();
    }
    public void clickSearchBtn() {
        waitElementClickable(searchBtnBy).click();
    }


    public void randomClickShopList() {
        waitElementVisibility(shopListBy);
        List<WebElement> elements = androidDriver.findElements(shopListBy);
        //打乱集合的顺序，取第一个。
        Collections.shuffle(elements);
        WebElement element = elements.get(0);
        element.click();
    }


}