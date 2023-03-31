package com.shucai.app.common;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

//Page页面的父类  功能是 元素操作的封装（元素可见，存在，点击，等待..）

public class BasePage {

    private static Logger logger = Logger.getLogger(BasePage.class);

    public AndroidDriver androidDriver;

    public BasePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /**
     * 等待元素可见
     * @param by
     */
    public WebElement waitElementVisibility(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * 等待元素可点击
     * @param by
     */
    public WebElement waitElementClickable(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver,10);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * 等待元素存在
     * @param by
     */
    public WebElement waitElementPresence(By by) {
        logger.info("元素定位信息：" + by);
        WebDriverWait wait = new WebDriverWait(androidDriver,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * 判断元素是否可见
     * @param by            元素定位信息
     * @return
     */
    public boolean elementIsDisplayed(By by) {
        logger.info("元素定位信息：" + by);
        WebElement element = waitElementVisibility(by);
        if(element != null) {
            return element.isDisplayed();
        }
        return false;
    }

    /**
     * 点击android回退按钮
     */
    public void pressBack() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        KeyEvent keyEvent = new KeyEvent(AndroidKey.BACK);
        androidDriver.pressKey(keyEvent);
    }


    /**
     * 获取 toast文本信息
     * @param toastText
     * @return
     */
    public String getToastText(String toastText) {
        return waitElementPresence(MobileBy.xpath("//*[contains(@text,'" + toastText + "')]")).getText();
    }

    /**
     * 输入文本
     * @param by
     * @param password
     */
    public void input(By by,String password) {
        waitElementVisibility(by).sendKeys(password);
    }

    /**
     * 获取元素文本
     * @param by
     * @return
     */
    public String getText(By by) {
        return waitElementVisibility(by).getText();
    }


    /**
     * 点击元素
     * @param by
     */
    public void click(By by) {
        waitElementClickable(by).click();
    }

    /**
     * 向左滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeLeft(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width * 3 / 5,height / 2);
        PointOption endPoint = PointOption.point(width * 1 / 5,height / 2) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向下滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeDown(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 2,height * 1 / 5);
        PointOption endPoint = PointOption.point(width / 2,height * 3 / 5) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向上滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeUp(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 2,height * 3 / 5);
        PointOption endPoint = PointOption.point(width / 2,height * 1 / 5) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 向右滑动
     * @param times     滑动间隔时间，单位是毫秒
     */
    public void swipeRight(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width * 1 / 5,height / 2);
        PointOption endPoint = PointOption.point(width * 3 / 5,height / 2) ;
        //滑动决定因素：滑动距离 滑动时间
        //设置间隔时间
        Duration duration = Duration.ofMillis(times);
        //构建waitOptions对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 点击一个 固定坐标
     * @param widthX
     * @param heightY
     * @throws InterruptedException
     */
    public void pointXY(int widthX,int heightY) throws InterruptedException {
        //点击点 固定坐标
        Thread.sleep(3000);
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption onePoint = PointOption.point(widthX, heightY);

        touchAction.press(onePoint).release().perform();
    }


    /**
     * 通用findElement方法封装，加入了异常弹窗处理
     * @param by 元素定位
     * @return 元素WebElement
     */
    public WebElement myFindElement(By by){
        try {
            return androidDriver.findElement(by);
        }catch (Exception e){
            //找不到对应的元素就进入到弹窗的处理机制中来
            //弹窗黑名单列表(Map结构保存弹窗信息，其中key为元素在dom中关键信息字符串，value为元素定位表达式)
            HashMap<String,By> alertMap = new HashMap<>();
            alertMap.put("text=\"我知道了\"",MobileBy.AndroidUIAutomator("new UiSelector().text(\"我知道了\")"));
            alertMap.put("xxx",MobileBy.id("xxx"));
            alertMap.put("xxx",MobileBy.xpath("xxx"));
            Set<String> allKeys = alertMap.keySet();
            //拿到页面的dom结构信息
            String pageSource = androidDriver.getPageSource();
            for (String key:allKeys){
                if(pageSource.contains(key)){
                    //点击对应的弹窗元素
                    androidDriver.findElement(alertMap.get(key)).click();
                }
            }
            //点完弹窗之后继续再来点击对应的元素
            return androidDriver.findElement(by);
        }
    }


    /**
     * 九宫格解锁  连续滑动
     */
    public void unlock9() {
        WebElement element = androidDriver.findElement(MobileBy.id("九宫格控件定位信息"));
        //获取 x坐标  y坐标 w宽度  h高度
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        int w = element.getSize().getWidth();
        int h = element.getSize().getHeight();
        TouchAction touchAction = new TouchAction(androidDriver);
        //x+w/6,y+h/6
        PointOption point1 = PointOption.point(x + w / 6, y + h / 6);
        //x+w/2,y+h/6
        PointOption point2 = PointOption.point(x + w / 2, y + h / 6);
        //x+w*5/6,y+h/6
        PointOption point3 = PointOption.point(x + w * 5 / 6, y + h / 6);
        //x+w/2,y+h/2
        PointOption point4 = PointOption.point(x + w / 2, y + h / 2);
        //x+w/6,y+h*5/6
        PointOption point5 = PointOption.point(x + w / 6, y + h * 5 / 6);
        //x+w/2,y+h*5/6
        PointOption point6 = PointOption.point(x + w / 2, y + h * 5 / 6);
        //x+w*5/6,y+h*5/6
        PointOption point7 = PointOption.point(x + w * 5 / 6, y + h * 5 / 6);
        touchAction.press(point1).moveTo(point2).moveTo(point3)
                .moveTo(point4).moveTo(point5).moveTo(point6).moveTo(point7).release().perform();
    }









}
