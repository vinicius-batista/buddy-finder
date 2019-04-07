package com.example.buddyfinder.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Donation implements Parcelable {
    private String kind;
    private String quantity;
    private String description;
    private String status;

    public Donation(String kind, String quantity, String description) {
        this.kind = kind;
        this.quantity = quantity;
        this.description = description;
        this.status = "open";
    }

    protected Donation(Parcel in) {
        kind = in.readString();
        quantity = in.readString();
        description = in.readString();
        status = in.readString();
    }

    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
        @Override
        public Donation createFromParcel(Parcel in) {
            return new Donation(in);
        }

        @Override
        public Donation[] newArray(int size) {
            return new Donation[size];
        }
    };

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kind);
        dest.writeString(quantity);
        dest.writeString(description);
        dest.writeString(status);
    }
}
