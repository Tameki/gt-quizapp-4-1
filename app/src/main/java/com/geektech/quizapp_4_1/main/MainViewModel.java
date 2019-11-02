package com.geektech.quizapp_4_1.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<String> title = new MutableLiveData<>();

    void init() {
        title.setValue("Main Activity Title");
        Log.d("ololo", "ViewModel init");
    }

    void changeTitle() {
        title.setValue("New title");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
