package com.company.carina.demo.gui.components.header;

import com.company.carina.demo.gui.components.LoginWindow;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends HeaderMenuBase {


    @FindBy(id = "login-popup2")
    private LoginWindow loginBlock;
    @FindBy(xpath = ".//a[@class='login-icon']")
    private ExtendedWebElement loginLink;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public LoginWindow clickLoginlink() {
        loginLink.click();
        return loginBlock;
    }
}


