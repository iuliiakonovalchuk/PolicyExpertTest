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

    @FindBy(xpath="//div[text() = 'About you']/following-sibling::div")
    private WebElement aboutYouWidget;

    @FindBy(xpath = "//div[text() = 'Statements about you']/following-sibling::div")
    private WebElement statementsAboutYouWidget;

    public EnquiryDetailsPage(RemoteWebDriver driver) {
        PageFactory.initElements(driver,this);
        this.aboutYou = new AboutYou(aboutYouWidget);
        this.statementsAboutYou = new StatementsAboutYou(statementsAboutYouWidget);
       // this.aboutYourProperty = new AboutYourProperty(driver);
        //this.statementsAboutYourProperty = new StatementsAboutYourProperty(driver);
        //this.aboutSafetyAndSecurity = new AboutSafetyAndSecurity(driver);
        //this.aboutTheJointPolicyholders = new AboutTheJointPolicyholders(driver);
        //this.aboutYourInsuranceHistory = new AboutYourInsuranceHistory(driver);
        //this.aboutTheCoverYouWant = new AboutTheCoverYouWant(driver);
    }

    public final UnaryOperator<TestData> fillAboutYou = (d) -> {
        if (!d.filledAboutYou()) {
            assertTrue(aboutYou.isAt());
            aboutYou.setTitle(d.getTitle())
                    .setFieldByCSS(AboutYou.FIRST_NAME_CSS,d.getFirstName())
                    .setFieldByCSS(AboutYou.LAST_NAME_CSS,d.getLastName())
                    .setBirthday(d.getDateOfBirth())
                    .setMaritalStatus(d.getMaritalStatus())
                    .setFieldByCSS(AboutYou.OCCUPATION_CSS,d.getOccupation()) //TODO
                    .setDoesAnybodySmoke(d.getAnybodyLivingSmoke())
                    .setFieldByCSS(AboutYou.PHONE_NUMBER_CSS,d.getPhoneNumber())
                    .setFieldByCSS(AboutYou.EMAIL_CSS,d.getEmail());
        }
        PageStatesBucket.isAboutYouFilled = true;
        return d;
    };

    public final UnaryOperator<TestData> fillStatementsAboutYou = (d) -> {
        if(!d.filledStatementsAboutYou()){
            assertTrue(statementsAboutYou.isAt());
            this.statementsAboutYou.setStatementAboutYou(d.getStatementAboutYou());
        }
        if(!d.getStatementAboutYou()) {
            this.statementsAboutYou
                    .setStatementToggle(d.getStatAboutYouNoBusiness(), StatementsAboutYou.BUSINESS_PURPOSE_TEXT)
                    .setStatementToggle(d.getStatAboutYouNoBankrupt(), StatementsAboutYou.NO_BANKRUPT_TEXT)
                    .setStatementToggle(d.getStatAboutYouNoJudgement(), StatementsAboutYou.NO_JUDGEMENT_TEXT)
                    .setStatementToggle(d.getStatAboutYouNoDeclinedIns(), StatementsAboutYou.DECLINED_HOME_INSURANCE_TEXT)
                    .setStatementToggle(d.getStatAboutYouNoCancelledIns(), StatementsAboutYou.CANCELLED_HOME_INSURANCE_TEXT)
                    .setStatementToggle(d.getStatAboutYouNoOffence(), StatementsAboutYou.ANY_OFFENCE_TEXT);
        }
        return d;
    };

}
