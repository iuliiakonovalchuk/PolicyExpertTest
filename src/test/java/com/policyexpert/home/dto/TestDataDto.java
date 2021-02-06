package com.policyexpert.home.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestDataDto {

    @JsonProperty("aboutYou")
    AboutYouDto aboutYou;

    @JsonProperty("statementsAboutYou")
    StatementsAboutYouDto statementsAboutYou;

    @JsonProperty("aboutYourProperty")
    AboutYourPropertyDto aboutYourProperty;

    @JsonProperty("statementsAboutYourProperty")
    StatementsAboutYourPropertyDto statementsAboutYourProperty;

    public AboutYouDto getAboutYou() {
        return aboutYou;
    }

    public StatementsAboutYouDto getStatementsAboutYou() {
        return statementsAboutYou;
    }

    public AboutYourPropertyDto getAboutYourProperty() {
        return aboutYourProperty;
    }

    public StatementsAboutYourPropertyDto getStatementsAboutYourProperty() {
        return statementsAboutYourProperty;
    }

}
