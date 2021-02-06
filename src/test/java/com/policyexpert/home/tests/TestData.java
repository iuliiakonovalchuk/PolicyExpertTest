package com.policyexpert.home.tests;

import com.policyexpert.home.dto.*;
import com.policyexpert.home.utils.ParseTestData;
import com.policyexpert.home.utils.PageStatesBucket;

public class TestData {

    TestDataDto testDataDto;

    public TestData(String filename) {
        this.testDataDto = ParseTestData.parseJsonFromFile(filename);
    }

    public boolean filledAboutYou() {
        return PageStatesBucket.isAboutYouFilled;
    }

    public boolean filledStatementsAboutYou() {
        return PageStatesBucket.isStatementsAboutYouFilled;
    }

    public boolean filledAboutYourProperty() {
        return PageStatesBucket.isAboutYourPropertyFilled;
    }

    public TestDataDto getTestDataDto() {
        return testDataDto;
    }

    public AboutYouDto getAboutYou(){
        return testDataDto.getAboutYou();
    }

    public StatementsAboutYouDto getStatementsAboutYou(){
        return testDataDto.getStatementsAboutYou();
    }

    public StatementsAboutYouInnerDto getExpandedAgreementSelection(){
        return testDataDto.getStatementsAboutYou().getExpandedAgreementSelection();
    }

    public AboutYourPropertyDto getAboutYourProperty(){
        return testDataDto.getAboutYourProperty();
    }

}
