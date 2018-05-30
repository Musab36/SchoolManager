package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Grades implements Parcelable {
    @SerializedName("student_id") Integer student_id;
    @SerializedName("student_name") String name;
    @SerializedName("subject") String subject;
    @SerializedName("score") String score;
    @SerializedName("maximum_score") String maxScore;
    @SerializedName("percentage") String percent;

    public Grades() {}

    public Grades(Integer student_id, String name, String subject, String score, String maxScore, String percent) {
        this.student_id = student_id;
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.maxScore = maxScore;
        this.percent = percent;
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

    public String getScore() {
        return score;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public String getPercent() {
        return percent;
    }

    protected Grades(Parcel in) {
        this.student_id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.subject = in.readString();
        this.score = in.readString();
        this.maxScore = in.readString();
        this.percent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(student_id);
        dest.writeString(name);
        dest.writeString(subject);
        dest.writeString(score);
        dest.writeString(maxScore);
        dest.writeString(percent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Grades> CREATOR = new Creator<Grades>() {
        @Override
        public Grades createFromParcel(Parcel source) {
            return new Grades(source);
        }

        @Override
        public Grades[] newArray(int size) {
            return new Grades[size];
        }
    };
}
