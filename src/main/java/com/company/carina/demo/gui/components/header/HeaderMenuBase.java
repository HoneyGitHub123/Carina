package com.company.carina.demo.gui.components.header;

import com.company.carina.demo.gui.components.LoginWindow;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuBase extends AbstractUIObject {
    public HeaderMenuBase(WebDriver driver, SearchContext searchContext){
        super(driver, searchContext);
    }
    public abstract LoginWindow clickLoginlink();


    }
