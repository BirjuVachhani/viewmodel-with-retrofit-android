package com.birjuvachhani.viewmodelwithretrofit;

import android.support.v7.widget.RecyclerView;

import com.birjuvachhani.viewmodelwithretrofit.api.Result;
import com.birjuvachhani.viewmodelwithretrofit.databinding.UserBinding;

public class UserViewHolder extends RecyclerView.ViewHolder {

    UserBinding mBinding;

    public UserViewHolder(UserBinding mBinding) {
        super(mBinding.getRoot());
        this.mBinding = mBinding;
    }

    public void bind(Result result) {
        mBinding.setUser(result);
        mBinding.executePendingBindings();
    }
}
