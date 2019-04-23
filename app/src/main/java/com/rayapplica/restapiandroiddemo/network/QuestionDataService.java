package com.rayapplica.restapiandroiddemo.network;

import com.rayapplica.restapiandroiddemo.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionDataService {
    @GET("")
    Call<Data> getData();
}
