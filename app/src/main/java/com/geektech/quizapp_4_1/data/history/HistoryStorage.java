package com.geektech.quizapp_4_1.data.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.geektech.quizapp_4_1.model.QuizResult;
import com.geektech.quizapp_4_1.model.ShortQuizResult;

import java.util.ArrayList;
import java.util.List;

public class HistoryStorage {
    private HistoryDao dao;

    public HistoryStorage(HistoryDao dao) {
        this.dao = dao;
    }

    public QuizResult getQuizResult(int id) {
        return dao.get(id);
    }

    public int saveQuizResult(QuizResult quizResult) {
        return (int) dao.insert(quizResult);
    }

    public LiveData<List<QuizResult>> getAll() {
        return dao.getAll();
    }

    public LiveData<List<ShortQuizResult>> getAllShort() {

        return Transformations.map(getAll(), quizResults -> {
            ArrayList<ShortQuizResult> shortQuizResults = new ArrayList<>();

            for (QuizResult quizResult : quizResults) {
                String category = quizResult.getQuestions().get(0).getCategory();

                shortQuizResults.add(new ShortQuizResult(
                    quizResult.getId(),
                    quizResult.getQuestions().size(),
                    quizResult.getCorrectAnswers(),
                    quizResult.getCreatedAt()
                ));
            }

            return shortQuizResults;
        });
    }
}
