package com.salajim.musab.schoolmanager.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.salajim.musab.schoolmanager.BuildConfig;
import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.adapters.FriAdapter;
import com.salajim.musab.schoolmanager.api.Client;
import com.salajim.musab.schoolmanager.api.ScheduleService;
import com.salajim.musab.schoolmanager.models.Schedule;
import com.salajim.musab.schoolmanager.models.ScheduleResponse;
import com.salajim.musab.schoolmanager.models.Students;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriFragment extends Fragment {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private FriAdapter mAdapter;
    private List<Students> studentsLists;
    private List<Schedule> schedules;

    private Students students;
    int student_id;


    public FriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fri, container, false);
        ButterKnife.bind(this, view);

        studentsLists = new ArrayList<>();
        schedules = new ArrayList<>();

        studentsLists = Parcels.unwrap(getActivity().getIntent().getParcelableExtra("studentsLists"));
        int startingPosition = getActivity().getIntent().getIntExtra("position", 0);
        students = studentsLists.get(startingPosition);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new FriAdapter(getActivity(), schedules);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        getData();

        return view;
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        student_id = students.getId();

        try {
            if(BuildConfig.API_KEY.isEmpty()) {
                Toast.makeText(getActivity(), "Please obtain your API Key from the Developers", Toast.LENGTH_SHORT).show();
                return;
            }

            Client client = new Client();
            ScheduleService apiService = Client.getClient().create(ScheduleService.class);

            Call<ScheduleResponse> call = apiService.getSchedule(student_id, BuildConfig.API_KEY);

            call.enqueue(new Callback<ScheduleResponse>() {
                @Override
                public void onResponse(Call<ScheduleResponse> call, Response<ScheduleResponse> response) {
                    progressDialog.dismiss();

                    if (response == null) {
                        Toast.makeText(getActivity(), "No response from the Server", Toast.LENGTH_LONG).show();
                    }

                    List<Schedule> schedules = response.body().getSchedules();

                    mAdapter = new FriAdapter(getActivity(), schedules);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.smoothScrollToPosition(0);
                }

                @Override
                public void onFailure(Call<ScheduleResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.d("serverError", t.getMessage());
                    Toast.makeText(getActivity(), "Error fetching  data", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Log.d("get Data Error", e.getMessage());
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


}
