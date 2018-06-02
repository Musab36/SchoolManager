package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Schedule implements Parcelable {
    @SerializedName("subject") String subject;
    @SerializedName("teacher") String teacher;
    @SerializedName("start_time") String start_time;
    @SerializedName("end_time") String end_time;
    @SerializedName("day") String day;
    @SerializedName("current") String current;
    @SerializedName("taken") String taken;
    @SerializedName("notes") String notes;
    @SerializedName("student_id") Integer student_id;
    @SerializedName("student_name") String name;

    public Schedule() {}

    public Schedule(String subject, String teacher, String start_time, String end_time, String day, String current, String taken, String notes,
                    Integer student_id, String name) {
        this.subject = subject;
        this.teacher = teacher;
        this.start_time = start_time;
        this.end_time = end_time;
        this.day = day;
        this.current = current;
        this.taken = taken;
        this.notes = notes;
        this.student_id = student_id;
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getDay() {
        return day;
    }

    public String getCurrent() {
        return current;
    }

    public String getTaken() {
        return taken;
    }

    public String getNotes() {
        return notes;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    protected Schedule(Parcel in) {
        subject = in.readString();
        teacher = in.readString();
        start_time = in.readString();
        end_time = in.readString();
        day = in.readString();
        current = in.readString();
        taken = in.readString();
        notes = in.readString();
        this.student_id = (Integer) in.readValue(Integer.class.getClassLoader());
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(subject);
        dest.writeString(teacher);
        dest.writeString(start_time);
        dest.writeString(end_time);
        dest.writeString(day);
        dest.writeString(current);
        dest.writeString(taken);
        dest.writeString(notes);
        dest.writeValue(student_id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Schedule> CREATOR = new Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel source) {
            return new Schedule(source);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };
}
