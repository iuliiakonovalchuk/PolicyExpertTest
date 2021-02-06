package com.policyexpert.home.pages.enquirydetails.fragments;

import com.policyexpert.home.base.BaseWidget;
import org.openqa.selenium.WebElement;

public class AboutYou extends BaseWidget {

    public static final String titleDropdownCss = "div.question-row-title .form-control";

    public AboutYou(WebElement widget) {
        super(widget);
    }

    public boolean isAt() {
        return true;
    }

    public AboutYou setTitle(String title) {
        selectItemInDropdownByValue(titleDropdownCss, title);
        return this;
    }

}
