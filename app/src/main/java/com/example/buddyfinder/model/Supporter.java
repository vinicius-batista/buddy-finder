package com.example.buddyfinder.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Supporter implements Parcelable {
    public static final Creator<Supporter> CREATOR = new Creator<Supporter>() {
        @Override
        public Supporter createFromParcel(Parcel in) {
            return new Supporter(in);
        }

        @Override
        public Supporter[] newArray(int size) {
            return new Supporter[size];
        }
    };
    private String name;
    private String phone;

    public Supporter(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    protected Supporter(Parcel in) {
        this.name = in.readString();
        this.phone = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
