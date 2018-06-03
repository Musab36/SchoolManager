package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Assignments implements Parcelable {
    @SerializedName("student_id") Integer student_id;
    @SerializedName("student_name") String name;
    @SerializedName("class") String mClass;
    @SerializedName("subject") String subject;
    @SerializedName("instructions") String instructions;
    @SerializedName("remarks") String remarks;
    @SerializedName("score") String score;

    public Assignments() {}

    public Assignments(Integer student_id, String name, String mClass, String subject, String instructions, String remarks, String score) {
        this.student_id = student_id;
        this.name = name;
        this.mClass = mClass;
        this.subject = subject;
        this.instructions = instructions;
        this.remarks = remarks;
        this.score = score;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public String getmClass() {
        return mClass;
    }

    public String getSubject() {
        return subject;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getScore() {
        return score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.student_id);
        dest.writeString(this.name);
        dest.writeString(this.mClass);
        dest.writeString(this.subject);
        dest.writeString(this.instructions);
        dest.writeString(this.remarks);
        dest.writeString(this.score);
    }

    protected Assignments(Parcel in) {
        this.student_id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.mClass = in.readString();
        this.subject = in.readString();
        this.instructions = in.readString();
        this.remarks = in.readString();
        this.score = in.readString();
    }

    public static final Creator<Assignments> CREATOR = new Creator<Assignments>() {
        @Override
        public Assignments createFromParcel(Parcel source) {
            return new Assignments(source);
        }

        @Override
        public Assignments[] newArray(int size) {
            return new Assignments[size];
        }
    };

}
