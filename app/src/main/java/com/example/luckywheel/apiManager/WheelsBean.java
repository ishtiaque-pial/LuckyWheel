package com.example.luckywheel.apiManager;

import com.google.gson.annotations.SerializedName;

public class WheelsBean {
    /**
     * code : 84abb48d8839591257dadec54d946040
     * name : TC300
     */

    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
