package mytest;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.Map;

import static com.codeborne.selenide.Configuration.browserVersion;

;

public class BaseTest {

    protected final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger("Log2RP");
    protected final org.slf4j.Logger log2F = org.slf4j.LoggerFactory.getLogger("Log2File");
    boolean isRunningOnSelenoid = false;

    protected void browserSetup() throws MalformedURLException {
        System.setProperty("testng.dtd.http", "true");
        Configuration.browser = "chrome";
        browserVersion = "97.0";
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.reportsFolder = "log";
        Configuration.webdriverLogsEnabled = false;
        if (isRunningOnSelenoid) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            Configuration.browserPosition = "0x0";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", browserVersion);
            capabilities.setCapability("acceptInsecureCerts", true);
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "screenResolution", "1920x1080x24",
                    "sessionTimeout", "5m"
            ));
        }
    }
}
