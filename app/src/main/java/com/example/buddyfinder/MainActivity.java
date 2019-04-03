package com.example.buddyfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNgoMember (View V) {
        Intent intent = new Intent(this, MemberActivity.class);
        this.startActivity(intent);
    }

    public void onClickNgoSupporter (View v) {
        Intent intent = new Intent(this, SupporterActivity.class);
        this.startActivity(intent);
    }
}
