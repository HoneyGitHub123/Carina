package com.company.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AndroidWelcomePageBase extends AbstractPage {
    public AndroidWelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoPresent();

    public abstract boolean isNextbtnPresent();

    public abstract AndroidLoginPageBase clickNextbtn();


}
