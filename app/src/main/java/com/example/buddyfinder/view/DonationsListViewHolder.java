package com.example.buddyfinder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.buddyfinder.R;
import com.example.buddyfinder.model.Donation;

public class DonationsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView txtKind;
    private TextView txtQuantity;
    private DonationsListAdapter.DonationsListener listener;
    private Donation donation;

    public DonationsListViewHolder(@NonNull View itemView, DonationsListAdapter.DonationsListener listener) {
        super(itemView);
        this.txtKind = (TextView) itemView.findViewById(R.id.txtKind);
        this.txtQuantity = (TextView) itemView.findViewById(R.id.txtQuantity);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bind(Donation donation) {
        this.txtKind.setText(donation.getKind());
        this.txtQuantity.setText(donation.getQuantity());
        this.donation = donation;
    }

    @Override
    public void onClick(View v) {
        this.listener.onClickDonationListener(this.donation);
    }
}
