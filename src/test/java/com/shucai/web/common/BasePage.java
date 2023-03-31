package com.shucai.web.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Desc： 页面父类
 **/
public class BasePage {

    private Logger log = Logger.getLogger(BasePage.class);

    //因为BasePage需要driver，又没有人创建BasePage，由BasePage子类通过构造方法传递给父类。
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 封装显式等待：元素可见
     * @param by  元素定位信息
     * @return    元素对象
     */
    public WebElement waitElementVisibility(By by) {
        log.info(by);
        WebElement element = null;
        try {
            //10秒元素可见显式等待
            WebDriverWait wait = new WebDriverWait(driver, 10);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e) {
            log.error("元素定位异常：" + e.getMessage());
        }
        return element;
    }

    /**
     * 封装显式等待：元素可点击
     * @param by  元素定位信息
     * @return    元素对象
     */
    public WebElement waitElementClickable(By by) {
        log.info(by);
        WebElement element = null;
        try {
            //5秒元素可见显式等待
            WebDriverWait wait = new WebDriverWait(driver, 10);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e) {
            log.error("元素定位异常：" + e.getMessage());
        }
        return element;
    }

    /**
     * 输入文本框
     * @param by            元素定位信息
     * @param content       文本内容
     */
    public void input(By by, String content) {
        WebElement element = waitElementVisibility(by);
        if(element != null) {
            //每次输入前先清空
            element.clear();
            element.sendKeys(content);
        }
    }

    /**
     * 元素点击
     * @param by            元素定位信息
     */
    public void click(By by) {
        WebElement element = waitElementClickable(by);
        if(element != null) {
            element.click();
        }
    }

    /**
     * 获取元素的文本
     * @param by            元素定位信息
     * @return
     */
    public String getElementText(By by) {
        WebElement element = waitElementVisibility(by);
        if(element != null) {
            return element.getText();
        }
        return "";
    }

    /**
     * 获取元素的属性值
     * @param by            元素定位信息
     * @param attributeName 属性名称
     * @return
     */
    public String getElementAttribute(By by, String attributeName) {
        WebElement element = waitElementVisibility(by);
        String value = "";
        if(element != null) {
            value = element.getAttribute(attributeName);
        }
        return value;
    }

    /**
     * 判断元素是否可见
     * @param by            元素定位信息
     * @return
     */
    public boolean elementIsDisplayed(By by) {
        WebElement element = waitElementVisibility(by);
        if(element != null) {
            return element.isDisplayed();
        }
        return false;
    }

    /**
     * 输入键盘key
     * @param by
     * @param key
     */
    public void inputKey(By by, Keys key) {
        WebElement element = waitElementVisibility(by);
        if(element != null) {
            //每次输入前先清空
            element.sendKeys(key);
        }
    }
}
