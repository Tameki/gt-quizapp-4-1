package com.geektech.quizapp_4_1.presentation.quiz;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_4_1.App;
import com.geektech.quizapp_4_1.core.SingleLiveEvent;
import com.geektech.quizapp_4_1.data.IQuizRepository;
import com.geektech.quizapp_4_1.data.history.HistoryStorage;
import com.geektech.quizapp_4_1.model.Question;
import com.geektech.quizapp_4_1.model.QuizResult;

import java.util.Date;
import java.util.List;

public class QuizViewModel extends ViewModel {

    private IQuizRepository quizRepository = App.quizRepository;
    private HistoryStorage historyStorage = App.historyStorage;
    private List<Question> mQuestions;

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

    SingleLiveEvent<Void> finishEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer> openResultEvent = new SingleLiveEvent<>();

    private int getCorrectAnswersAmount() {
        int correctAnswers = 0;

        for (Question question : mQuestions) {
            Integer selectedAnswerPosition = question.getSelectedAnswerPosition();

            if (selectedAnswerPosition != null &&
                    selectedAnswerPosition >= 0 &&
                    question.getAnswers().get(selectedAnswerPosition)
                            .equals(question.getCorrectAnswer())) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    private void finishQuiz() {
        QuizResult quizResult = new QuizResult(
                0,
                mQuestions,
                getCorrectAnswersAmount(),
                new Date()
        );

        int resultId = historyStorage.saveQuizResult(quizResult);

        finishEvent.call();
        openResultEvent.setValue(resultId);
    }

    void init(Integer amount, Integer categoryId, String difficulty) {
        currentQuestionPosition.setValue(0);

        quizRepository.getQuiz(new IQuizRepository.OnQuizCallback() {
            @Override
            public void onSuccess(List<Question> result) {
                mQuestions = result;
                questions.setValue(mQuestions);
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("ololo", "Error " + e.getMessage());
            }
        });
    }

    void onAnswerClick(int questionPosition, int answerPosition) {
        if (currentQuestionPosition.getValue() == null || mQuestions == null) {
            return;
        }

        Question question = mQuestions.get(questionPosition);

        question.setSelectedAnswerPosition(answerPosition);

        mQuestions.set(questionPosition, question);

        questions.setValue(mQuestions);

        if (questionPosition == mQuestions.size() - 1) {
            finishQuiz();
        } else {
            currentQuestionPosition.setValue(questionPosition + 1);
        }
    }

    void onBackPressed() {
        Integer currentPosition = currentQuestionPosition.getValue();
        if (currentPosition != null) {
            if (currentPosition == 0) {
                finishEvent.call();
            } else {
                currentQuestionPosition.setValue(currentPosition - 1);
            }
        }
    }

    void onSkipClick() {
        finishQuiz();
//        Integer currentPosition = currentQuestionPosition.getValue();
//        if (currentPosition != null) {
//            onAnswerClick(currentPosition, -1);
//        }
    }
}
