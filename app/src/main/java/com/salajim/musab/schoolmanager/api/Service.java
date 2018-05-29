package com.salajim.musab.schoolmanager.api;

import com.salajim.musab.schoolmanager.models.AttendanceResponse;
import com.salajim.musab.schoolmanager.models.StudentsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {
    @GET("students")
    Call<StudentsResponse> getStudents(@Query("api_key")String apiKey);

    @GET("students/{student_id}/attendance_record")
    Call<AttendanceResponse> getAttendance(@Path("student_id") int id, @Query("api_key") String apiKey);

}
