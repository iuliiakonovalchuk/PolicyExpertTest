package com.policyexpert.home.base;

import com.policyexpert.home.pages.enquirydetails.fragments.AboutYou;
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

    protected WebElement getElementByXPath(String xpath) {
        return getElementBy(By.xpath(xpath));
    }

    protected void selectItemInDropdownByValue(String dropdownIdentifier, String value) {
        selectItemInDropdownByValue(getElementByCss(dropdownIdentifier),value);
    }

    protected void selectItemInDropdownByValue(WebElement select, String value) {
        Select dropdown = new Select(select);
        dropdown.selectByValue(value);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    public BaseWidget setFieldByCSS(String field, String value){
        sendKeys(getElementByCss(field), value);
        return this;
    }

    public static String buildXpathForToggle(boolean doesAgree, String partOfVisibleText, String yesXPath, String noXPath) {
        StringBuffer sb = new StringBuffer("//p[contains(text(),'");
        sb.append(partOfVisibleText);
        sb.append("')]/../following-sibling::div");
        String btnText = (doesAgree) ? yesXPath : noXPath;
        sb.append(btnText);
        return sb.toString();
    }

    public boolean isAt() {
        return isElementVisible(widget);
    }

    public BaseWidget selectItemInDropdown(String dropdownCss, String value) {
        selectItemInDropdownByValue(dropdownCss, value);
        return this;
    }

    public BaseWidget selectItemInDropdown(WebElement element, String value) {
        selectItemInDropdownByValue(element, value);
        return this;
    }

    public BaseWidget setToggle(boolean isYes, String yesXpath, String noXpath) {
        if (isYes) {
            click(getElementBy(By.xpath(yesXpath)));
        } else {
            click(getElementBy(By.xpath(noXpath)));
        }
        return this;
    }

    public BaseWidget setToggleByLabelText(boolean isYes, String partOfVisibleText, String yesBtnXpath, String noBtnXpath) {
        click(getElementByXPath(buildXpathForToggle(isYes, partOfVisibleText, yesBtnXpath, noBtnXpath)));
        return this;
    }

}
