package com.policyexpert.home.tests;

import com.policyexpert.home.base.BaseTest;
import com.policyexpert.home.pages.enquirydetails.EnquiryDetailsPage;
import com.policyexpert.home.utils.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.function.Function;

public class DetailsPageTest extends BaseTest {

    private EnquiryDetailsPage enquiryDetailsPage;

    @DataProvider(name = "test-inputs")
    public Object[][] getAllTestCases(){
        List<TestData> testDataList = new ArrayList<>();
        testDataList.add(new TestData("testDataDetailsExpandedFlow.json"));
        testDataList.add(new TestData("testDataDetailsShortFlow.json"));
        Object[][] result = testDataList.stream().map(x -> new Object[] {x}).toArray(Object[][]::new);
        return result;
    }

    @Test(dataProvider = "test-inputs")
    public void fillEnquiryDetailsTestPositive(TestData testData){
        this.enquiryDetailsPage = new EnquiryDetailsPage(driver);
        this.fillEnquiry().apply(testData);
    }

    private Function<TestData, TestData> fillEnquiry() {
        return enquiryDetailsPage.fillAboutYou
                .andThen(enquiryDetailsPage.fillStatementsAboutYou)
                .andThen(enquiryDetailsPage.fillAboutYourProperty)
                .andThen(enquiryDetailsPage.fillStatementsAboutYourProperty);
    }

}
