package com.policyexpert.home.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AboutYourPropertyDto {
    @JsonProperty("addressOfProperty")
    String addressOfProperty;

    @JsonProperty("isCorrespondenceAddress")
    boolean isCorrespondenceAddress;

    @JsonProperty("typeOfProperty")
    String typeOfProperty;

    @JsonProperty("yearOfBuilding")
    int yearOfBuilding;

    @JsonProperty("countOfBedrooms")
    int countOfBedrooms;

    @JsonProperty("isOwner")
    String whoOwner;

    @JsonProperty("whomOccupied")
    String whomOccupied;

    @JsonProperty("whenOccupied")
    String whenOccupied;

    @JsonProperty("areTreesTaller5meters")
    boolean areTreesTaller5meters;

    @JsonProperty("haveFlatRoof")
    boolean haveFlatRoof;

    public String getAddressOfProperty() {
        return addressOfProperty;
    }

    public boolean isCorrespondenceAddress() {
        return isCorrespondenceAddress;
    }

    public String getTypeOfProperty() {
        return typeOfProperty;
    }

    public int getYearOfBuilding() {
        return yearOfBuilding;
    }

    public int getCountOfBedrooms() {
        return countOfBedrooms;
    }

    public String getWhoOwner() {
        return whoOwner;
    }

    public String getWhomOccupied() {
        return whomOccupied;
    }

    public String getWhenOccupied() {
        return whenOccupied;
    }

    public boolean isAreTreesTaller5meters() {
        return areTreesTaller5meters;
    }

    public boolean isHaveFlatRoof() {
        return haveFlatRoof;
    }
}
