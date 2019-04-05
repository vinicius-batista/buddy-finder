package com.example.buddyfinder.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Animal implements Parcelable {
    private String specie;
    private String entryDate;
    private String age;
    private String lifePhase;
    private String characteristics;
    private String status;
    private ArrayList<Bitmap> pictures;

    public Animal(String specie, String entryDate, String age, String lifePhase, String characteristics, ArrayList<Bitmap> pictures) {
        this.specie = specie;
        this.entryDate = entryDate;
        this.age = age;
        this.lifePhase = lifePhase;
        this.characteristics = characteristics;
        this.status = "available";
        this.pictures = pictures;
    }

    protected Animal(Parcel in) {
        this.specie = in.readString();
        this.entryDate = in.readString();
        this.age = in.readString();
        this.lifePhase = in.readString();
        this.characteristics = in.readString();
        this.status = in.readString();
        this.pictures = in.createTypedArrayList(Bitmap.CREATOR);
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLifePhase() {
        return lifePhase;
    }

    public void setLifePhase(String lifePhase) {
        this.lifePhase = lifePhase;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Bitmap> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<Bitmap> pictures) {
        this.pictures = pictures;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.specie);
        dest.writeString(this.entryDate);
        dest.writeString(this.age);
        dest.writeString(this.lifePhase);
        dest.writeString(this.characteristics);
        dest.writeString(this.status);
        dest.writeTypedList(this.pictures);
    }
}
