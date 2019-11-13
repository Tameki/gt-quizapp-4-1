package com.geektech.quizapp_4_1.presentation.settings;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.geektech.quizapp_4_1.R;
import com.geektech.quizapp_4_1.core.CoreFragment;

public class SettingsFragment extends CoreFragment {

    private SettingsViewModel mViewModel;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
    }

}
