package com.example.apiHelpers.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @JsonProperty("id")
    private  Integer id;

    @JsonProperty("email")
    private  String email;

    @JsonProperty("firstName")
    private  String firstName;

    @JsonProperty("lastName")
    private  String lastName;

    @JsonProperty("avatar")
    private  String avatar;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", email=" + email +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", avatar=" + avatar +
                '}';
    }
}
