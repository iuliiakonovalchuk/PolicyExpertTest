package com.policyexpert.home.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected RemoteWebDriver driver;

    public void waitUntilElementIsVisible(WebElement element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(element));
    }

}
