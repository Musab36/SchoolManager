package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AssignmentsResponse implements Parcelable {
    @SerializedName("assignments")
    private List<Assignments> assignments;

    public List<Assignments> getAssignments() {
        return assignments;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.assignments);
    }

    public AssignmentsResponse() {}

    protected AssignmentsResponse(Parcel in) {
        this.assignments = in.createTypedArrayList(Assignments.CREATOR);
    }

    public static final Creator<AssignmentsResponse> CREATOR = new Creator<AssignmentsResponse>() {
        @Override
        public AssignmentsResponse createFromParcel(Parcel source) {
            return new AssignmentsResponse(source);
        }

        @Override
        public AssignmentsResponse[] newArray(int size) {
            return new AssignmentsResponse[size];
        }
    };
}
