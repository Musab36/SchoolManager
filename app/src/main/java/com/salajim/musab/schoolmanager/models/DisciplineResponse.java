package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DisciplineResponse implements Parcelable {
    @SerializedName("discipline_records")
    private List<Discipline> disciplines;

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public DisciplineResponse() {}

    protected DisciplineResponse(Parcel in) {
        disciplines = in.createTypedArrayList(Discipline.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(disciplines);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DisciplineResponse> CREATOR = new Creator<DisciplineResponse>() {
        @Override
        public DisciplineResponse createFromParcel(Parcel source) {
            return new DisciplineResponse(source);
        }

        @Override
        public DisciplineResponse[] newArray(int size) {
            return new DisciplineResponse[size];
        }
    };

}
