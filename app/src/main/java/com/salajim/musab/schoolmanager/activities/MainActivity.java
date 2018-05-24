package com.salajim.musab.schoolmanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.salajim.musab.schoolmanager.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.attendence)
    TextView mAttendence;

    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.main_bar);

        mAttendence.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mAttendence) {
            Intent intent = new Intent(MainActivity.this, AttendenceActivity.class);
            startActivity(intent);
        }
    }
}
