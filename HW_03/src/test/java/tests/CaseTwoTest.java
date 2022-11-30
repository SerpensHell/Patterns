package tests;

import helpers.ScreenHelper;
import org.junit.jupiter.api.Test;
import pages.ElectricStovesDnsPage;
import pages.StartDNSPage;
import pages.StovesAndFurnacesPage;
import tests.matchers.ElectricStovesDNSPageMatcher;
import tests.matchers.StartDNSPageMatcher;

public class CaseTwoTest extends BaseTest {

    @Test
    public void startPageAppliancesSubMenuLinksTest() {
        //Arrange
        StartDNSPage startDNSPage = new StartDNSPage(driver);

        //Act
        startDNSPage.openPage();

        startDNSPage.cityConfirmGetButton().click();
        ScreenHelper.getScreen();

        startDNSPage.appliancesGetLink().focusOnLink();
        ScreenHelper.getScreen();

        //Assert
        StartDNSPageMatcher startDNSPageMatcher = new StartDNSPageMatcher(startDNSPage);
        startDNSPageMatcher.pageStartSubMenuLinksEquals();
    }

    @Test
    public void startPagePreparationDrinksLinksTest() {
        //Arrange
        StartDNSPage startDNSPage = new StartDNSPage(driver);
        int linksNumber = 5;

        //Act
        startDNSPage.openPage();

        startDNSPage.cityConfirmGetButton().click();
        ScreenHelper.getScreen();

        startDNSPage.appliancesGetLink().focusOnLink();
        ScreenHelper.getScreen();

        startDNSPage.preparationDrinksGetLink().focusOnLink();
        ScreenHelper.getScreen();

        //Assert
        StartDNSPageMatcher startDNSPageMatcher = new StartDNSPageMatcher(startDNSPage);
        startDNSPageMatcher.pageStartPreparationDrinksMoreThen(linksNumber);
    }

    @Test
    public void electricPlateTest() {
        //Arrange
        StartDNSPage startDNSPage = new StartDNSPage(driver);
        StovesAndFurnacesPage stovesAndFurnacesPage = new StovesAndFurnacesPage(driver);
        ElectricStovesDnsPage electricStovesDnsPage = new ElectricStovesDnsPage(driver);
        int electricStovesNumber = 100;

        //Act
        startDNSPage.openPage();

        startDNSPage.cityConfirmGetButton().click();
        ScreenHelper.getScreen();

        startDNSPage.appliancesGetLink().focusOnLink();
        ScreenHelper.getScreen();

        startDNSPage.stovesAndFurnacesGetLink().click();
        ScreenHelper.getScreen();

        stovesAndFurnacesPage.electricStovesGetLink().click();
        ScreenHelper.getScreen();

        //Assert
        ElectricStovesDNSPageMatcher electricStovesDNSPageMatcher = new ElectricStovesDNSPageMatcher(electricStovesDnsPage);
        electricStovesDNSPageMatcher.electricStovesCountMoreThen(electricStovesNumber);
    }
}




