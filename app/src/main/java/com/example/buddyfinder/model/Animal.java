package com.example.buddyfinder.model;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Animal {
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
}
