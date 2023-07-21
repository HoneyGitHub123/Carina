package com.company.carina.demo;


import com.company.carina.demo.gui.components.LoginWindow;
import com.company.carina.demo.gui.pages.common.LoginPageBase;
import com.company.carina.demo.gui.pages.desktop.LoginPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebLoginTest implements IAbstractTest {
    @Test(dataProvider = "TestData1")
    @MethodOwner(owner = "webdemo")
    public void loginTest(String email, String password, String expectedMessage) {
        LoginPageBase loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.clickLoginLink();
        LoginWindow loginWindow=loginPage.getLoginWindow();
        //checking whether login window is displayed
        Assert.assertTrue(loginWindow.isUIObjectPresent(),"Login Window is not displayed");
        loginWindow.enterEmail(email);
        loginWindow.enterPassword(password);
        //loginWindow.clickLoginButton();
        String actualMessage = loginWindow.clickLoginButton().getMessage();
        System.out.println(actualMessage);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, expectedMessage, "Expected Message is not displayed");
        softAssert.assertAll();
    }

    @DataProvider(name = "TestData1")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"s9rowa@mail.ru", "changeme", "Login successful.\n" +
                        "Stand-by for redirect."},
                {"s94rowa@mail.ru", "changeme", "Login failed.\n" +
                        "Reason: User record not found."},
                {"s9rowa@mail.ru", "chang4eme", "Login failed.\n" +
                        "Reason: Wrong password."}};

    }
}

