package com.policyexpert.home.pages.enquirydetails.fragments;

import com.policyexpert.home.base.BaseWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AboutYou extends BaseWidget {

    public static final String TITLE_DROPDOWN_CSS = "div.question-row-title .form-control";
    public static final String FIRST_NAME_CSS = ".question-row-first-name input";
    public static final String LAST_NAME_CSS = ".question-row-last-name input";
    public static final String BIRTHDAY_SELECTS_CSS = ".question-row-what-is-your-date-of select";
    public static final String MARITAL_STATUS_CSS = ".question-row-what-is-your-marital select";
    public static final String OCCUPATION_CSS = ".question-row-what-is-your-occupat input";
    public static final String YES_BTN_XPATH = "//button[text()='Yes']";
    public static final String NO_BTN_XPATH = "//button[text()='No']";
    public static final String PHONE_NUMBER_CSS = ".question-row-main-telephone-numbe input";
    public static final String EMAIL_CSS = ".question-row-what-is-your-e-mail input";

    public AboutYou(WebElement widget) {
        super(widget);
    }

    public boolean isAt() {
        return isElementVisible(widget);
    }

    public AboutYou selectItemInDropdown(String dropdownCss, String value) {
        super.setFieldByCSS(dropdownCss,value);
        return this;
    }

    public AboutYou setFieldByCSS(String field, String value){
        super.setFieldByCSS(field,value);
        return this;
    }

    public AboutYou setBirthday(String birthday) {
        List<WebElement> birthdayBlock = getElementsBy(By.cssSelector(BIRTHDAY_SELECTS_CSS));
        //We need to remove leading 0. The easiest way is to convert to Int
        selectItemInDropdownByValue(birthdayBlock.get(0), String.valueOf(Integer.parseInt(birthday.split("/")[0])));
        selectItemInDropdownByValue(birthdayBlock.get(1), String.valueOf(Integer.parseInt(birthday.split("/")[1])));
        selectItemInDropdownByValue(birthdayBlock.get(2), birthday.split("/")[2]);
        return this;
    }

    public AboutYou setToggleInAboutYou(boolean isYes) {
        super.setToggle(isYes, YES_BTN_XPATH, NO_BTN_XPATH);
        return this;
    }

}
