package com.example.mvvmretrofit.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequest {
    @GET("word.php")
    Call<Object> getData(
            @Query("page") Integer page,
            @Query("numItems") String numItems);
}
