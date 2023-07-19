package com.company.carina.demo;


import com.company.carina.demo.gui.pages.desktop.LoginPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebLoginTest implements IAbstractTest {
    @Test(dataProvider = "TestData1")
    @MethodOwner(owner = "webdemo")
    public void loginTest(String email, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.clickLoginLink();
        loginPage.getLoginWindow().enterEmail(email);
        loginPage.getLoginWindow().enterPassword(password);
        loginPage.getLoginWindow().clickLoginButton();
        String actualMessage = loginPage.getMessage();
        System.out.println(actualMessage);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, expectedMessage, "Expected Message is not displayed");
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

