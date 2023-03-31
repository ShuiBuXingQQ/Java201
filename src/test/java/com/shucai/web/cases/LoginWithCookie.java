package com.shucai.web.cases;

import com.shucai.web.common.Constants;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.shucai.web.common.BaseCase.close;
import static com.shucai.web.common.BaseCase.open;

/**
 * @author longrong.lang
 * 绕过验证码登陆
 */
public class LoginWithCookie {
 
    WebDriver driver;
 
    @BeforeTest
    public void setUp() {
        //打开浏览器、访问登录页面、网页最大化
        driver = open(Constants.BROWSER_TYPE);
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
 
    @Test
    public void testLoginWithCookie() {

        //添加cookie操作
        Cookie cookie1 = new Cookie("ptui_loginuin", "695852553@qq.com");
        Cookie cookie2 = new Cookie("xm_envid", "456_t15mLcxoPX2r9UnaqDVXrBv55kElJ3iMi5IDToQ8lwe4KTPJMPrQSfoTXvFZsjxknSF2ivSuY/7aaGjxW+gWooF94kpIpkfzXS26do4MYjCb6uwuauJqiliry96dMK0KgzUfOP8egeA6fXOq+sS+p2C40Nh/sQC7O4c=");
        Cookie cookie3 = new Cookie("ptcz", "c9e8c03340c57eb31efcb73b7992b81d0088d7fab78df42f161b3552352bc6d8");
        Cookie cookie4 = new Cookie("skey", "@XDOFcjnGl");
        Cookie cookie5 = new Cookie("xm_uin", "13102661720727049");
        Cookie cookie6 = new Cookie("uin", "o695852553");
        Cookie cookie7 = new Cookie("p_uin", "o0695852553");
        Cookie cookie8 = new Cookie("qm_username", "695852553");
        Cookie cookie9 = new Cookie("username", "695852553&695852553");
        Cookie cookie10 = new Cookie("qm_device_id", "cl80lwjGjl46dlMGYE6mP9wqrACf555WXJbgoKfFCkjq0Q3ctrynQjq");
        Cookie cookie11 = new Cookie("xm_sid", "zQk4dYzeNDMueUlxACl0SwAA");
        Cookie cookie12 = new Cookie("xm_pcache", "13102661720727049&V2@i19k0mGMSSmF2MfmXy6kDwAA@0");
        Cookie cookie13 = new Cookie("RK", "WTUcNhcpVD");
        Cookie cookie14 = new Cookie("ssl_edition", "sail.qq.com");
        Cookie cookie15 = new Cookie("new_mail_num", "695852553&6");
        Cookie cookie16 = new Cookie("xm_muti_sid", "13102661720727049&zQk4dYzeNDMueUlxACl0SwAA");
        Cookie cookie17 = new Cookie("qm_domain", "https://mail.qq.com");
        Cookie cookie18 = new Cookie("edition", "mail.qq.com");
        Cookie cookie19 = new Cookie("qm_logintype", "qq");
        Cookie cookie20 = new Cookie("xm_skey", "13102661720727049&959200ed5bc30b8351e25fe9f0736d5a");
        Cookie cookie21 = new Cookie("pt4_token", "Xz4vAZsQQGZQaHcecPYd1I*UtcZykndZRGHGrdKnZas_");
        Cookie cookie22 = new Cookie("sid", "695852553&08e31c1a8a0f1ba9984d729b16f06ac9,qLUdNMVVFRi1zVGFQRHJpOE5jZWotRlhpaXp2eXRNV21SWHlMQm0tT2Vwa18.");
        Cookie cookie23 = new Cookie("qm_muti_sid", "13102661720727049&uLHB9Coj9o_sc1o_");
        Cookie cookie24 = new Cookie("xm_ws", "13102661720727049&d5db329b0270d37f8be5f3394587b972");
        Cookie cookie25 = new Cookie("xm_data_ticket", "13102661720727049&CAESIGQjDPIALozNKXneCVDJXMleKKcPQO9KPSuBoEqyklVE");
        Cookie cookie26 = new Cookie("CCSHOW", "000000");
        Cookie cookie27 = new Cookie("webp", "1");

        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        driver.manage().addCookie(cookie5);
        driver.manage().addCookie(cookie6);
        driver.manage().addCookie(cookie7);
        driver.manage().addCookie(cookie8);
        driver.manage().addCookie(cookie9);
        driver.manage().addCookie(cookie10);
        driver.manage().addCookie(cookie11);
        driver.manage().addCookie(cookie12);
        driver.manage().addCookie(cookie13);
        driver.manage().addCookie(cookie14);
        driver.manage().addCookie(cookie15);
        driver.manage().addCookie(cookie16);
        driver.manage().addCookie(cookie17);
        driver.manage().addCookie(cookie18);
        driver.manage().addCookie(cookie19);
        driver.manage().addCookie(cookie20);
        driver.manage().addCookie(cookie21);
        driver.manage().addCookie(cookie22);
        driver.manage().addCookie(cookie23);
        driver.manage().addCookie(cookie24);
        driver.manage().addCookie(cookie25);
        driver.manage().addCookie(cookie26);
        driver.manage().addCookie(cookie27);
        driver.manage().window().maximize();
        //cookie遍历使用
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "\t" + cookie.getValue());
        }
        //下面是见证奇迹的时候了
        driver.navigate().refresh();
        driver.get(Constants.LOGIN_URL);

    }
 
    @AfterTest
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        close(driver);
    }
 
}