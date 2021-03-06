package com.example.apiHelpers.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Override
    public String toString() {
        return "User{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
    @JsonProperty("data")
    private Data data;
    @JsonProperty("support")
    private com.example.apiHelpers.pojo.Support support;

    public Data getData() {
        return data;
    }

    public com.example.apiHelpers.pojo.Support getSupport() {
        return support;
    }

}