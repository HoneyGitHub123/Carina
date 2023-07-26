package com.company.carina.demo;

import com.company.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidMobTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "mobdemo")
    public void testLoginUser() {
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        AndroidWelcomePageBase welcomePage = initPage(getDriver(), AndroidWelcomePageBase.class);
        Assert.assertTrue(welcomePage.isLogoPresent(), "WelcomePage is not opened");
        Assert.assertTrue(welcomePage.isNextbtnPresent(), "Next button is not available");
        AndroidLoginPageBase loginPage = welcomePage.clickNextbtn();
        Assert.assertTrue(loginPage.checkName(), "Name Field is not present");
        loginPage.enterName(username);
        Assert.assertTrue(loginPage.checkPassword(), "Password Field is not present");
        loginPage.enterPassword(password);
        Assert.assertTrue(loginPage.checkMaleRadiobtnPresent(), "Male radio button is not available ");
        Assert.assertFalse(loginPage.isMaleRadiobtnChecked(), "Male radio button is already in checked status");
        loginPage.selectMalebtn();
        Assert.assertTrue(loginPage.checkFemaleRadiobtnPresent(), "Female radio button is not available");
        Assert.assertFalse(loginPage.isFemaleRadiobtnChecked(), "Female radio button is already in checked status");
        Assert.assertTrue(loginPage.checkPrivacyBoxPresent(), "Privacy policy checkbox is not present");
        Assert.assertFalse(loginPage.isPrivacyBoxChecked(), "Privacy policy check box is already in checked status");
        loginPage.activatePrivacy();
        AndroidWebViewPageBase webViewPage = loginPage.signUpbtn();
        Assert.assertTrue(webViewPage.isPageOpened(), "WebView page is not opened");


    }


}