package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GradesResponse implements Parcelable {
    @SerializedName("exam_results")
    private List<Grades> grades;

    public List<Grades> getGrades() {
        return grades;
    }

    public GradesResponse() {}

    protected GradesResponse(Parcel in) {
        grades = in.createTypedArrayList(Grades.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(grades);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GradesResponse> CREATOR = new Creator<GradesResponse>() {
        @Override
        public GradesResponse createFromParcel(Parcel source) {
            return new GradesResponse(source);
        }

        @Override
        public GradesResponse[] newArray(int size) {
            return new GradesResponse[size];
        }
    };

}
