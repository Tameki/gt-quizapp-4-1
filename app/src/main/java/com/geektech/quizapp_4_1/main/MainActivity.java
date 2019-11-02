package com.geektech.quizapp_4_1.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.geektech.quizapp_4_1.R;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = findViewById(R.id.mainText);

        mViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);
        mViewModel.init();

        mViewModel.title.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv.setText(s);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewModel.changeTitle();
            }
        },  2000);

        Log.d("ololo", "TextView context is " + tv.getContext().toString());
    }
}
