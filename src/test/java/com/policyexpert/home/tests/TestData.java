package com.policyexpert.home.tests;

import com.policyexpert.home.utils.ParseTestData;
import com.policyexpert.home.utils.PageStatesBucket;

public class TestData {

    ParseTestData parseTestData;

    public static final String aboutYou = "aboutYou";
    public static final String title = "title";
    public static final String statementAboutYou = "statementsAboutYou";
    public static final String doesAgree = "doesAgree";

    public TestData(String filename){
        this.parseTestData = new ParseTestData(filename);
    }

    public boolean filledAboutYou() {
        return PageStatesBucket.isAboutYouFilled;
    };

    public boolean filledStatementsAboutYou() {
        return PageStatesBucket.isStatementsAboutYouFilled;
    }

    public String getTitle() {
        return parseTestData.getJsonValue(aboutYou, title);
    }

    public boolean getStatementAboutYou() {
        return Boolean.valueOf(parseTestData.getJsonValue(statementAboutYou, doesAgree));
    }
}
