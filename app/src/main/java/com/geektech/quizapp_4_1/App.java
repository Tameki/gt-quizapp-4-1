package com.geektech.quizapp_4_1;

import android.app.Application;

import androidx.room.Room;

import com.geektech.quizapp_4_1.data.IQuizRepository;
import com.geektech.quizapp_4_1.data.QuizRepository;
import com.geektech.quizapp_4_1.data.db.QuizDatabase;
import com.geektech.quizapp_4_1.data.history.HistoryStorage;

public class App extends Application {

    public static IQuizRepository quizRepository;
    public static QuizDatabase quizDatabase;
    public static HistoryStorage historyStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        quizRepository = new QuizRepository();

        quizDatabase = Room.databaseBuilder(
                this,
                QuizDatabase.class,
                "quiz_db"
        ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        historyStorage = new HistoryStorage(quizDatabase.getHistoryDao());
    }

}
