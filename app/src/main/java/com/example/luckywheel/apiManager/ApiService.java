package com.example.luckywheel.apiManager;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("wheel")
    Call<WheelPojo> WHEEL_POJO_CALL();
}
