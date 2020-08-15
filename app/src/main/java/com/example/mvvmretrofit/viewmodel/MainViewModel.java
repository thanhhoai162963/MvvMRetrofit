package com.example.mvvmretrofit.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mvvmretrofit.module.ResponseAPI;
import com.example.mvvmretrofit.module.Word;
import com.example.mvvmretrofit.repository.WordRepository;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {
    private MutableLiveData<List<Word>> mWord = new MutableLiveData<>();
    private WordRepository wordRepository ;

    public LiveData<List<Word>> getData(){
        return mWord;
    }
    public void callAPI (Integer page, Integer numItems){
        wordRepository.getInstance()
                .getWordFromPage(page,numItems)
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseAPI>() {
                    @Override
                    public void accept(ResponseAPI responseAPI) throws Exception {
                        mWord.setValue(responseAPI.getData());
                    }
                });
    }
}
