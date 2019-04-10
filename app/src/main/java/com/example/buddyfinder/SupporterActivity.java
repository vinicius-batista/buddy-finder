package com.example.buddyfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.buddyfinder.data.DAOSupporter;
import com.example.buddyfinder.view.SupporterLoginFragment;

public class SupporterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supporter);

        SupporterLoginFragment supporterLoginFragment = new SupporterLoginFragment();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        supporterLoginFragment.show(fragmentManager, "showlogin");
    }

    public void onClickShowDonations(View v) {
        Intent intent = new Intent(this, ShowDonationsActivity.class);
        this.startActivity(intent);
    }

    public void onClickShowAnimals(View v) {
        Intent intent = new Intent(this, ShowAnimalsActivity.class);
        this.startActivity(intent);
    }

    public void onClickLogout(View v) {
        DAOSupporter.getInstance().setSupporter(null);
        this.finish();
    }
}
