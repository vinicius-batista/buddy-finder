package com.example.buddyfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.buddyfinder.data.DAODonations;
import com.example.buddyfinder.model.Donation;

public class AddDonationActivity extends AppCompatActivity {

    private EditText ptxtKind;
    private EditText ptxtQuantity;
    private EditText ptxtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        this.ptxtKind = this.findViewById(R.id.ptxtKind);
        this.ptxtQuantity = this.findViewById(R.id.ptxtQuantity);
        this.ptxtDescription = this.findViewById(R.id.ptxtDescription);
    }

    public void onClickAdd(View v) {
        String kind = this.ptxtKind.getText().toString();
        String quantity = this.ptxtQuantity.getText().toString();
        String description = this.ptxtDescription.getText().toString();

        Donation donation = new Donation(id, kind, quantity, description);
        DAODonations.getInstance().addDonation(donation);

        this.finish();
    }
}
