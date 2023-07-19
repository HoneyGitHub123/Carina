package com.company.carina.demo.gui.pages.common;

import com.company.carina.demo.gui.components.LoginWindow;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);

    }

    public abstract LoginWindow getLoginWindow();

    public abstract String getMessage();

    @Override
    public void open() {
        super.open();
    }

}



