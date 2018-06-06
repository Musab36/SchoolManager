package com.salajim.musab.schoolmanager.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.salajim.musab.schoolmanager.BuildConfig;
import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.adapters.CoursesDetailAdapter;
import com.salajim.musab.schoolmanager.api.Client;
import com.salajim.musab.schoolmanager.api.Service;
import com.salajim.musab.schoolmanager.models.Courses;
import com.salajim.musab.schoolmanager.models.CoursesResponse;
import com.salajim.musab.schoolmanager.models.Students;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoursesDetailActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private CoursesDetailAdapter mAdapter;
    private List<Students> studentsLists;
    private List<Courses> courses;

    private Students students;
    int student_id;

    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_detail);
        ButterKnife.bind(this);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Courses");

        studentsLists = new ArrayList<>();
        courses = new ArrayList<>();

        studentsLists = Parcels.unwrap(getIntent().getParcelableExtra("studentsLists"));
        int startingPosition = getIntent().getIntExtra("position", 0);
        students = studentsLists.get(startingPosition);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new CoursesDetailAdapter(this, courses);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        getData();
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        student_id = students.getId();

        try {
            if(BuildConfig.API_KEY.isEmpty()) {
                Toast.makeText(this, "Please obtain your API Key from the Developers", Toast.LENGTH_SHORT).show();
                return;
            }

            Client client = new Client();
            Service apiService = Client.getClient().create(Service.class);

            Call<CoursesResponse> call = apiService.getCourses(student_id, BuildConfig.API_KEY);

            call.enqueue(new Callback<CoursesResponse>() {
                @Override
                public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response) {
                    progressDialog.dismiss();

                    if (response == null) {
                        Toast.makeText(CoursesDetailActivity.this, "No response from the Server", Toast.LENGTH_LONG).show();
                    }

                    List<Courses> courses = response.body().getCourses();

                    mAdapter = new CoursesDetailAdapter(getApplicationContext(), courses);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.smoothScrollToPosition(0);
                }

                @Override
                public void onFailure(Call<CoursesResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.d("serverError", t.getMessage());
                    Toast.makeText(CoursesDetailActivity.this, "Error fetching  data", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Log.d("get Data Error", e.getMessage());
            Toast.makeText(CoursesDetailActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
