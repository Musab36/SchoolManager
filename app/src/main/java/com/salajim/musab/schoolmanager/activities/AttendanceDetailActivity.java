package com.salajim.musab.schoolmanager.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.fragments.AbsentFragment;
import com.salajim.musab.schoolmanager.fragments.PresentFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AttendanceDetailActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.presentBtn)
    Button mPresentBtn;
    @Bind(R.id.absentBtn) Button mAbsentBtn;

    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_detail);
        ButterKnife.bind(this);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Attendance Records");

        mPresentBtn.setOnClickListener(this);
        mAbsentBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mPresentBtn) {
            mPresentBtn.setBackgroundColor(getResources().getColor(R.color.white));
            Fragment fragment;
            fragment = new PresentFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragments, fragment);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            mPresentBtn.setBackgroundColor(getResources().getColor(R.color.bg2));
        }
        if (v == mAbsentBtn) {
            mAbsentBtn.setBackgroundColor(getResources().getColor(R.color.white));
            Fragment fragment;
            fragment = new AbsentFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragments, fragment);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            mAbsentBtn.setBackgroundColor(getResources().getColor(R.color.bg2));
        }
    }

}
