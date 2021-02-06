package com.policyexpert.home.pages.enquirydetails.fragments;

import com.policyexpert.home.base.BaseWidget;
import org.openqa.selenium.WebElement;

public class StatementsAboutYourProperty extends BaseWidget {

    public static final String BTN_AGREE_TEXT = "Yes";
    public static final String BTN_DISAGREE_TEXT = "No";

    public static final String STATEMENT_ABOUT_YOU_AGREE_BTN_XPATH = "//button[text()='"+BTN_AGREE_TEXT+"']";
    public static final String STATEMENT_ABOUT_YOU_DISAGREE_BTN_XPATH = "//button[text()='"+BTN_DISAGREE_TEXT+"']";

    public StatementsAboutYourProperty(WebElement widget) {
        super(widget);
    }

    public StatementsAboutYourProperty setSoleStatementToggle(boolean doesAgree) {
        super.setToggle(doesAgree, STATEMENT_ABOUT_YOU_AGREE_BTN_XPATH, STATEMENT_ABOUT_YOU_DISAGREE_BTN_XPATH);
        return this;
    }

}
