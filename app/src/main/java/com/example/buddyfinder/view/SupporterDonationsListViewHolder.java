package com.example.buddyfinder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.buddyfinder.R;
import com.example.buddyfinder.model.SupporterDonation;

public class SupporterDonationsListViewHolder extends RecyclerView.ViewHolder {
    private TextView txtSupporterName;
    private TextView txtAmount;
    private String quantity;

    public SupporterDonationsListViewHolder(@NonNull View itemView, String quantity) {
        super(itemView);
        this.txtSupporterName = (TextView) itemView.findViewById(R.id.txtSupporterName);
        this.txtAmount = (TextView) itemView.findViewById(R.id.txtAmount);
        this.quantity = quantity;
    }

    public void bind(SupporterDonation supporterDonation) {
        this.txtSupporterName.setText(supporterDonation.getSupporter().getName());
        this.txtAmount.setText(supporterDonation.getAmount() + " " + this.quantity);
    }
}
