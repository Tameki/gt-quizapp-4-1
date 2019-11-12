package com.geektech.quizapp_4_1.data;

public class QuizRepository implements IQuizRepository {

    @Override
    public void getQuiz(OnQuizCallback callback) {
        callback.onFailure(new Exception("Remote data source not initialized"));
    }

}
