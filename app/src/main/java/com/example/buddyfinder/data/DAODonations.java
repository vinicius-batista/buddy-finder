package com.example.buddyfinder.data;

import com.example.buddyfinder.model.Donation;

import java.util.ArrayList;

public class DAODonations {
    private static final DAODonations ourInstance = new DAODonations();
    private ArrayList<Donation> donations;
    private int counter;

    public static DAODonations getInstance() {
        return ourInstance;
    }

    private DAODonations() {
        this.donations = new ArrayList<>();
        this.counter = 0;
    }

    public ArrayList<Donation> getDonations() {
        return this.donations;
    }

    public void addDonation(Donation donation) {
        donation.setId(this.counter++);
        this.donations.add(donation);
    }

    public ArrayList<Donation> getOpenDonations() {
        ArrayList<Donation> openDonations = new ArrayList<>();

        for (Donation donation: this.donations) {
            if (donation.getStatus().equalsIgnoreCase("open")) {
                openDonations.add(donation);
            }
        }

        return openDonations;
    }
}
