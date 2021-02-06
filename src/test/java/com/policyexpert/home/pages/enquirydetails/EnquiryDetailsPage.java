package com.policyexpert.home.pages.enquirydetails;

import com.policyexpert.home.base.BasePage;
import com.policyexpert.home.pages.enquirydetails.fragments.*;
import com.policyexpert.home.tests.TestData;
import com.policyexpert.home.utils.PageStatesBucket;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.UnaryOperator;

import static org.testng.Assert.assertTrue;

public class EnquiryDetailsPage extends BasePage {

    private AboutYou aboutYou;
    private StatementsAboutYou statementsAboutYou;
    private AboutYourProperty aboutYourProperty;
    private StatementsAboutYourProperty statementsAboutYourProperty;
    private AboutSafetyAndSecurity aboutSafetyAndSecurity;
    private AboutTheJointPolicyholders aboutTheJointPolicyholders;
    private AboutYourInsuranceHistory aboutYourInsuranceHistory;
    private AboutTheCoverYouWant aboutTheCoverYouWant;

    @FindBy(xpath = "//div[text() = 'About you']/following-sibling::div")
    private WebElement aboutYouWidget;

    @FindBy(xpath = "//div[text() = 'Statements about you']/following-sibling::div")
    private WebElement statementsAboutYouWidget;

    @FindBy(xpath = "//div[text() = 'About your property']/following-sibling::div")
    private WebElement aboutYourPropertyWidget;

    @FindBy(xpath = "//div[text() = 'Statements about your property']/following-sibling::div")
    private WebElement statementsAboutYourPropertyWidget;

    public EnquiryDetailsPage(RemoteWebDriver driver) {
        PageFactory.initElements(driver, this);
        this.aboutYou = new AboutYou(aboutYouWidget);
        this.statementsAboutYou = new StatementsAboutYou(statementsAboutYouWidget);
        this.aboutYourProperty = new AboutYourProperty(aboutYourPropertyWidget);
        this.statementsAboutYourProperty = new StatementsAboutYourProperty(statementsAboutYourPropertyWidget);
        //this.aboutSafetyAndSecurity = new AboutSafetyAndSecurity(aboutSafetyAndSecurityWidget);
        //this.aboutTheJointPolicyholders = new AboutTheJointPolicyholders(aboutTheJointPolicyholdersWidget);
        //this.aboutYourInsuranceHistory = new AboutYourInsuranceHistory(aboutYourInsuranceHistoryWidget);
        //this.aboutTheCoverYouWant = new AboutTheCoverYouWant(aboutTheCoverYouWantWidget);
    }

    public final UnaryOperator<TestData> fillAboutYou = (d) -> {
        if (!d.filledAboutYou()) {
            assertTrue(aboutYou.isAt());
            aboutYou.selectItemInDropdown(AboutYou.TITLE_DROPDOWN_CSS, d.getAboutYou().getTitle())
                    .setFieldByCSS(AboutYou.FIRST_NAME_CSS, d.getAboutYou().getFirstName())
                    .setFieldByCSS(AboutYou.LAST_NAME_CSS, d.getAboutYou().getLastName())
                    .setBirthday(d.getAboutYou().getDateOfBirth())
                    .selectItemInDropdown(AboutYou.MARITAL_STATUS_CSS, d.getAboutYou().getMaritalStatus())
                    .setFieldByCSS(AboutYou.OCCUPATION_CSS, d.getAboutYou().getOccupation())
                    .setToggleInAboutYou(d.getAboutYou().isAnybodyLivingSmoke())
                    .setFieldByCSS(AboutYou.PHONE_NUMBER_CSS, d.getAboutYou().getPhoneNumber())
                    .setFieldByCSS(AboutYou.EMAIL_CSS, d.getAboutYou().getEmail());
        }
        PageStatesBucket.isAboutYouFilled = true;
        return d;
    };

