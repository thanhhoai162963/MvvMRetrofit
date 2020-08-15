package com.example.mvvmretrofit.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.view.View;
import android.widget.ProgressBar;

public abstract class BaseViewModel extends ViewModel implements LifecycleObserver {
    public Boolean isLoading = false;
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void setIsLoading(Boolean loading){
        isLoading = loading;
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void clear(){
        isLoading = null;

    }

}
