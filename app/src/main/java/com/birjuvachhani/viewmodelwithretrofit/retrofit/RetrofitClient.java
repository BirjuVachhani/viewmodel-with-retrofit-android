package com.birjuvachhani.viewmodelwithretrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Birju Vachhani on 02-08-2018.
 */
public class RetrofitClient {
    private static Retrofit retrofitClient;
    private static final String BASE_URL = "https://randomuser.me";

    public static Retrofit getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitClient;
    }
}
