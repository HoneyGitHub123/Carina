package com.company.carina.demo.mobile.gui.pages.android;


import com.company.carina.demo.mobile.gui.pages.common.AndroidWebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AndroidWebViewPageBase.class)
public class AndroidWebViewPage extends AndroidWebViewPageBase {


    @FindBy(className="android.widget.TextView")
    private ExtendedWebElement webView;

    public AndroidWebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return webView.isElementPresent();
    }
}
