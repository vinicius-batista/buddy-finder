package com.example.buddyfinder.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Donation implements Parcelable {
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
        id = in.readInt();
        kind = in.readString();
        quantity = in.readString();
        description = in.readString();
        status = in.readString();
        supporterDonations = in.readArrayList(SupporterDonation.class.getClassLoader());
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(kind);
        dest.writeString(quantity);
        dest.writeString(description);
        dest.writeString(status);
        dest.writeList(supporterDonations);
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
            return  false;
        }
        return ((Donation) obj).getId() == this.getId();
    }
}
