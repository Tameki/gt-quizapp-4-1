package com.geektech.quizapp_4_1;

import android.app.Application;

import com.geektech.quizapp_4_1.data.IQuizRepository;
import com.geektech.quizapp_4_1.data.QuizRepository;

public class App extends Application {

    public static IQuizRepository quizRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        quizRepository = new QuizRepository();
    }

}
