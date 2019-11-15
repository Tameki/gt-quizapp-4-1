package com.geektech.quizapp_4_1.presentation.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.geektech.quizapp_4_1.App;
import com.geektech.quizapp_4_1.R;
import com.geektech.quizapp_4_1.data.IQuizRepository;
import com.geektech.quizapp_4_1.model.Question;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private QuizViewModel mViewModel;

    private final static String EXTRA_AMOUNT = "amount";
    private final static String EXTRA_DIFFICULTY = "difficulty";

    public static void start(Context context, int amount, String difficulty) {
        Intent intent = new Intent(context, QuizActivity.class);
        intent.putExtra(EXTRA_AMOUNT, amount);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        int amount = getIntent().getIntExtra(EXTRA_AMOUNT, 5);
        String difficulty = getIntent().getStringExtra(EXTRA_DIFFICULTY);

        App.quizRepository.getQuiz(
                new IQuizRepository.OnQuizCallback() {
                    @Override
                    public void onSuccess(List<Question> questions) {
                        for (Question question : questions) {
                            Log.d("ololo", question.toString());
                        }
                    }

                    @Override
                    public void onFailure(Exception e) {
                        e.printStackTrace();
        //                Log.d("ololo", e.getMessage());
                    }
                });
    }
}
