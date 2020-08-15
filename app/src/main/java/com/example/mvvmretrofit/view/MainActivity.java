package com.example.mvvmretrofit.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mvvmretrofit.R;
import com.example.mvvmretrofit.module.Word;
import com.example.mvvmretrofit.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getData().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                Log.d("bbb",words.size()+"");
            }
        });
        mainViewModel.callAPI(1,2);
    }
}