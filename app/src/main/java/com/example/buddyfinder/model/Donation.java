package com.example.buddyfinder.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Donation implements Parcelable {
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
    private int id;
    private String kind;
    private String quantity;
    private String description;
    private String status;
    private ArrayList<SupporterDonation> supporterDonations;

    public Donation(String kind, String quantity, String description) {
        this.kind = kind;
        this.quantity = quantity;
        this.description = description;
        this.status = "open";
        this.supporterDonations = new ArrayList<>();
    }

    protected Donation(Parcel in) {
        this.id = in.readInt();
        this.kind = in.readString();
        this.quantity = in.readString();
        this.description = in.readString();
        this.status = in.readString();
        this.supporterDonations = in.readArrayList(SupporterDonation.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.kind);
        dest.writeString(this.quantity);
        dest.writeString(this.description);
        dest.writeString(this.status);
        dest.writeList(this.supporterDonations);
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SupporterDonation> getSupporterDonations() {
        return supporterDonations;
    }

    public void addSupporterDonation(SupporterDonation supporterDonations) {
        this.supporterDonations.add(supporterDonations);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Donation)) {
            return false;
        }
        return ((Donation) obj).getId() == this.getId();
    }
}
