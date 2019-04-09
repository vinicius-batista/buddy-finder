package com.example.buddyfinder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buddyfinder.R;
import com.example.buddyfinder.model.SupporterDonation;

import java.util.ArrayList;

public class SupporterDonationsListAdapter extends RecyclerView.Adapter<SupporterDonationsListViewHolder> {
    private ArrayList<SupporterDonation> supporterDonationsList;
    private String quantity;

    public SupporterDonationsListAdapter (ArrayList<SupporterDonation> supporterDonations,  String quantity) {
        this.supporterDonationsList = supporterDonations;
        this.quantity = quantity;
    }

    @NonNull
    @Override
    public SupporterDonationsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_supporter_donations_list, viewGroup, false);
        return new SupporterDonationsListViewHolder(view, this.quantity);
    }

    @Override
    public void onBindViewHolder(@NonNull SupporterDonationsListViewHolder supporterDonationsListViewHolder, int i) {
        supporterDonationsListViewHolder.bind(this.supporterDonationsList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.supporterDonationsList.size();
    }
}
