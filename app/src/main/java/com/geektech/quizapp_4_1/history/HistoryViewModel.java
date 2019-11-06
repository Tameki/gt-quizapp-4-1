package com.geektech.quizapp_4_1.history;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistoryViewModel extends ViewModel {

    public MutableLiveData<String> title = new MutableLiveData<>();

    public HistoryViewModel() {
        title.setValue("Asdasdasd");
        Log.d("ololo", "History viewmodel created");
    }

    public void onClearClick() {
        title.setValue("History cleared");
    }

}
