package com.example.mvvmretrofit.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {
    private static RetrofitInit retrofitInit = null;
    private Retrofit retrofit;

    public RetrofitInit() {
        retrofit = initRetrofit();
    }

    public static APIRequest getInstance(){
        if(retrofitInit == null){
            retrofitInit = new RetrofitInit();
        }
        return retrofitInit.retrofit.create(APIRequest.class);
    }
    public Retrofit initRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(20,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        Gson gson = new GsonBuilder().setLenient().disableHtmlEscaping().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://servertuvung30032020.000webhostapp.com/apituvung/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
