package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Courses implements Parcelable{
    @SerializedName("student_id") Integer student_id;
    @SerializedName("student_name") String name;
    @SerializedName("subject") String subject;
    @SerializedName("type") String type;
    @SerializedName("teacher") String teacher;

    public Courses() {}

    public Courses(Integer student_id, String name, String subject, String type, String teacher) {
        this.student_id = student_id;
        this.name = name;
        this.subject = subject;
        this.type = type;
        this.teacher = teacher;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getType() {
        return type;
    }

    public String getTeacher() {
        return teacher;
    }

    protected Courses(Parcel in) {
        student_id = (Integer) in.readValue(Integer.class.getClassLoader());
        name = in.readString();
        subject = in.readString();
        type = in.readString();
        teacher = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(student_id);
        dest.writeString(name);
        dest.writeString(subject);
        dest.writeString(type);
        dest.writeString(teacher);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Courses> CREATOR = new Creator<Courses>() {
        @Override
        public Courses createFromParcel(Parcel source) {
            return new Courses(source);
        }

        @Override
        public Courses[] newArray(int size) {
            return new Courses[size];
        }
    };

}
