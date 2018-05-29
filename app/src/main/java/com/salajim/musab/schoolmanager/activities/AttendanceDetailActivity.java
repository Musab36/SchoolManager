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
import com.salajim.musab.schoolmanager.adapters.AttendanceRecordsAdapter;
import com.salajim.musab.schoolmanager.api.Client;
import com.salajim.musab.schoolmanager.api.Service;
import com.salajim.musab.schoolmanager.models.Attendance;
import com.salajim.musab.schoolmanager.models.AttendanceResponse;
import com.salajim.musab.schoolmanager.models.Students;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceDetailActivity extends AppCompatActivity {
    private AttendanceRecordsAdapter mAdapter;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    int student_id;
    private List<Students> studentsLists;
    private List<Attendance> attRecords;
    private Students students;

    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_detail);
        ButterKnife.bind(this);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Attendance Records");

        attRecords = new ArrayList<>();
        studentsLists =new ArrayList<>();

        studentsLists = Parcels.unwrap(getIntent().getParcelableExtra("studentsLists"));
        int startingPosition = getIntent().getIntExtra("position", 0);
        students = studentsLists.get(startingPosition);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new AttendanceRecordsAdapter(this, attRecords);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        getData();
    }

    private void getData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        student_id = students.getId();


        try{
            if (BuildConfig.API_KEY.isEmpty()){
                Toast.makeText(this, "Please obtain your API Key from the Developers", Toast.LENGTH_SHORT).show();
                return;
            }
            Client Client = new Client();
            Service apiService = Client.getClient().create(Service.class);

            Call<AttendanceResponse> call = apiService.getAttendance(student_id, BuildConfig.API_KEY);

            call.enqueue(new Callback<AttendanceResponse>() {
                @Override
                public void onResponse(Call<AttendanceResponse> call, Response<AttendanceResponse> response) {
                    progressDialog.dismiss();
                    if (response == null) {
                        Toast.makeText(AttendanceDetailActivity.this, "No response from the Server", Toast.LENGTH_LONG).show();
                    }
                    List<Attendance> attRecords = response.body().getAttendance();

                    mAdapter = new AttendanceRecordsAdapter(getApplicationContext(), attRecords);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.smoothScrollToPosition(0);
                }

                @Override
                public void onFailure(Call<AttendanceResponse> call, Throwable t) {
                    Log.d("serverError", t.getMessage());
                    Toast.makeText(AttendanceDetailActivity.this, "Error fetching  data", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            });

        }catch (Exception e){
            Log.d("get Data Error", e.getMessage());
            Toast.makeText(AttendanceDetailActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
