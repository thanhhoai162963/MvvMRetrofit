package com.example.mvvmretrofit.repository;

import com.example.mvvmretrofit.api.APIRequest;
import com.example.mvvmretrofit.api.RetrofitInit;

public class WordRepository {
    public WordRepository wordRepository = null;
    private APIRequest apiRequest;

    public WordRepository() {
        this.apiRequest = RetrofitInit.getInstance();
    }
    public WordRepository getInstance(){
        if(wordRepository ==  null){
            wordRepository = new WordRepository();
        }
        return wordRepository;
    }
}
