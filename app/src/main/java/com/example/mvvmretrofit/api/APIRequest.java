package com.example.mvvmretrofit.api;

import com.example.mvvmretrofit.module.ResponseAPI;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequest {
    @GET("word.php")
    Flowable<ResponseAPI> getData(@Query("page") Integer page,
                                  @Query("numItems") Integer numItems);
}