    public final UnaryOperator<TestData> fillStatementsAboutYou = (d) -> {
        if (!d.filledStatementsAboutYou()) {
            assertTrue(statementsAboutYou.isAt());
            this.statementsAboutYou.setSoleStatementToggle(d.getStatementsAboutYou().isDoesAgree());
        }
        if (!d.getStatementsAboutYou().isDoesAgree()) {
            this.statementsAboutYou
                    .setStatementToggle(d.getExpandedAgreementSelection().isPropertyNotForBusiness(), StatementsAboutYou.BUSINESS_PURPOSE_TEXT)
                    .setStatementToggle(d.getExpandedAgreementSelection().isNoBankrupt(), StatementsAboutYou.NO_BANKRUPT_TEXT)
                    .setStatementToggle(d.getExpandedAgreementSelection().isNoCourtJudgement(), StatementsAboutYou.NO_JUDGEMENT_TEXT)
                    .setStatementToggle(d.getExpandedAgreementSelection().isNoDeclinedHomeInsurance(), StatementsAboutYou.DECLINED_HOME_INSURANCE_TEXT)
                    .setStatementToggle(d.getExpandedAgreementSelection().isNoCancelledHomeInsurance(), StatementsAboutYou.CANCELLED_HOME_INSURANCE_TEXT)
                    .setStatementToggle(d.getExpandedAgreementSelection().isNoConvictedOffence(), StatementsAboutYou.ANY_OFFENCE_TEXT);
        }
        PageStatesBucket.isStatementsAboutYouFilled = true;
        return d;
    };

    public final UnaryOperator<TestData> fillAboutYourProperty = (d) -> {
        if (!d.filledAboutYourProperty()) {
            assertTrue(aboutYourProperty.isAt());
            this.aboutYourProperty
                    .setFieldByCSS(AboutYourProperty.PROPERTY_ADDRESS_CSS, d.getAboutYourProperty().getAddressOfProperty())
                    .setToggleByLabelText(d.getAboutYourProperty().isCorrespondenceAddress(), AboutYourProperty.CORRESPONDENCE_ADDRESS_TEXT)
                    .selectItemInDropdown(AboutYourProperty.PROPERTY_TYPE_SELECT_CSS, d.getAboutYourProperty().getTypeOfProperty())
                    .setFieldByCSS(AboutYourProperty.PROPERTY_BUILT_YEAR_CSS, String.valueOf(d.getAboutYourProperty().getYearOfBuilding()))
                    .selectItemInDropdown(AboutYourProperty.BEDROOMS_COUNT_SELECT_CSS,String.valueOf(d.getAboutYourProperty().getCountOfBedrooms()))
                    .selectItemInDropdown(AboutYourProperty.OWN_PROPERTY_SELECT_CSS, d.getAboutYourProperty().getWhoOwner())
                    .selectItemInDropdown(AboutYourProperty.WHO_PROPERTY_OCCUPIED, d.getAboutYourProperty().getWhomOccupied())
                    .selectItemInDropdown(AboutYourProperty.WHEN_PROPERTY_OCCUPIED, d.getAboutYourProperty().getWhenOccupied())
                    .setToggleByLabelText(d.getAboutYourProperty().isAreTreesTaller5meters(), AboutYourProperty.TREES_AROUND_TEXT)
                    .setToggleByLabelText(d.getAboutYourProperty().isHaveFlatRoof(), AboutYourProperty.FLAT_ROOT_TEXT);
        }
        PageStatesBucket.isAboutYourPropertyFilled = true;
        return d;
    };

    public final UnaryOperator<TestData> fillStatementsAboutYourProperty = (d) -> {
        if (!d.filledStatementsAboutYourProperty()) {
            assertTrue(statementsAboutYourProperty.isAt());
            this.statementsAboutYourProperty
                    .setSoleStatementToggle(d.getStatementsAboutYourProperty().isDoesAgree());
        }
        PageStatesBucket.isStatementsAboutYourPropertyFilled = true;
        return d;
    };

}
