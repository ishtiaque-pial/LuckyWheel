package com.example.luckywheel.apiManager;

import com.google.gson.annotations.SerializedName;

public class WheelPojo {

    /**
     * code : SUCCESS
     * response : {"code":"b2da0700-b4ee-11e9-bed6-4751944ee7a3","selected":"","tripcoinBalance":460,"wheels":[{"code":"84abb48d8839591257dadec54d946040","name":"TC300"},{"code":"b1e079806922ca0bac1430473f932da8","name":"Safari World & Marine Park BKK"},{"code":"760f0707e93435b30b4c3df70bacd9c4","name":"1 Night (5 Star-KTM)"},{"code":"d68016e1147efe57a157286a69fbf956","name":"Parasailing in Pattaya"},{"code":"d8d8c00a411a271549604a5ed438333a","name":"Spin Again"},{"code":"583d22fb4277f1f7ae6b4bd0a25b1a36","name":"1 Night (3 Star-KTM)"},{"code":"95a5f310cb690b650c89493618864123","name":"Spin Again"},{"code":"e49c9232cd98f17b84bf6c527125479f","name":"TC100"},{"code":"e22473f5851407b65fa204939453dba0","name":"Spin Again"},{"code":"9970619f52abe566ded78d3445e2285d","name":"1 Night (3 Star-HAN)"},{"code":"6dea62a7e507f70ee4d832ece38aba5d","name":"1 Night (4 Star-DPS)"},{"code":"768d318b5c293e07e19f44adf61984ab","name":"TC80"}]}
     */

    @SerializedName("code")
    private String code;
    @SerializedName("response")
    private ResponseBean response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }
}
