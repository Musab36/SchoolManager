package com.salajim.musab.schoolmanager.api;

import com.salajim.musab.schoolmanager.models.AssignmentsResponse;
import com.salajim.musab.schoolmanager.models.StudentsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AssignmentService {
    @GET("students")
    Call<StudentsResponse> getStudents(@Query("api_key") String apikey);

    @GET("students/{student_id}/assignments")
    Call<AssignmentsResponse> getAssignments(@Path("student_id") int id, @Query("api_key") String apiKey);
}
