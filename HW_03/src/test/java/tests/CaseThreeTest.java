package tests;

import helpers.JavaScriptHelper;
import helpers.ScreenHelper;
import org.junit.jupiter.api.Test;
import pages.FirstLaptopDNSPage;
import pages.LaptopsDNSPage;
import pages.StartDNSPage;
import tests.matchers.FirstLaptopDNSPageMatcher;

public class CaseThreeTest extends BaseTest {

    @Test
    public void firstLaptopWithFiltersTest() {
        //Arrange
        StartDNSPage startDNSPage = new StartDNSPage(driver);
        LaptopsDNSPage laptopsDNSPage = new LaptopsDNSPage(driver);
        FirstLaptopDNSPage firstLaptopDNSPage = new FirstLaptopDNSPage(driver);
        String company = "ASUS";
        String ram = "32 ГБ";
        String sort = "Сначала дорогие";

        //Act
        startDNSPage.openPage();
        ScreenHelper.getScreen();

        startDNSPage.computersAndParaphernaliaGetLink().focusOnLink();
        ScreenHelper.getScreen();

        startDNSPage.laptopsGetLink().click();
        ScreenHelper.getScreen();

        JavaScriptHelper.displayNone();
        ScreenHelper.getScreen();

        JavaScriptHelper.scrollBy(0,600);
        laptopsDNSPage.companyChooseCheckbox(company).setChecked(true);

        JavaScriptHelper.scrollBy(0,600);
        laptopsDNSPage.ramGetAccordeon().show();
        laptopsDNSPage.ramChooseCheckbox(ram).setChecked(true);

        JavaScriptHelper.scrollBy(0,600);
        laptopsDNSPage.applyGetButton().click();
        ScreenHelper.getScreen();

        laptopsDNSPage.sortGetAccordeon().show();
        laptopsDNSPage.sortChooseRadiobutton(sort).setSelected(true);
        ScreenHelper.getScreen();

        String firstLaptopName = laptopsDNSPage.firstLaptopGetLink().getText();
        laptopsDNSPage.firstLaptopGetLink().openInNewWindow();
        ScreenHelper.getScreen();

        String firstLaptopPageTitleName = firstLaptopDNSPage.firstLaptopGetPageTitle();
        String firstLaptopPageSpecificationTitleName = firstLaptopDNSPage.firstLaptopPageGetSpecificationTitle();
        JavaScriptHelper.scrollBy(0,400);
        firstLaptopDNSPage.showAllSpecificationGetButton().click();
        JavaScriptHelper.scrollBy(0,1500);
        String firstLaptopPageRamVolume = firstLaptopDNSPage.firstLaptopPageGetRamSpecification();

        //Asserts
        FirstLaptopDNSPageMatcher firstLaptopDNSPageMatcher = new FirstLaptopDNSPageMatcher(firstLaptopDNSPage);
        firstLaptopDNSPageMatcher.firstLaptopPageTitleEquals(firstLaptopName,firstLaptopPageTitleName);
        firstLaptopDNSPageMatcher.firstLaptopPageSpecificationContainsName(firstLaptopPageSpecificationTitleName,company);
        firstLaptopDNSPageMatcher.firstLaptopPageSpecificationRamEquals(firstLaptopPageRamVolume,ram);
    }


}
