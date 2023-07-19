package com.company.carina.demo.gui.components;

import com.company.carina.demo.gui.pages.common.LoginPageBase;
import com.company.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.company.carina.demo.gui.pages.desktop.LoginPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginWindow extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(id = "email")
    private ExtendedWebElement email;
    @FindBy(id = "upass")
    private ExtendedWebElement password;
    @FindBy(css = "input#nick-submit.button")
    private ExtendedWebElement loginButton;


    public LoginWindow(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public void enterEmail(String userEmail) {
        email.type(userEmail);
    }

    public void enterPassword(String userPassword) {
        password.type(userPassword);

    }

    public LoginPageBase clickLoginButton() {
        loginButton.click();
        return initPage(driver, LoginPageBase.class);
    }


}


