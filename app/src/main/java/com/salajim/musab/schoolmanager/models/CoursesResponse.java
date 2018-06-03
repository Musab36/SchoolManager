package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoursesResponse implements Parcelable {
    @SerializedName("subjects")
    private List<Courses> courses;

    public List<Courses> getCourses() {
        return courses;
    }

    public CoursesResponse() {}

    protected CoursesResponse(Parcel in) {
        courses = in.createTypedArrayList(Courses.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(courses);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CoursesResponse> CREATOR = new Creator<CoursesResponse>() {
        @Override
        public CoursesResponse createFromParcel(Parcel source) {
            return new CoursesResponse(source);
        }

        @Override
        public CoursesResponse[] newArray(int size) {
            return new CoursesResponse[size];
        }
    };

}
