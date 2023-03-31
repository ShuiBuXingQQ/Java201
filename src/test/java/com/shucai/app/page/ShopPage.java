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
//页面位置：商铺页

public class ShopPage extends BasePage {
    //增加，按钮
    private By addBtnBy = MobileBy.AccessibilityId("增加，按钮");
    //减少，按钮
    private By cutDownBtnBy = MobileBy.AccessibilityId("减少，按钮");
    //购物车icon
    private By cartIconBy = MobileBy.id("me.ele:id/cart_icon_view");
    //商品数量框
    private By numberBy = MobileBy.id("me.ele:id/quantity");
    //商品详情页，加入购物车 按钮
    private By shopDetailsBtnBy = MobileBy.AccessibilityId("+加入购物车");
    //店铺内的 商品列表
    private By inShopListBy = MobileBy.xpath("//android.view.ViewGroup");

    public ShopPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }


    public void clickAddBtn() {
        waitElementClickable(addBtnBy).click();
    }
    public void clickCutDownBtn() {
        waitElementClickable(cutDownBtnBy).click();
    }
    public void clickCartIcon() {
        waitElementClickable(cartIconBy).click();
    }
    public String getNumber() {
        return waitElementVisibility(numberBy).getText();
    }
    public void clickShopDetailsBtn() {
        waitElementClickable(shopDetailsBtnBy).click();
    }
    public String getShopDetailsBtn() {
        return waitElementVisibility(shopDetailsBtnBy).getText();
    }


    public void randomClickInShopList() {
        waitElementVisibility(inShopListBy);
        List<WebElement> elements = androidDriver.findElements(inShopListBy);
        //随机获取集合中一个元素，然后点击
        //打乱集合的顺序，取第一个。
        Collections.shuffle(elements);
        WebElement element = elements.get(0);
        element.click();
    }

}
