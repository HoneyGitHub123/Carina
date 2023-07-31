package com.company.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AndroidLoginPageBase extends AbstractPage {

    public AndroidLoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isNameFieldPresent();

    public abstract void enterName(String name);

    public abstract String isNameFieldValuePresent();

    public abstract boolean isPasswordFieldPresent();

    public abstract void enterPassword(String password);

    public abstract String isPasswordFieldValuePresent();

    public abstract boolean isMaleRadioBtnPresent();

    public abstract boolean isMaleRadioBtnChecked();

    public abstract boolean isFemaleRadioBtnPresent();

    public abstract boolean isFemaleRadioBtnChecked();

    public abstract boolean selectMaleBtn();

    public abstract boolean isPrivacyBoxPresent();

    public abstract boolean isPrivacyBoxChecked();

    public abstract void activatePrivacy();

    public abstract AndroidWebViewPageBase signUpBtn();


}

