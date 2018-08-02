package com.birjuvachhani.viewmodelwithretrofit;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.birjuvachhani.viewmodelwithretrofit.api.Result;
import com.birjuvachhani.viewmodelwithretrofit.databinding.UserBinding;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<Result> mUserList = new ArrayList<>();
    private UserBinding mBinding;

    public UserAdapter(ArrayList<Result> mUserList) {
        this.mUserList = mUserList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user, parent, false);
        return new UserViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(mUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public void setList(List<Result> results) {
        int pos = mUserList.size();
        mUserList.addAll(results);
        notifyItemInserted(pos);
    }

    class Comparator extends DiffUtil.Callback {

        @Override
        public int getOldListSize() {
            return mUserList.size();
        }

        @Override
        public int getNewListSize() {
            return 0;
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return false;
        }
    }
}
