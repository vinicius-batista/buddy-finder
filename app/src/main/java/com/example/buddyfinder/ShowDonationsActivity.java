package com.example.buddyfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.buddyfinder.model.Donation;
import com.example.buddyfinder.view.DonationsListAdapter;

public class ShowDonationsActivity extends AppCompatActivity implements DonationsListAdapter.DonationsListener {

    private RecyclerView rvDonationsList;
    private DonationsListAdapter donationsListAdapter;
    public static final String DONATION_KEY = "com.example.buddyfinder.ShowDonationsActivity.DONATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_donations);

        this.rvDonationsList = this.findViewById(R.id.rvDonationsList);
        this.rvDonationsList.setLayoutManager(new LinearLayoutManager(this));
        this.rvDonationsList.setHasFixedSize(true);

        this.donationsListAdapter = new DonationsListAdapter(this);
        this.rvDonationsList.setAdapter(this.donationsListAdapter);
    }

    @Override
    public void onClickDonationListener(Donation donation) {
        Intent intent = new Intent(this, DonationDetailsActivity.class);
        intent.putExtra(DONATION_KEY, donation);
        this.startActivity(intent);
    }
}
