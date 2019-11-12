package com.geektech.quizapp_4_1.result;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.geektech.quizapp_4_1.R;

public class ResultActivity extends AppCompatActivity {

    private ResultViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }
}
