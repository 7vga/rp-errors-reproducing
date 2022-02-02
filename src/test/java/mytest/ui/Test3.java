package mytest.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import mytest.BaseTest;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.GooglePage;
import pageobjects.MailRuPage;
import pageobjects.YandexPage;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;

public class Test3 extends BaseTest {

    @BeforeMethod
    public void browserInit() throws MalformedURLException {
        super.browserSetup();
    }

    @AfterMethod
    public void browserStop() throws MalformedURLException {
        var drv = WebDriverRunner.driver();
        if (drv != null) drv.close();
    }

    @Test
    public void test6() {
        open("https://yandex.by", YandexPage.class);
        log.info("This test should pass");
        log2F.debug("This test should pass");
        Selenide.screenshot("test6");
    }

    @Test
    public void test7() {
        open("https://google.by", GooglePage.class);
        log.info("This test should be skipped");
        log2F.debug("This test should be skipped");
        Selenide.screenshot("test7");
        throw new SkipException("This test should be skipped");
    }

    @Test
    public void test8() {
        open("https://mail.ru", MailRuPage.class);
        log.info("This test should fail");
        log2F.debug("This test should fail");
        Selenide.screenshot("test8");
        Assert.fail("This test should fail");
    }

}
