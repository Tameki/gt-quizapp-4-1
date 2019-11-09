package com.geektech.quizapp_4_1.data;

import java.util.ArrayList;
import java.util.List;

public class QuizRepository implements IQuizRepository {

    @Override
    public void getQuiz(OnQuizCallback callback) {
        callback.onFailure(new Exception("Remote data source not initialized"));
    }

}
