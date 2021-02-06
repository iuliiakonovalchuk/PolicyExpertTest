package com.policyexpert.home.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseWidget {

    protected WebElement widget;

    public BaseWidget(WebElement widget) {
        this.widget = widget;
    }

    /**
     * Method to find the element
     *
     * @param by e.g. By.cssSelector
     * @return WebElement if found or null if unable to find element
     */
    protected WebElement getElementBy(By by) {
        try {
            return widget.findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    protected List<WebElement> getElementsBy(By by) {
        try {
            return widget.findElements(by);
        } catch (NoSuchElementException e) {
            return new ArrayList<>();
        }
    }

    protected WebElement getElementByCss(String css) {
        return getElementBy(By.cssSelector(css));
    }

    protected boolean selectItemInDropdownByValue(String dropdownIdentifier, String value) {
        Select dropdown = new Select(getElementByCss(dropdownIdentifier));
        if (dropdown == null) {
            return false;
        }
        dropdown.selectByValue(value);
        return true;
    }

    protected void click(WebElement element) {
        element.click();
    }
}
