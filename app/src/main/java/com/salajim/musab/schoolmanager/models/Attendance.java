package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attendance implements Parcelable {
    @SerializedName("student_name") String name;
    @SerializedName("student_id") Integer student_id;
    @SerializedName("status") String status;
    @SerializedName("date") String date;
    @SerializedName("day") String day;

    public Attendance() {}

    public Attendance(String name, Integer student_id, String status,String date,String day) {
        this.name = name;
        this.student_id= student_id;
        this.status = status;
        this.date = date;
        this.day = day;

    }

    public Integer getId() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeValue(this.student_id);
        dest.writeString(this.status);
        dest.writeString(this.date);
        dest.writeString(this.day);



    }

    protected Attendance(Parcel in) {
        this.name = in.readString();
        this.student_id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.status = in.readString();
        this.date = in.readString();
        this.day = in.readString();


    }

    public static final Parcelable.Creator<Attendance> CREATOR = new Parcelable.Creator<Attendance>(){
        @Override
        public Attendance createFromParcel(Parcel source){
            return new Attendance(source);
        }
        @Override
        public Attendance[] newArray(int size) {
            return new Attendance[size];
        }
    };
}
