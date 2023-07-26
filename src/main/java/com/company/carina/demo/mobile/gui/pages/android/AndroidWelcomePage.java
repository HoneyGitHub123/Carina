package com.company.carina.demo.mobile.gui.pages.android;

import com.company.carina.demo.mobile.gui.pages.common.AndroidLoginPageBase;
import com.company.carina.demo.mobile.gui.pages.common.AndroidWelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AndroidWelcomePageBase.class)
public class AndroidWelcomePage extends AndroidWelcomePageBase {

    @FindBy(id = "carina_logo")
    private ExtendedWebElement logo;


    @FindBy(id = "next_button")
    private ExtendedWebElement nextBtn;

    public AndroidWelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    @Override
    public boolean isNextbtnPresent() {
        return nextBtn.isElementPresent();
    }

    @Override
    public AndroidLoginPageBase clickNextbtn() {
        nextBtn.click();
        return initPage(getDriver(), AndroidLoginPageBase.class);
    }

}
