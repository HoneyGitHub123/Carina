package com.company.carina.demo.gui.pages.desktop;

import com.company.carina.demo.gui.components.header.HeaderMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage1 extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//div[@class=\"top-bar clearfix\"]")
    private HeaderMenu headerMenu;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    public HomePage1(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(newsColumn);

    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }


    public void open() {
        super.open();
    }

}







