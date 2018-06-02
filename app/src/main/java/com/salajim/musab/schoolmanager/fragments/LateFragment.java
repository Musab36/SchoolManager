package com.salajim.musab.schoolmanager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salajim.musab.schoolmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LateFragment extends Fragment {


    public LateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_late, container, false);
    }

}
