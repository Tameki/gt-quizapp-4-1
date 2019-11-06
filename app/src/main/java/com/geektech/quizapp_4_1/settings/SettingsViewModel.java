package com.geektech.quizapp_4_1.settings;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    public MutableLiveData<String> title = new MutableLiveData<>();

    public SettingsViewModel() {
        Log.d("ololo", "Settings viewmodel created");
    }

    public void onHistoryCleared() {
        title.setValue("Success");
    }

}
