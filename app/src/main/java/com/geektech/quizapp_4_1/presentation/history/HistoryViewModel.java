package com.geektech.quizapp_4_1.presentation.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_4_1.App;
import com.geektech.quizapp_4_1.model.ShortQuizResult;

import java.util.List;

public class HistoryViewModel extends ViewModel {

    LiveData<List<ShortQuizResult>> history = App.historyStorage.getAllShort();

    public HistoryViewModel() {

    }

}
