package com.salajim.musab.schoolmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Students implements Parcelable {
    @SerializedName("id") Integer id;
    @SerializedName("name") String name;
    @SerializedName("type") String type;
    @SerializedName("parent") String parent;
    @SerializedName("admission_number") Integer admission_number;
    @SerializedName("class") String clas;
    @SerializedName("attendance") String attendence;


    public Students() {}

    public Students(Integer id, String name, String type, String parent, Integer admission_number, String clas, String attendence) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parent = parent;
        this.admission_number = admission_number;
        this.clas = clas;
        this.attendence = attendence;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getParent() {
        return parent;
    }

    public Integer getAdmission_number() {
        return admission_number;
    }

    public String getClas() {
        return clas;
    }

    public String getAttendence() {
        return attendence;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.parent);
        dest.writeValue(this.admission_number);
        dest.writeString(this.clas);
        dest.writeString(this.attendence);

    }

    protected Students(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.type = in.readString();
        this.parent = in.readString();
        this.admission_number = (Integer) in.readValue(Integer.class.getClassLoader());
        this.clas = in.readString();
        this.attendence = in.readString();




    }

    public static final Parcelable.Creator<Students> CREATOR = new Parcelable.Creator<Students>(){
        @Override
        public Students createFromParcel(Parcel source){
            return new Students(source);
        }
        @Override
        public Students[] newArray(int size) {
            return new Students[size];
        }
    };
}
