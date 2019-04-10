package com.example.buddyfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.buddyfinder.data.DAOSupporter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNgoMember(View V) {
        Intent intent = new Intent(this, MemberActivity.class);
        this.startActivity(intent);
    }

    public void onClickNgoSupporter(View v) {
        Intent intent = new Intent(this, SupporterActivity.class);
        this.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        DAOSupporter.getInstance().setSupporter(null);
    }
}
