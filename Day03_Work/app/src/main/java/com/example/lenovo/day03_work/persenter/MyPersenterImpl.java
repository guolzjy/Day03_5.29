package com.example.lenovo.day03_work.persenter;

import com.example.lenovo.day03_work.callback.CallBack;
import com.example.lenovo.day03_work.entityclass.HomeList;
import com.example.lenovo.day03_work.model.MyModel;
import com.example.lenovo.day03_work.view.MyView;

public class MyPersenterImpl implements MyPersenter,CallBack {
    private MyModel myModel;
    private MyView myView;

    public MyPersenterImpl(MyModel myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void onSuccess(HomeList homeList) {
        if (myModel != null){
            myView.onSuccess(homeList);
        }
    }

    @Override
    public void onCreate(String msg) {
        if (myModel != null){
            myView.onCreate(msg);
        }
    }

    @Override
    public void getDate() {
        myModel.getDate(this);
    }
}
