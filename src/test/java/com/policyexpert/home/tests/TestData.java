package com.policyexpert.home.tests;

import com.policyexpert.home.utils.ParseTestData;
import com.policyexpert.home.utils.PageStatesBucket;

public class TestData {

    ParseTestData parseTestData;

    public static final String aboutYou = "aboutYou";
    public static final String title = "title";
    public static final String firstName = "firstName";
    public static final String lastName = "lastName";
    public static final String dateOfBirth = "dateOfBirth";
    public static final String maritalStatus = "maritalStatus";
    public static final String occupation = "occupation";
    public static final String anybodyLivingSmoke = "anybodyLivingSmoke";
    public static final String phoneNumber = "phoneNumber";
    public static final String email = "email";

    public static final String statementAboutYou = "statementsAboutYou";
    public static final String doesAgree = "doesAgree";
    public static final String expandedAgreementSelection = "expandedAgreementSelection";
    public static final String propertyNotForBusiness = "propertyNotForBusiness";
    public static final String noBankrupt = "noBankrupt";
    public static final String noCourtJudgement = "noCourtJudgement";
    public static final String noDeclinedHomeInsurance = "noDeclinedHomeInsurance";
    public static final String noCancelledHomeInsurance = "noCancelledHomeInsurance";
    public static final String noConvictedOffence = "noConvictedOffence";

    public TestData(String filename) {
        this.parseTestData = new ParseTestData(filename);
    }

    public boolean filledAboutYou() {
        return PageStatesBucket.isAboutYouFilled;
    }

    public boolean filledStatementsAboutYou() {
        return PageStatesBucket.isStatementsAboutYouFilled;
    }

    public String getTitle() {
        return parseTestData.getJsonValue(aboutYou, title);
    }

    public String getFirstName() {
        return parseTestData.getJsonValue(aboutYou, firstName);
    }

    public String getLastName() {
        return parseTestData.getJsonValue(aboutYou, lastName);
    }

    public String getDateOfBirth() {
        return parseTestData.getJsonValue(aboutYou, dateOfBirth);
    }

    public String getMaritalStatus() {
        return parseTestData.getJsonValue(aboutYou, maritalStatus);
    }

    public String getOccupation() {
        return parseTestData.getJsonValue(aboutYou, occupation);
    }

    public boolean getAnybodyLivingSmoke() {
        return Boolean.valueOf(parseTestData.getJsonValue(aboutYou, anybodyLivingSmoke));
    }

    public String getPhoneNumber() {
        return parseTestData.getJsonValue(aboutYou, phoneNumber);
    }

    public String getEmail() {
        return parseTestData.getJsonValue(aboutYou, email);
    }

    public boolean getStatementAboutYou() {
        return Boolean.valueOf(parseTestData.getJsonValue(statementAboutYou, doesAgree));
    }

    public boolean getStatAboutYouNoBusiness() {
        return Boolean.valueOf(parseTestData.getJsonValue(statementAboutYou, expandedAgreementSelection, propertyNotForBusiness));
    }

    public boolean getStatAboutYouNoBankrupt() {
        return Boolean.valueOf(parseTestData.getJsonValue(statementAboutYou, expandedAgreementSelection, noBankrupt));
    }

    public boolean getStatAboutYouNoJudgement() {
        return Boolean.valueOf(parseTestData.getJsonValue(statementAboutYou, expandedAgreementSelection, noCourtJudgement));
    }

    public boolean getStatAboutYouNoDeclinedIns() {
        return Boolean.valueOf(parseTestData.getJsonValue(statementAboutYou, expandedAgreementSelection, noDeclinedHomeInsurance));
    }

    public boolean getStatAboutYouNoCancelledIns() {
        return Boolean.valueOf(parseTestData.getJsonValue(statementAboutYou, expandedAgreementSelection, noCancelledHomeInsurance));
    }

    public boolean getStatAboutYouNoOffence() {
        return Boolean.valueOf(parseTestData.getJsonValue(statementAboutYou, expandedAgreementSelection, noConvictedOffence));
    }

}
