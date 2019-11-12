package com.geektech.quizapp_4_1.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.geektech.quizapp_4_1.R;
import com.geektech.quizapp_4_1.data.IQuizRepository;
import com.geektech.quizapp_4_1.data.QuizRepository;
import com.geektech.quizapp_4_1.history.HistoryFragment;
import com.geektech.quizapp_4_1.history.HistoryViewModel;
import com.geektech.quizapp_4_1.model.Question;
import com.geektech.quizapp_4_1.settings.SettingsFragment;
import com.geektech.quizapp_4_1.settings.SettingsViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;
    private MainPagerAdapter mAdapter;
    private BottomNavigationView mBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.main_view_pager);
        mBottomNav = findViewById(R.id.main_bottom_nav);

        mAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mBottomNav.setOnNavigationItemSelectedListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                int selectedItem = R.id.nav_main;

                switch (position) {
                    case 1:
                        selectedItem = R.id.nav_history;
                        break;
                    case 2:
                        selectedItem = R.id.nav_settings;
                        break;
                }

                mBottomNav.setSelectedItemId(selectedItem);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int page = 0;

        switch (menuItem.getItemId()) {
            case R.id.nav_history:
                page = 1;
                break;
            case R.id.nav_settings:
                page = 2;
                break;
        }

        mViewPager.setCurrentItem(page);
        return true;
    }

    private class MainPagerAdapter extends FragmentPagerAdapter {
        public MainPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public MainPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment;

            switch (position) {
                case 0:
                    fragment = new MainFragment();
                    break;

                case 1:
                    fragment = new HistoryFragment();
                    break;

                default:
                    fragment = new SettingsFragment();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
