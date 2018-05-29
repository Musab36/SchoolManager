package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AttendanceResponse implements Parcelable {
    @SerializedName("attendance_records")
    private List<Attendance> attRecords;

    public List<Attendance> getAttendance() {
        return attRecords;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeTypedList(this.attRecords);


    }

    public AttendanceResponse() {}

    protected AttendanceResponse(Parcel in) {
        this.attRecords = in.createTypedArrayList(Attendance.CREATOR);
    }

    public static final Parcelable.Creator<AttendanceResponse> CREATOR = new Parcelable.Creator<AttendanceResponse>() {
        @Override
        public AttendanceResponse createFromParcel(Parcel source) {
            return new AttendanceResponse(source);
        }

        @Override
        public AttendanceResponse[] newArray(int size) {
            return new AttendanceResponse[size];
        }
    };

}
