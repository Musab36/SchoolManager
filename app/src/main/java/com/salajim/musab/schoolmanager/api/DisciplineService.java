package com.salajim.musab.schoolmanager.api;

import com.salajim.musab.schoolmanager.models.DisciplineResponse;
import com.salajim.musab.schoolmanager.models.StudentsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DisciplineService {
    @GET("students")
    Call<StudentsResponse> getStudents(@Query("api_key") String apikey);

    @GET("students/{student_id}/discipline_record")
    Call<DisciplineResponse> getDiscipline(@Path("student_id") int id, @Query("api_key") String apiKey);
}
