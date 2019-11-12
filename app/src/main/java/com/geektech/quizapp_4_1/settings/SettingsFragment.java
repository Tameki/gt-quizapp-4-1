package com.geektech.quizapp_4_1.settings;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;

import android.util.Log;

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
        mViewModel = ViewModelProviders.of(getActivity()).get(SettingsViewModel.class);

        mViewModel.title.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("ololo", "Settings fragment " + s);
            }
        });
    }

}
