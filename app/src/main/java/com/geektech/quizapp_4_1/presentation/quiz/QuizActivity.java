package com.geektech.quizapp_4_1.presentation.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.geektech.quizapp_4_1.R;

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

        getIntent().getIntExtra(EXTRA_AMOUNT, 5);

        mViewModel = ViewModelProviders.of(this)
                .get(QuizViewModel.class);
    }
}
