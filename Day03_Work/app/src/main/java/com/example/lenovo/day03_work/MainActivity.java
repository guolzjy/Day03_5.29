package com.example.lenovo.day03_work;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.day03_work.adapter.RvAdapter;
import com.example.lenovo.day03_work.entityclass.HomeList;
import com.example.lenovo.day03_work.model.MyModelImpl;
import com.example.lenovo.day03_work.persenter.MyPersenterImpl;
import com.example.lenovo.day03_work.view.MyView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyView {
//郭正昊 1810A
    private RecyclerView mRvLayout;
    private ArrayList<HomeList.DataBean.DatasBean> list;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMvp();
    }

    private void initMvp() {
        MyPersenterImpl myPersenter = new MyPersenterImpl(new MyModelImpl(), this);
        myPersenter.getDate();
    }

    private void initView() {
        mRvLayout = (RecyclerView) findViewById(R.id.rv_layout);

        LinearLayoutManager ll = new LinearLayoutManager(this);
        mRvLayout.setLayoutManager(ll);

        list = new ArrayList<>();
        adapter = new RvAdapter(this, list);
        mRvLayout.setAdapter(adapter);
    }

    @Override
    public void onSuccess(HomeList homeList) {
        list.addAll(homeList.getData().getDatas());
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(String msg) {

    }
}
