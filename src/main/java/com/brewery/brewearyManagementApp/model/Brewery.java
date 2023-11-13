package com.brewery.brewearyManagementApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter@AllArgsConstructor@NoArgsConstructor
public class Brewery {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String breweryName;
    @JsonProperty("address_1")
    private String breweryAddress;
    @JsonProperty("phone")
    private String phoneNumber;
    @JsonProperty("website_url")
    private String webSiteUrl;
    @JsonProperty("state")
    private String state;
    @JsonProperty("city")
    private String city;
    @Override
    public String toString(){
        return "Id : "+id+"Name : "+breweryName+" breweryAddress : "+breweryAddress+" contact : "+phoneNumber;
    }
}
