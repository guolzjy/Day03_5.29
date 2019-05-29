package com.example.lenovo.day03_work.callback;

import com.example.lenovo.day03_work.entityclass.HomeList;

public interface CallBack {
    void onSuccess(HomeList homeList);
    void onCreate(String msg);
}
