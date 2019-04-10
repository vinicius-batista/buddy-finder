package com.example.buddyfinder.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Animal implements Parcelable {
    private int id;
    private String specie;
    private String entryDate;
    private String age;
    private String lifePhase;
    private String characteristics;
    private String status;
    private ArrayList<Bitmap> pictures;
    private Supporter owner;
    private ArrayList<Supporter> interesedAdopting;

    public Animal(String specie, String entryDate, String age, String lifePhase, String characteristics, ArrayList<Bitmap> pictures) {
        this.specie = specie;
        this.entryDate = entryDate;
        this.age = age;
        this.lifePhase = lifePhase;
        this.characteristics = characteristics;
        this.status = "available";
        this.pictures = pictures;
        this.interesedAdopting = new ArrayList<>();
    }

    protected Animal(Parcel in) {
        this.id = in.readInt();
        this.specie = in.readString();
        this.entryDate = in.readString();
        this.age = in.readString();
        this.lifePhase = in.readString();
        this.characteristics = in.readString();
        this.status = in.readString();
        this.pictures = in.createTypedArrayList(Bitmap.CREATOR);
        this.owner = in.readParcelable(Supporter.class.getClassLoader());
        this.interesedAdopting = in.readArrayList(Supporter.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.specie);
        dest.writeString(this.entryDate);
        dest.writeString(this.age);
        dest.writeString(this.lifePhase);
        dest.writeString(this.characteristics);
        dest.writeString(this.status);
        dest.writeTypedList(this.pictures);
        dest.writeParcelable(this.owner, flags);
        dest.writeList(this.interesedAdopting);
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

    public Supporter getOwner() {
        return owner;
    }

    public void setOwner(Supporter owner) {
        this.owner = owner;
    }

    public ArrayList<Supporter> getInteresedAdopting() {
        return interesedAdopting;
    }

    public void addInteresedAdopting(Supporter supporter) {
        this.interesedAdopting.add(supporter);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Animal)) {
            return  false;
        }
        return ((Animal) obj).getId() == this.getId();
    }
}
