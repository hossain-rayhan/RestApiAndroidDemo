package com.rayapplica.restapiandroiddemo.network;

import com.rayapplica.restapiandroiddemo.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionDataService {
    @GET("advanced?order=desc&sort=activity&accepted=True&answers=3&site=stackoverflow")
    Call<Data> getData();
}
