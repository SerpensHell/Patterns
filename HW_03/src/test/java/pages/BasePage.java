package pages;

import helpers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    private Logger logger = LogManager.getLogger(StartDNSPage.class);
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        WaitHelper.init(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        JavaScriptHelper.init(driver);
        ActionHelper.init(driver);
        NavigationHelper.init(driver);
        WindowHelper.init(driver);
        SwitchHelper.init(driver);
        ScreenHelper.init(driver);
    }

    public void getPageTitle() {
        logger.info("title - " + driver.getTitle());
    }

    public void getCurrentUrl() {
        logger.info("current URL - " + driver.getCurrentUrl());
    }
}
