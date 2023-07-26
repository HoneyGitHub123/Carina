package com.company.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AndroidLoginPageBase extends AbstractPage {
    public AndroidLoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkName();

    public abstract void enterName(String name);

    public abstract boolean checkPassword();

    public abstract void enterPassword(String password);

    public abstract boolean checkMaleRadiobtnPresent();

    public abstract boolean isMaleRadiobtnChecked();

    public abstract boolean checkFemaleRadiobtnPresent();

    public abstract boolean isFemaleRadiobtnChecked();

    public abstract boolean selectMalebtn();

    public abstract boolean checkPrivacyBoxPresent();
    public abstract boolean isPrivacyBoxChecked();

    public abstract void activatePrivacy();


    public abstract AndroidWebViewPageBase signUpbtn();


}

