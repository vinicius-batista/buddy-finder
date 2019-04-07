package com.example.buddyfinder.data;

import com.example.buddyfinder.model.Donation;

import java.util.ArrayList;

public class DAODonations {
    private static final DAODonations ourInstance = new DAODonations();
    private ArrayList<Donation> donations;

    public static DAODonations getInstance() {
        return ourInstance;
    }

    private DAODonations() {
        this.donations = new ArrayList<>();
    }

    public ArrayList<Donation> getDonations() {
        return this.donations;
    }

    public void addDonation(Donation donation) {
        this.donations.add(donation);
    }
}
