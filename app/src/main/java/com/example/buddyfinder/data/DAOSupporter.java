package com.example.buddyfinder.data;

import com.example.buddyfinder.model.Supporter;

public class DAOSupporter {
    private static final DAOSupporter ourInstance = new DAOSupporter();
    private Supporter supporter;

    private DAOSupporter() {
    }

    public static DAOSupporter getInstance() {
        return ourInstance;
    }

    public Supporter getSupporter() {
        return supporter;
    }

    public void setSupporter(Supporter supporter) {
        this.supporter = supporter;
    }
}
