package com.policyexpert.home.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementsAboutYouInnerDto {
    @JsonProperty("propertyNotForBusiness")
    boolean propertyNotForBusiness;

    @JsonProperty("noBankrupt")
    boolean noBankrupt;

    @JsonProperty("noCourtJudgement")
    boolean noCourtJudgement;

    @JsonProperty("noDeclinedHomeInsurance")
    boolean noDeclinedHomeInsurance;

    @JsonProperty("noCancelledHomeInsurance")
    boolean noCancelledHomeInsurance;

    @JsonProperty("noConvictedOffence")
    boolean noConvictedOffence;

    public boolean isPropertyNotForBusiness() {
        return propertyNotForBusiness;
    }

    public boolean isNoBankrupt() {
        return noBankrupt;
    }

    public boolean isNoCourtJudgement() {
        return noCourtJudgement;
    }

    public boolean isNoDeclinedHomeInsurance() {
        return noDeclinedHomeInsurance;
    }

    public boolean isNoCancelledHomeInsurance() {
        return noCancelledHomeInsurance;
    }

    public boolean isNoConvictedOffence() {
        return noConvictedOffence;
    }
}