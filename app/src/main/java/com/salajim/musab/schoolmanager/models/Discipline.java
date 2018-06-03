package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Discipline implements Parcelable {
    @SerializedName("student_id") Integer student_id;
    @SerializedName("student_name") String name;
    @SerializedName("offence") String offence;
    @SerializedName("punishment") String punishment;
    @SerializedName("teacher") String teacher;

    public Discipline() {}

    public Discipline(Integer student_id, String name, String offence, String punishment, String teacher) {
        this.student_id = student_id;
        this.name = name;
        this.offence = offence;
        this.punishment = punishment;
        this.teacher = teacher;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public String getOffence() {
        return offence;
    }

    public String getPunishment() {
        return punishment;
    }

    public String getTeacher() {
        return teacher;
    }

    protected Discipline(Parcel in) {
        student_id = (Integer) in.readValue(Integer.class.getClassLoader());
        name = in.readString();
        offence = in.readString();
        punishment = in.readString();
        teacher = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(student_id);
        dest.writeString(name);
        dest.writeString(offence);
        dest.writeString(punishment);
        dest.writeString(teacher);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Discipline> CREATOR = new Creator<Discipline>() {
        @Override
        public Discipline createFromParcel(Parcel source) {
            return new Discipline(source);
        }

        @Override
        public Discipline[] newArray(int size) {
            return new Discipline[size];
        }
    };

}
