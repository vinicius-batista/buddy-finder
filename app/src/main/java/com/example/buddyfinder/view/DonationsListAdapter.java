package com.example.buddyfinder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buddyfinder.R;
import com.example.buddyfinder.data.DAODonations;
import com.example.buddyfinder.model.Donation;

import java.util.ArrayList;

public class DonationsListAdapter extends RecyclerView.Adapter<DonationsListViewHolder> {
    private ArrayList<Donation> donationsList;
    private DonationsListAdapter.DonationsListener donationsListener;

    public DonationsListAdapter(DonationsListAdapter.DonationsListener donationsListener) {
        this.donationsList = DAODonations.getInstance().getOpenDonations();
        this.donationsListener = donationsListener;
    }

    public void refreshList() {
        this.donationsList = DAODonations.getInstance().getOpenDonations();
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DonationsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_donations_list, viewGroup, false);
        return new DonationsListViewHolder(view, this.donationsListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationsListViewHolder donationsListViewHolder, int i) {
        donationsListViewHolder.bind(this.donationsList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.donationsList.size();
    }

    public interface DonationsListener {
        void onClickDonationListener(Donation donation);
    }
}
