package com.birjuvachhani.viewmodelwithretrofit;

import android.support.v7.widget.RecyclerView;

import com.birjuvachhani.viewmodelwithretrofit.api.Result;
import com.birjuvachhani.viewmodelwithretrofit.databinding.UserBinding;
import com.squareup.picasso.Picasso;

public class UserViewHolder extends RecyclerView.ViewHolder {

    UserBinding mBinding;

    public UserViewHolder(UserBinding mBinding) {
        super(mBinding.getRoot());
        this.mBinding = mBinding;
    }

    public void bind(Result result) {
        mBinding.tvUserName.setText(result.getName().getFirst() + " " + result.getName().getLast());
        Picasso.get().load(result.getPicture().getMedium()).fit().into(mBinding.ivUserImage);
    }
}
