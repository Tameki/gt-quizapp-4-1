package com.geektech.quizapp_4_1.data;

import com.geektech.quizapp_4_1.model.Question;

import java.util.List;

public interface IQuizRepository {
    void getQuiz(OnQuizCallback callback);

    interface OnQuizCallback {
        void onSuccess(List<Question> questions);

        void onFailure(Exception e);
    }
}
