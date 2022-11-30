package pages;

import drivers.Selenium4Listener;
import elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class FirstLaptopDNSPage extends BasePage {
    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

    @FindBy(xpath = "//h1[@class = 'product-card-top__title']")
    @CacheLookup
    WebElement firstLaptopPageTitle;
    @FindBy(xpath = "//div[@class = 'product-card-description__title']")
    @CacheLookup
    WebElement firstLaptopPageSpecificationTitle;
    @FindBy(xpath = "//button[text() = 'Развернуть все']")
    @CacheLookup
    WebElement showAllSpecificationButton;
    @FindBy(xpath = "//div[text() = ' Объем оперативной памяти ']/following-sibling::div")
    @CacheLookup
    WebElement firstLaptopPageRamSpecification;

    public FirstLaptopDNSPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(eventFiringWebDriver, this);
    }

    public String firstLaptopGetPageTitle() {
        return firstLaptopPageTitle.getText();
    }

    public String firstLaptopPageGetSpecificationTitle() {
        return firstLaptopPageSpecificationTitle.getText();
    }

    public Button showAllSpecificationGetButton() {
        return new Button(showAllSpecificationButton);
    }

    public String firstLaptopPageGetRamSpecification() {
        return firstLaptopPageRamSpecification.getText();
    }
}
