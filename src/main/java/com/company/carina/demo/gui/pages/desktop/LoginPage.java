package com.company.carina.demo.gui.pages.desktop;

import com.company.carina.demo.gui.components.LoginWindow;
import com.company.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//div[contains(@class,'normal-text res')]")
    private ExtendedWebElement message;


    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.gsmarena.com/login.php3");


    }

    @Override
    public String getMessage() {
        return message.getText();
    }


}



