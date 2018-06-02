package com.salajim.musab.schoolmanager.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.adapters.SectionsPagerAdapter;
import com.salajim.musab.schoolmanager.fragments.FriFragment;
import com.salajim.musab.schoolmanager.fragments.MonFragment;
import com.salajim.musab.schoolmanager.fragments.ThurFragment;
import com.salajim.musab.schoolmanager.fragments.TueFragment;
import com.salajim.musab.schoolmanager.fragments.WedFragment;

import butterknife.ButterKnife;

public class ScheduleDetailActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private SectionsPagerAdapter mAdapter;

    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);
        ButterKnife.bind(this);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Time Table");

        View tabs = findViewById(R.id.tabs);
        ViewCompat.setElevation(tabs, getResources().getDimension(R.dimen.action_bar_elevation));

        mAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MonFragment(), "MON");
        adapter.addFragment(new TueFragment(), "TUE");
        adapter.addFragment(new WedFragment(), "WED");
        adapter.addFragment(new ThurFragment(), "THUR");
        adapter.addFragment(new FriFragment(), "FRI");

        viewPager.setAdapter(adapter);
    }
}
