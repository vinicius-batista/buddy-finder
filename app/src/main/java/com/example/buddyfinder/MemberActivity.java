package com.example.buddyfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
    }

    public void onClickAddAnimal (View v) {
        Intent intent = new Intent(this, AddAnimalActivity.class);
        this.startActivity(intent);
    }
}
