package com.policyexpert.home.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementsAboutYourPropertyDto {

    @JsonProperty("doesAgree")
    boolean doesAgree;

    public boolean isDoesAgree() {
        return doesAgree;
    }

}
