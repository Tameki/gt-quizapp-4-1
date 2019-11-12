package com.geektech.quizapp_4_1.main;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.geektech.quizapp_4_1.R;
import com.geektech.quizapp_4_1.core.CoreFragment;
import com.geektech.quizapp_4_1.quiz.QuizActivity;

import org.angmarch.views.NiceSpinner;

public class MainFragment extends CoreFragment {

    private MainViewModel mViewModel;

    private AppCompatSeekBar mSeekBar;
    private NiceSpinner mCategorySpinner;
    private NiceSpinner mDifficultySpinner;

    private TextView mAmount;
    private View mStart;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity())
                .get(MainViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSeekBar = view.findViewById(R.id.main_amount_seek_bar);
        mCategorySpinner = view.findViewById(R.id.main_category_spinner);
        mDifficultySpinner = view.findViewById(R.id.main_difficulty_spinner);
        mAmount = view.findViewById(R.id.main_questions_amount);
        mStart = view.findViewById(R.id.main_start);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAmount.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.start(
                        getContext(),
                        mSeekBar.getProgress(),
                        mCategorySpinner.getSelectedItem().toString()
                );

                Log.d("ololo", "Start properties - amount:" + mSeekBar.getProgress()
                        + " category: " + mCategorySpinner.getSelectedIndex()
                        + " difficulty: " + mDifficultySpinner.getSelectedIndex());
            }
        });
    }

}
