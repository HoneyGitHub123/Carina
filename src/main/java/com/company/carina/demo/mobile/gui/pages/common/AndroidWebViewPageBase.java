package com.company.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AndroidWebViewPageBase extends AbstractPage implements IMobileUtils {
    public AndroidWebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean  isPageOpened();
}
