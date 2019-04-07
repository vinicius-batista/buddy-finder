package com.example.buddyfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.buddyfinder.data.DAODonations;
import com.example.buddyfinder.model.Donation;

import java.util.ArrayList;

// TODO: add donors list
public class DonationDetailsActivity extends AppCompatActivity {

    private TextView txtKind;
    private TextView txtQuantity;
    private TextView txtDescription;
    private TextView txtStatus;
    private Donation donation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        this.txtKind = this.findViewById(R.id.txtKind);
        this.txtQuantity = this.findViewById(R.id.txtQuantity);
        this.txtDescription = this.findViewById(R.id.txtDescription);
        this.txtStatus = this.findViewById(R.id.txtStatus);

        this.donation = this.getIntent().getParcelableExtra(ShowDonationsActivity.DONATION_KEY);
        this.setTextViewsValues();
    }

    private void setTextViewsValues() {
        this.txtKind.setText(this.donation.getKind());
        this.txtDescription.setText(this.donation.getDescription());
        this.txtQuantity.setText(this.donation.getQuantity());
        this.txtStatus.setText(this.donation.getStatus());
    }

    public void onClickClose(View v) {
        ArrayList<Donation> donations = DAODonations.getInstance().getDonations();
        for (Donation donation: donations) {
            if(donation.equals(this.donation)) {
                donation.setStatus("closed");
            }
        }
        
        this.finish();
    }
}
