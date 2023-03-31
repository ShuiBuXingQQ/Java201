package com.shucai.app.cases;

import com.shucai.app.common.BaseCase;
import com.shucai.app.page.*;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * 搜索店铺，添加商品
 **/

public class ShopCase extends BaseCase {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        openApp();
//        //1、登录（只需做一次）
//        LoginPage loginPage = new LoginPage(androidDriver);
//        loginPage.loginSuccess("正确手机号", "正确密码", "书材0v0");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //搜索不同的商店
    @Test
    public void testShopCase01() {
        //创建出页面
        HomePage homePage = new HomePage(androidDriver);
        SearchPage searchPage = new SearchPage(androidDriver);
        ShopPage shopPage = new ShopPage(androidDriver);
        //调用行为
        homePage.clickSearchBox();
        searchPage.inputSearchBox2("汉堡王");
        //断言
        String box2 = searchPage.getSearchBox2();
        Assert.assertEquals(box2, "汉堡王");
        //清空搜索框搜索其他店铺
        searchPage.clickSearchClearBtn();
        searchPage.inputSearchBox2("KFC");
        //断言
        String kfc = searchPage.getSearchBox2();
        Assert.assertEquals(kfc, "KFC");
        //一路上一步回到，首页
        searchPage.clickToHomeBtn();
        searchPage.clickToHomeBtn();
    }

    //搜索进入的商店，添加商品
    @Test
    public void testShopCase02() throws InterruptedException {
        //创建出页面
        HomePage homePage = new HomePage(androidDriver);
        SearchPage searchPage = new SearchPage(androidDriver);
        ShopPage shopPage = new ShopPage(androidDriver);
        //调用行为
        homePage.clickSearchBox();
        searchPage.inputSearchBox2("汉堡王");
        searchPage.clickSearchBtn();
        //选择列表里第一个汉堡王 进店
        searchPage.randomClickShopList();
        Thread.sleep(2000);
        shopPage.swipeUp(300);
        shopPage.swipeUp(300);
        //加减商品数量
        shopPage.clickAddBtn();
        Thread.sleep(2000);
        //点击购物车
        shopPage.clickCartIcon();
        //断言商品 数量为 1
        String number = shopPage.getNumber();
        Assert.assertEquals(number,"1");

    }


    //    @AfterTest
    public void tearDown() {
        quit();
    }

}
