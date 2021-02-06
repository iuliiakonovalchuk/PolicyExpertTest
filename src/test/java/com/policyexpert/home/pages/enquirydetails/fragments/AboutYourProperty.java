package com.policyexpert.home.pages.enquirydetails.fragments;

import com.policyexpert.home.base.BaseWidget;
import org.openqa.selenium.WebElement;

public class AboutYourProperty extends BaseWidget {

    private static final String YES_BUTTON_TEXT = "Yes";
    private static final String NO_BUTTON_TEXT = "No";

    private static final String YES_BUTTON_XPATH = "//button[text()='"+YES_BUTTON_TEXT+"']";
    private static final String NO_BUTTON_XPATH = "//button[text()='"+NO_BUTTON_TEXT+"']";

    public static final String PROPERTY_ADDRESS_CSS = ".question-row-address-of-property input";
    public static final String PROPERTY_TYPE_SELECT_CSS =".question-row-what-type-of-propert select";
    public static final String PROPERTY_BUILT_YEAR_CSS = ".question-row-approximately-in-whi input";
    public static final String BEDROOMS_COUNT_SELECT_CSS = ".question-row-how-many-bedrooms-do select";
    public static final String OWN_PROPERTY_SELECT_CSS = ".question-row-do-you-own-the-prope select";
    public static final String WHO_PROPERTY_OCCUPIED = ".question-row-who-is-the-property select";
    public static final String WHEN_PROPERTY_OCCUPIED = ".question-row-when-is-the-property select";

    public static final String CORRESPONDENCE_ADDRESS_TEXT = "your correspondence address";
    public static final String TREES_AROUND_TEXT = "Are there trees taller";
    public static final String FLAT_ROOT_TEXT = "have a flat roof";

    public AboutYourProperty(WebElement widget) {
        super(widget);
    }

    public AboutYourProperty setFieldByCSS(String field, String value){
        super.setFieldByCSS(field,value);
        return this;
    }

    public AboutYourProperty setToggleByLabelText(boolean isYes, String partOfVisibleText) {
        super.setToggleByLabelText(isYes, partOfVisibleText, YES_BUTTON_XPATH, NO_BUTTON_XPATH);
        return this;
    }

    public AboutYourProperty selectItemInDropdown(String dropdownCss, String value) {
        super.selectItemInDropdown(dropdownCss,value);
        return this;
    }

}
