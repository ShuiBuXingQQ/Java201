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
//页面位置：扫一扫页

public class QrcodePage extends BasePage {
    //返回首页按钮 <-
    private By toHomeBtnBy = MobileBy.AccessibilityId("返回");
    //相册按钮 1
    private By photoBtnBy = MobileBy.AccessibilityId("相册");
    //相册按钮 2
    private By photoBtn2By = MobileBy.xpath("//*[@text='相册']");
    //全部照片
    private By allPhotoBtnBy = MobileBy.xpath("//*[@text='全部照片']");
    //照片列表
    private By photoListBy = MobileBy.id ("com.miui.gallery:id/pick_num_indicator");
    //关闭按钮 X
    private By closeBtnBy = MobileBy.id ("android:id/button1");



    public QrcodePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickToHomeBtn() {
        waitElementClickable(toHomeBtnBy).click();
    }
    public void clickPhotoBtn() {
        waitElementClickable(photoBtnBy).click();
    }
    public void clickPhotoBtn2() {
        waitElementClickable(photoBtn2By).click();
    }
    public void clickAllPhotoBtn() {
        waitElementClickable(allPhotoBtnBy).click();
    }
    public void clickPhotoList() {
        waitElementClickable(photoListBy).click();
    }
    public void clickcloseBtn() {
        waitElementClickable(closeBtnBy).click();
    }


    public void randomClickPhotoList() {
        waitElementVisibility(photoListBy);
        List<WebElement> elements = androidDriver.findElements(photoListBy);
        //随机获取集合中一个元素，然后点击
        //1、随机一个索引
//        Random random = new Random();
//        int index = random.nextInt(elements.size());//0-9
//        WebElement element = elements.get(index);
        //2、打乱集合的顺序，取第一个。
        Collections.shuffle(elements);
        WebElement element = elements.get(2);
        element.click();
    }

}
