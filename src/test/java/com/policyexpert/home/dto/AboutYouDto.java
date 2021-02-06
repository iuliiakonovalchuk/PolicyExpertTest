package com.policyexpert.home.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AboutYouDto {
    @JsonProperty("title")
    String title;

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("dateOfBirth")
    String dateOfBirth;

    @JsonProperty("maritalStatus")
    String maritalStatus;

    @JsonProperty("occupation")
    String occupation;

    @JsonProperty("anybodyLivingSmoke")
    boolean anybodyLivingSmoke;

    @JsonProperty("phoneNumber")
    String phoneNumber;

    @JsonProperty("email")
    String email;

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public boolean isAnybodyLivingSmoke() {
        return anybodyLivingSmoke;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
