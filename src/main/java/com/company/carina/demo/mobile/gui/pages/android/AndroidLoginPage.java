package com.company.carina.demo.mobile.gui.pages.android;

import com.company.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AndroidLoginPageBase.class)
public class AndroidLoginPage extends AndroidLoginPageBase {

    @FindBy(id = "name")
    private ExtendedWebElement nameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "radio_male")
    private ExtendedWebElement maleRadioBtn;

    @FindBy(id = "radio_female")
    private ExtendedWebElement femaleRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isNameFieldPresent() {
        return nameInput.isElementPresent();
    }

    @Override
    public void enterName(String name) {
        nameInput.type(name);
    }

    @Override
    public String isNameFieldValuePresent() {
        return nameInput.getText();
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordInput.isElementPresent();
    }

    @Override
    public void enterPassword(String password) {
        passwordInput.type(password);
    }

    @Override
    public String isPasswordFieldValuePresent() {
        return passwordInput.getText();
    }

    @Override
    public boolean isMaleRadioBtnPresent() {
        return maleRadioBtn.isElementPresent();
    }

    @Override
    public boolean isMaleRadioBtnChecked() {
        return maleRadioBtn.isChecked();
    }

    @Override
    public boolean isFemaleRadioBtnPresent() {
        return femaleRadioBtn.isElementPresent();
    }

    @Override
    public boolean isFemaleRadioBtnChecked() {
        return femaleRadioBtn.isChecked();
    }

    @Override
    public boolean selectMaleBtn() {
        maleRadioBtn.click();
        return maleRadioBtn.isChecked();
    }

    @Override
    public boolean isPrivacyBoxPresent() {
        return privacyPolicyCheckbox.isElementPresent();
    }

    @Override
    public boolean isPrivacyBoxChecked() {
        return privacyPolicyCheckbox.isChecked();
    }

    @Override
    public void activatePrivacy() {
        privacyPolicyCheckbox.click();
    }

    @Override
    public AndroidWebViewPageBase signUpBtn() {
        loginBtn.click();
        return initPage(getDriver(), AndroidWebViewPageBase.class);
    }
}
