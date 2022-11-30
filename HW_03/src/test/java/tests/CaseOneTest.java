package tests;

import helpers.ScreenHelper;
import helpers.WindowHelper;

import org.junit.jupiter.api.Test;
import pages.AppliancesDNSPage;
import pages.KitchenAppliancesDNSPage;
import pages.StartDNSPage;
import tests.matchers.AppliancesDNSPageMatcher;
import tests.matchers.KitchenAppliancesDNSPageMatcher;

public class CaseOneTest extends BaseTest {
    private StartDNSPage startDNSPage;
    private AppliancesDNSPage appliancesDNSPage;

    private void initPages() {
        this.startDNSPage = new StartDNSPage(driver);
        this.appliancesDNSPage = new AppliancesDNSPage(driver);
    }

    @Test
    public void startAndAppliancesTest() {
        //Arrange
        initPages();
        String pageTitle = "Бытовая техника";

        //Act
        startDNSPage.openPage();

        startDNSPage.getPageTitle();
        startDNSPage.getCurrentUrl();
        WindowHelper.windowWidth();
        WindowHelper.windowHeight();

        startDNSPage.cityConfirmGetButton().click();
        ScreenHelper.getScreen();

        startDNSPage.appliancesGetLink().click();
        ScreenHelper.getScreen();

        //Assert
        AppliancesDNSPageMatcher appliancesDNSPageMatcher = new AppliancesDNSPageMatcher(appliancesDNSPage);
        appliancesDNSPageMatcher.pageAppliancesTitleEquals(pageTitle);
    }

    @Test
    public void kitchenAppliancesTest() {
        //Arrange
        initPages();
        KitchenAppliancesDNSPage kitchenAppliancesDNSPage = new KitchenAppliancesDNSPage(driver);
        String pageTitle = "Техника для кухни";
        String buttonName = "Собрать свою кухню";
        int categoriesNumber = 5;

        //Act
        startDNSPage.openPage();

        startDNSPage.cityConfirmGetButton().click();
        ScreenHelper.getScreen();

        startDNSPage.appliancesGetLink().click();
        ScreenHelper.getScreen();

        appliancesDNSPage.kitchenAppliancesGetLink().click();
        ScreenHelper.getScreen();

        kitchenAppliancesDNSPage.allCategoriesNameOutput();

        //Assert
        KitchenAppliancesDNSPageMatcher kitchenAppliancesDNSPageMatcher = new KitchenAppliancesDNSPageMatcher(kitchenAppliancesDNSPage);
        kitchenAppliancesDNSPageMatcher.pageKitchenAppliancesTitleEquals(pageTitle);
        kitchenAppliancesDNSPageMatcher.pageKitchenAppliancesYourKitchenEquals(buttonName);
        kitchenAppliancesDNSPageMatcher.pageKitchenAppliancesCategoriesMoreThen(categoriesNumber);
    }
}
