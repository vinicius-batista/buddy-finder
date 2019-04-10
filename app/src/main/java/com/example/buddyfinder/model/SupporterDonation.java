package com.example.buddyfinder.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SupporterDonation implements Parcelable {
    public static final Creator<SupporterDonation> CREATOR = new Creator<SupporterDonation>() {
        @Override
        public SupporterDonation createFromParcel(Parcel in) {
            return new SupporterDonation(in);
        }

        @Override
        public SupporterDonation[] newArray(int size) {
            return new SupporterDonation[size];
        }
    };
    private String amount;
    private Supporter supporter;

    public SupporterDonation(String amount, Supporter supporter) {
        this.amount = amount;
        this.supporter = supporter;
    }

    protected SupporterDonation(Parcel in) {
        this.amount = in.readString();
        this.supporter = in.readParcelable(Supporter.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.amount);
        dest.writeParcelable(this.supporter, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Supporter getSupporter() {
        return supporter;
    }

    public void setSupporter(Supporter supporter) {
        this.supporter = supporter;
    }
}
