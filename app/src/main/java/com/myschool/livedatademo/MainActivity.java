package com.myschool.livedatademo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.myschool.livedatademo.adapter.RecyclerViewAdapter;
import com.myschool.livedatademo.database.BorrowerModel;
import com.myschool.livedatademo.viewModels.BorrowedListViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    BorrowedListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        adapter = new RecyclerViewAdapter(new ArrayList<BorrowerModel>(),this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(BorrowedListViewModel.class);

        viewModel.getGetAllPersonalList().observe(MainActivity.this, new Observer<List<BorrowerModel>>() {
            @Override
            public void onChanged(@Nullable List<BorrowerModel> models) {

                adapter.addItems(models);
            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
        BorrowerModel borrowModel = (BorrowerModel) view.getTag();
        viewModel.deleteItems(borrowModel);
        return true;    }
}
