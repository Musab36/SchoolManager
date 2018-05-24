package com.salajim.musab.schoolmanager.models;

public class AttendenceRecord {
    private String studentId;
    private String name;
    private String status;
    private String day;
    private String date;

    public AttendenceRecord() {}

    public AttendenceRecord(String studentId, String name, String status, String day, String date) {
        this.studentId = studentId;
        this.name = name;
        this.status = status;
        this.day = day;
        this.date = date;
    }
    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDay() {
        return day;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDate() {
        return date;
    }

}
