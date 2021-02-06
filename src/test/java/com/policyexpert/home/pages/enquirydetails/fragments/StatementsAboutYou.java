package com.policyexpert.home.pages.enquirydetails.fragments;

import com.policyexpert.home.base.BaseWidget;
import org.openqa.selenium.WebElement;

public class StatementsAboutYou extends BaseWidget {

    public static final String BTN_AGREE_TEXT = "I agree";
    public static final String BTN_DISAGREE_TEXT = "I disagree";

    public static final String STATEMENT_ABOUT_YOU_AGREE_BTN_XPATH = "//button[text()='"+BTN_AGREE_TEXT+"']";
    public static final String STATEMENT_ABOUT_YOU_DISAGREE_BTN_XPATH = "//button[text()='"+BTN_DISAGREE_TEXT+"']";

    public static final String BUSINESS_PURPOSE_TEXT = "business purposes";
    public static final String NO_BANKRUPT_TEXT = "declared bankrupt";
    public static final String NO_JUDGEMENT_TEXT = "County Court Judgement";
    public static final String DECLINED_HOME_INSURANCE_TEXT = "declined home insurance";
    public static final String CANCELLED_HOME_INSURANCE_TEXT = "home insurance cancelled";
    public static final String ANY_OFFENCE_TEXT = "any offence";

    public StatementsAboutYou(WebElement widget) {
        super(widget);
    }

    public StatementsAboutYou setSoleStatementToggle(boolean doesAgree) {
        super.setToggle(doesAgree, STATEMENT_ABOUT_YOU_AGREE_BTN_XPATH, STATEMENT_ABOUT_YOU_DISAGREE_BTN_XPATH);
        return this;
    }

    public StatementsAboutYou setStatementToggle(boolean doesAgree, String partOfVisibleText) {
        super.setToggleByLabelText(doesAgree, partOfVisibleText,
                STATEMENT_ABOUT_YOU_AGREE_BTN_XPATH, STATEMENT_ABOUT_YOU_DISAGREE_BTN_XPATH);
        return this;
    }
}
