package com.geektech.quizapp_4_1.presentation.quiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_4_1.R;
import com.geektech.quizapp_4_1.presentation.quiz.recycler.QuizAdapter;
import com.geektech.quizapp_4_1.presentation.quiz.recycler.QuizViewHolder;

public class QuizActivity extends AppCompatActivity
    implements QuizViewHolder.Listener {

    private QuizViewModel mViewModel;

    private QuizAdapter mAdapter;
    private RecyclerView mRecycler;

    private final static String EXTRA_AMOUNT = "amount";
    private final static String EXTRA_DIFFICULTY = "difficulty";

    public static void start(Context context, int amount, String difficulty) {
        Intent intent = new Intent(context, QuizActivity.class);
        intent.putExtra(EXTRA_AMOUNT, amount);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        mViewModel.onBackPressed();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initView();

        mViewModel = ViewModelProviders.of(this)
                .get(QuizViewModel.class);

        mViewModel.questions.observe(this, questions -> {
            Log.d("ololo", "Questions size " + questions.size());
            mAdapter.setQuestions(questions);

        });

        mViewModel.currentQuestionPosition.observe(this, position -> {
            Log.d("ololo", "Current position " + position);
        });

        mViewModel.finishEvent.observe(this, aVoid -> finish());

        mViewModel.openResultEvent.observe(this, aVoid -> {
            //TODO: Open Result activity
        });

        int amount = getIntent().getIntExtra(EXTRA_AMOUNT, 5);
        String difficulty = getIntent().getStringExtra(EXTRA_DIFFICULTY);
        mViewModel.init(amount, 0, difficulty);
    }

    private void initView() {
        mAdapter = new QuizAdapter(this);

        mRecycler = findViewById(R.id.quiz_recycler);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(
                this,
                RecyclerView.HORIZONTAL,
                false)
        );
        mRecycler.setOnTouchListener((v, event) -> true);

        findViewById(R.id.quiz_skip_question).setOnClickListener(v -> {
            mViewModel.onSkipClick();
        });
    }

    @Override
    public void onAnswerClick(int questionPosition, int answerPosition) {
        mViewModel.onAnswerClick(questionPosition, answerPosition);
    }
}
