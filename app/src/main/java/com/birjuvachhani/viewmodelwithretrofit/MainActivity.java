package com.birjuvachhani.viewmodelwithretrofit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.birjuvachhani.viewmodelwithretrofit.api.Result;
import com.birjuvachhani.viewmodelwithretrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private UserAdapter adapter;
    private RandomUserViewModel model;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.rvUserList.setHasFixedSize(true);
        mBinding.rvUserList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mBinding.rvUserList.setLayoutManager(layoutManager);
        mBinding.rvUserList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new UserAdapter(new ArrayList<Result>());
        mBinding.rvUserList.setAdapter(adapter);

        model = ViewModelProviders.of(this).get(RandomUserViewModel.class);
        loadData();
        mBinding.rvUserList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    model.getNextPage();
                }
            }
        });
    }

    private void loadData() {
        model.getUsers().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(@Nullable List<Result> results) {
                adapter.setList(results);
            }
        });
    }
}
