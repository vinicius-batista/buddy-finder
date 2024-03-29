package com.example.buddyfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MemberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
    }

    public void onClickAddAnimal(View v) {
        Intent intent = new Intent(this, AddAnimalActivity.class);
        this.startActivity(intent);
    }

    public void onClickShowAnimals(View v) {
        Intent intent = new Intent(this, ShowAnimalsActivity.class);
        this.startActivity(intent);
    }

    public void onClickAddDonation(View v) {
        Intent intent = new Intent(this, AddDonationActivity.class);
        this.startActivity(intent);
    }

    public void onClickShowDonations(View v) {
        Intent intent = new Intent(this, ShowDonationsActivity.class);
        this.startActivity(intent);
    }
}
