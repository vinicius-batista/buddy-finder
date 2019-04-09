package com.example.buddyfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.buddyfinder.data.DAODonations;
import com.example.buddyfinder.data.DAOSupporter;
import com.example.buddyfinder.model.Donation;
import com.example.buddyfinder.model.Supporter;
import com.example.buddyfinder.model.SupporterDonation;

import java.util.ArrayList;

// TODO: add donors list
public class DonationDetailsActivity extends AppCompatActivity {

    private TextView txtKind;
    private TextView txtQuantity;
    private TextView txtDescription;
    private TextView txtStatus;
    private EditText ptxtAmount;
    private Donation donation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        this.createTextViews();
        this.donation = this.getIntent().getParcelableExtra(ShowDonationsActivity.DONATION_KEY);
        this.setTextViewsValues();

        if (DAOSupporter.getInstance().getSupporter() != null) {
            Button btnCloseDonation = this.findViewById(R.id.btnCloseDonation);
            btnCloseDonation.setVisibility(Button.INVISIBLE);

            LinearLayout llDonate = this.findViewById(R.id.llDonate);
            llDonate.setVisibility(LinearLayout.VISIBLE);
        }
    }

    private void createTextViews() {
        this.txtKind = this.findViewById(R.id.txtKind);
        this.txtQuantity = this.findViewById(R.id.txtQuantity);
        this.txtDescription = this.findViewById(R.id.txtDescription);
        this.txtStatus = this.findViewById(R.id.txtStatus);
        this.ptxtAmount = this.findViewById(R.id.ptxtAmount);
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

    public void onClickDonate(View v) {
        String amount = this.ptxtAmount.getText().toString();
        Supporter supporter = DAOSupporter.getInstance().getSupporter();
        SupporterDonation supporterDonation = new SupporterDonation(amount, supporter);

        ArrayList<Donation> donations = DAODonations.getInstance().getDonations();
        for (Donation donation: donations) {
            if(donation.equals(this.donation)) {
               donation.addSupporterDonation(supporterDonation);
            }
        }

        this.finish();
    }
}
