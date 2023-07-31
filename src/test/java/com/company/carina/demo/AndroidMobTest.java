package com.company.carina.demo;

import com.company.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidMobTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "mobdemo")
    public void testLoginPage() {
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        SoftAssert softAssert = new SoftAssert();
        AndroidWelcomePageBase welcomePage = initPage(getDriver(), AndroidWelcomePageBase.class);
        Assert.assertTrue(welcomePage.isLogoPresent(), "WelcomePage is not opened");
        Assert.assertTrue(welcomePage.isNextBtnPresent(), "Next button is not available");
        AndroidLoginPageBase loginPage = welcomePage.clickNextBtn();
        //Verify whether fields are present
        softAssert.assertTrue(loginPage.isNameFieldPresent(), "Name Field is not present");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(), "Password Field is not present");
        softAssert.assertTrue(loginPage.isMaleRadioBtnPresent(), "Male radio button is not present ");
        softAssert.assertTrue(loginPage.isFemaleRadioBtnPresent(), "Female radio button is not present");
        Assert.assertTrue(loginPage.isPrivacyBoxPresent(), "Privacy policy checkbox is not present");
        softAssert.assertFalse(loginPage.isMaleRadioBtnChecked(), "Male radio button is already in checked status");
        softAssert.assertFalse(loginPage.isFemaleRadioBtnChecked(), "Female radio button is already in checked status");
        softAssert.assertFalse(loginPage.isPrivacyBoxChecked(), "Privacy policy check box is already in checked status");
        //enter username
        loginPage.enterName(username);
        //check whether username entered is correct
        Assert.assertEquals(loginPage.isNameFieldValuePresent(), username, "UserName is entered is not correct");
        //enter password
        loginPage.enterPassword(password);
        //check whether password entered is correct
        Assert.assertEquals(loginPage.isPasswordFieldValuePresent(), password, "Password is entered is not correct");
        //select male radio button
        loginPage.selectMaleBtn();
        //check whether male radio button is selected
        Assert.assertTrue(loginPage.isMaleRadioBtnChecked(), "Male radio button is not checked");
        //select privacy policy checkbox
        loginPage.activatePrivacy();
        //check whether privacy policy checkbox is selected
        Assert.assertTrue(loginPage.isPrivacyBoxChecked(), "Privacy policy check box is not checked");
        AndroidWebViewPageBase webViewPage = loginPage.signUpBtn();
        //check whether web view page is opened
        Assert.assertTrue(webViewPage.isPageOpened(), "WebView page is not opened");
        softAssert.assertAll();
    }
}