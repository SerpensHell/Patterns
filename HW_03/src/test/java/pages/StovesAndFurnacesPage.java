package pages;

import drivers.Selenium4Listener;
import elements.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class StovesAndFurnacesPage extends BasePage{
    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

    @FindBy(xpath = "//span[text() = 'Плиты электрические']")
    @CacheLookup
    WebElement electricStovesLink;

    public StovesAndFurnacesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(eventFiringWebDriver, this);
    }

    public Link electricStovesGetLink() {
        return new Link(electricStovesLink);
    }
}
