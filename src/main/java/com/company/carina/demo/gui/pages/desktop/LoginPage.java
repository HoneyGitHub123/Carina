package com.company.carina.demo.gui.pages.desktop;

import com.company.carina.demo.gui.components.LoginWindow;
import com.company.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "login-popup2")
    private LoginWindow loginBlock;
    @FindBy(xpath = "//a[@class='login-icon']")
    private ExtendedWebElement loginLink;
    @FindBy(xpath = "//div[contains(@class,'normal-text res')]")
    private ExtendedWebElement message;


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void clickLoginLink() {
        loginLink.click();
    }

    @Override
    public LoginWindow getLoginWindow() {
        return loginBlock;

    }

    public String getMessage() {
        return message.getText();
    }


}



