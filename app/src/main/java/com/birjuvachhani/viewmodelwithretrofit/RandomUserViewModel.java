package com.birjuvachhani.viewmodelwithretrofit;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.birjuvachhani.viewmodelwithretrofit.api.ApiResponse;
import com.birjuvachhani.viewmodelwithretrofit.api.Result;
import com.birjuvachhani.viewmodelwithretrofit.retrofit.Api;
import com.birjuvachhani.viewmodelwithretrofit.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Birju Vachhani on 02-08-2018.
 */
public class RandomUserViewModel extends ViewModel {
    private MutableLiveData<List<Result>> mUserList;
    private Api api = RetrofitClient.getInstance().create(Api.class);

    public MutableLiveData<List<Result>> getUsers() {
        if (mUserList == null) {
            mUserList = new MutableLiveData<>();
            fetchUsers();
        }
        return mUserList;
    }

    private void fetchUsers() {
        api.getUsers(10).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                mUserList.postValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }
}
