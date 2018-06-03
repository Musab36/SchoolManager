package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleResponse implements Parcelable {
    @SerializedName("time_table")
    private List<Schedule> schedules;


    public List<Schedule> getSchedules() {
        return schedules;
    }

    public ScheduleResponse() {}

    protected ScheduleResponse(Parcel in) {
        schedules = in.createTypedArrayList(Schedule.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(schedules);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ScheduleResponse> CREATOR = new Creator<ScheduleResponse>() {
        @Override
        public ScheduleResponse createFromParcel(Parcel source) {
            return new ScheduleResponse(source);
        }

        @Override
        public ScheduleResponse[] newArray(int size) {
            return new ScheduleResponse[size];
        }
    };
}
