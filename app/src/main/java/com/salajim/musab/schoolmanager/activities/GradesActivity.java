package com.salajim.musab.schoolmanager.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.salajim.musab.schoolmanager.BuildConfig;
import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.adapters.GradesAdapter;
import com.salajim.musab.schoolmanager.api.Client;
import com.salajim.musab.schoolmanager.api.Service;
import com.salajim.musab.schoolmanager.models.Students;
import com.salajim.musab.schoolmanager.models.StudentsResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GradesActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.selectStudent)
    TextView selectStudent;

    private List<Students> studentsLists;
    private GradesAdapter mAdapter;

    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        ButterKnife.bind(this);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Students");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentsLists = new ArrayList<>();
        mAdapter = new GradesAdapter(this, studentsLists);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        getData();

    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        try {
            if(BuildConfig.API_KEY.isEmpty()) {
                Toast.makeText(this, "Please obtain your API Key from the Developers", Toast.LENGTH_SHORT).show();
                return;
            }

            Client client = new Client();
            Service apiService = Client.getClient().create(Service.class);
            Call<StudentsResponse> call = apiService.getStudents(BuildConfig.API_KEY);

            call.enqueue(new Callback<StudentsResponse>() {
                @Override
                public void onResponse(Call<StudentsResponse> call, Response<StudentsResponse> response) {
                    progressDialog.dismiss();

                    if(response == null) {
                        Toast.makeText(GradesActivity.this, "No response from the Server", Toast.LENGTH_LONG).show();
                        selectStudent.setVisibility(View.GONE);
                    }

                    List<Students> studentsLists = response.body().getStudents();

                    mAdapter = new GradesAdapter(getApplicationContext(), studentsLists);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.smoothScrollToPosition(0);
                }

                @Override
                public void onFailure(Call<StudentsResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.d("serverError", t.getMessage());
                    Toast.makeText(GradesActivity.this, "Error fetching  data", Toast.LENGTH_SHORT).show();
                    selectStudent.setVisibility(View.GONE);

                }
            });
        } catch (Exception e) {
            Log.d("get Data Error", e.getMessage());
            Toast.makeText(GradesActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
