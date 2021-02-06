package com.policyexpert.home.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementsAboutYouDto {
    @JsonProperty("doesAgree")
    boolean doesAgree;

    @JsonProperty("expandedAgreementSelection")
    StatementsAboutYouInnerDto expandedAgreementSelection;

    public boolean isDoesAgree() {
        return doesAgree;
    }

    public StatementsAboutYouInnerDto getExpandedAgreementSelection() {
        return expandedAgreementSelection;
    }
}
