package com.geektech.quizapp_4_1.presentation.quiz;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_4_1.App;
import com.geektech.quizapp_4_1.core.SingleLiveEvent;
import com.geektech.quizapp_4_1.data.IQuizRepository;
import com.geektech.quizapp_4_1.model.Question;

import java.util.List;

public class QuizViewModel extends ViewModel {

    private IQuizRepository quizRepository = App.quizRepository;
    private List<Question> mQuestions;

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

    SingleLiveEvent<Void> finishEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer> openResultEvent = new SingleLiveEvent<>();

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
        //TODO: Add answer position field to Question model and update on answer selected
    }

    void onSkipClick() {
        Integer currentPosition = currentQuestionPosition.getValue();
        if (currentPosition != null) {
            if (currentPosition == questions.getValue().size() - 1) {
                //TODO: Calculate result
                finishEvent.call();
            } else {
                mQuestions.set(currentPosition, mQuestions.get(currentPosition));
                questions.setValue(mQuestions);

                currentQuestionPosition.setValue(currentPosition + 1);
            }
        }
    }
}
