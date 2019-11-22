package com.geektech.quizapp_4_1.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geektech.quizapp_4_1.data.history.HistoryDao;
import com.geektech.quizapp_4_1.model.QuizResult;

@Database(
        entities = {QuizResult.class},
        version = 1,
        exportSchema = false
)
abstract public class QuizDatabase extends RoomDatabase {
    public abstract HistoryDao getHistoryDao();
}
