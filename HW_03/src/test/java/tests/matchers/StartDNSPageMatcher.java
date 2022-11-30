package tests.matchers;

import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.StartDNSPage;

import java.util.Arrays;
import java.util.List;

public class StartDNSPageMatcher {
    StartDNSPage page;
    private Logger logger = LogManager.getLogger(StartDNSPageMatcher.class);

    public StartDNSPageMatcher(StartDNSPage page) {
        this.page = page;
    }

    public void pageStartSubMenuLinksEquals() {
        List<Link> subMenuLinks = page.appliancesSubMenuGetAllLinks();
        List<String> linksTextTest = Arrays.asList("Встраиваемая техника","Техника для кухни", "Техника для дома");
        for (Link link : subMenuLinks) {
            String linkName = link.getText();
            logger.info("Отображаемая ссылка: " + linkName);
            Assertions.assertTrue(linksTextTest.contains(linkName), "Название ссылки не соответствует ожидаемому");
        }
    }

    public void pageStartPreparationDrinksMoreThen(int count) {
        int preparationDrinksCountSubMenuLinks = page.countSubMenuPreparationDrinksLinks();
        logger.info((String.format("Количество ссылок: %d", preparationDrinksCountSubMenuLinks)));
        Assertions.assertTrue(preparationDrinksCountSubMenuLinks > count, "Количество ссылок в подменю меньше необходимого");
    }
}
