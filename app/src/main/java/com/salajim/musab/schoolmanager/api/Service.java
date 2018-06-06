package com.salajim.musab.schoolmanager.api;

import com.salajim.musab.schoolmanager.models.AssignmentsResponse;
import com.salajim.musab.schoolmanager.models.AttendanceResponse;
import com.salajim.musab.schoolmanager.models.CoursesResponse;
import com.salajim.musab.schoolmanager.models.DisciplineResponse;
import com.salajim.musab.schoolmanager.models.GradesResponse;
import com.salajim.musab.schoolmanager.models.ScheduleResponse;
import com.salajim.musab.schoolmanager.models.StudentsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    /*Fetch all students*/
    @GET("students")
    Call<StudentsResponse> getStudents(@Query("api_key")String apiKey);

    /*Fetch specific student Attendance Records*/
    @GET("students/{student_id}/attendance_record")
    Call<AttendanceResponse> getAttendance(@Path("student_id") int id, @Query("api_key") String apiKey);

    /*Fetch specific student  assignments*/
    @GET("students/{student_id}/assignments")
    Call<AssignmentsResponse> getAssignments(@Path("student_id") int id, @Query("api_key") String apiKey);

    /*Fetch specific student timetable*/
    @GET("students/{student_id}/time_table")
    Call<ScheduleResponse> getSchedule(@Path("student_id") int id, @Query("api_key") String apiKey);

    /*Fetch specific student subjects*/
    @GET("students/{student_id}/subjects")
    Call<CoursesResponse> getCourses(@Path("student_id") int id, @Query("api_key") String apiKey);

    /*Fetch specific student Discipline Records*/
    @GET("students/{student_id}/discipline_record")
    Call<DisciplineResponse> getDiscipline(@Path("student_id") int id, @Query("api_key") String apiKey);

    /*Fetch specific student Exam Results*/
    @GET("students/{student_id}/exam_results")
    Call<GradesResponse> getGrades(@Path("student_id") int id, @Query("api_key") String apiKey);

}
