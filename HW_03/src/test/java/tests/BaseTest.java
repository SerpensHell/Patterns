package tests;

import drivers.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(BaseTest.class);

    String env = System.getProperty("browser", "chrome");
    String pageLoadStrategy = System.getProperty("loadstrategy", "normal");

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver(env.toLowerCase(), pageLoadStrategy.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
