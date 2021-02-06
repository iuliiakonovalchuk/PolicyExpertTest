package com.policyexpert.home.tests;

import com.policyexpert.home.base.BaseTest;
import com.policyexpert.home.pages.enquirydetails.EnquiryDetailsPage;
import org.testng.annotations.Test;
import java.util.function.Function;

public class DetailsPageTest extends BaseTest {

    private EnquiryDetailsPage enquiryDetailsPage;

    @Test
    public void workFlowTest(){
        TestData testData = new TestData("testDataDetails.json");
        this.enquiryDetailsPage = new EnquiryDetailsPage(driver);
        this.fillAboutYouPositive().apply(testData);
    }

    private Function<TestData, TestData> fillAboutYouPositive() {
        return enquiryDetailsPage.fillAboutYou
                .andThen(enquiryDetailsPage.fillAboutYou)
                .andThen(enquiryDetailsPage.fillStatementsAboutYou);
    }

}
