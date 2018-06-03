package com.salajim.musab.schoolmanager.api;

import com.salajim.musab.schoolmanager.models.GradesResponse;
import com.salajim.musab.schoolmanager.models.StudentsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GradesService {
    @GET("students")
    Call<StudentsResponse> getStudents(@Query("api_key") String apikey);

    @GET("students/{student_id}/exam_results")
    Call<GradesResponse> getGrades(@Path("student_id") int id, @Query("api_key") String apiKey);
}
