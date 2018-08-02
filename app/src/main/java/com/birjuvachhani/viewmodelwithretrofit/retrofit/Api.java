package com.birjuvachhani.viewmodelwithretrofit.retrofit;

import com.birjuvachhani.viewmodelwithretrofit.api.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Birju Vachhani on 02-08-2018.
 */
public interface Api {

    @GET("/api/")
    Call<ApiResponse> getUsers(@Query("results") int numbers);
}
