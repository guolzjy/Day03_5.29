package com.example.lenovo.day03_work.api;

import com.example.lenovo.day03_work.entityclass.HomeList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    public String url = " http://www.wanandroid.com/";
    @GET("article/list/0/json")
    Observable<HomeList> getHome();
}
