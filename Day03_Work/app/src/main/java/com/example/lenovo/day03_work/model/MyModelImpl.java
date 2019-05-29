package com.example.lenovo.day03_work.model;

import com.example.lenovo.day03_work.api.MyServer;
import com.example.lenovo.day03_work.callback.CallBack;
import com.example.lenovo.day03_work.entityclass.HomeList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModelImpl implements MyModel {
    @Override
    public void getDate(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        final Observable<HomeList> home = myServer.getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeList homeList) {
                        if (callBack != null){
                            callBack.onSuccess(homeList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onCreate(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
