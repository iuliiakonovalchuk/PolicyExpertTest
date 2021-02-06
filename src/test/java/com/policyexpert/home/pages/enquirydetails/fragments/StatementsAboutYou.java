package com.policyexpert.home.pages.enquirydetails.fragments;

import com.policyexpert.home.base.BaseWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StatementsAboutYou extends BaseWidget {

    public static final String statementAboutYouAgreeBtnXPath = "//button[text()='I agree']";

    public StatementsAboutYou(WebElement widget) {
        super(widget);
    }

    public boolean isAt() {
        return true;
    }

    public void setStatementAboutYou(boolean isAgree) {
        if(isAgree){
            click(widget.findElement(By.xpath(statementAboutYouAgreeBtnXPath)));
        }else{
            //TODO
        }
    }

}
