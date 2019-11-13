package com.geektech.quizapp_4_1.presentation.history;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.View;

import com.geektech.quizapp_4_1.R;
import com.geektech.quizapp_4_1.core.CoreFragment;

public class HistoryFragment extends CoreFragment {

    private HistoryViewModel mViewModel;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
