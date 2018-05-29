package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentsResponse implements Parcelable {
    @SerializedName("students")
    private List<Students> students;

    public List<Students> getStudents() {
        return students;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeTypedList(this.students);


    }

    public StudentsResponse() {}

    protected StudentsResponse(Parcel in) {
        this.students = in.createTypedArrayList(Students.CREATOR);
    }

    public static final Parcelable.Creator<StudentsResponse> CREATOR = new Parcelable.Creator<StudentsResponse>() {
        @Override
        public StudentsResponse createFromParcel(Parcel source) {
            return new StudentsResponse(source);
        }

        @Override
        public StudentsResponse[] newArray(int size) {
            return new StudentsResponse[size];
        }
    };
}
