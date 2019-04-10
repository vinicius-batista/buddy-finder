package com.example.buddyfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.buddyfinder.model.Animal;
import com.example.buddyfinder.view.AnimalsListAdapter;

public class ShowAnimalsActivity extends AppCompatActivity implements AnimalsListAdapter.AnimalListener {

    public static final String ANIMAL_KEY = "com.example.buddyfinder.ShowAnimalsActivity.ANIMAL";
    private RecyclerView rvAnimalsList;
    private AnimalsListAdapter animalsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_animals);

        this.rvAnimalsList = this.findViewById(R.id.rvAnimalsList);
        this.rvAnimalsList.setLayoutManager(new LinearLayoutManager(this));
        this.rvAnimalsList.setHasFixedSize(true);

        this.animalsListAdapter = new AnimalsListAdapter(this);
        this.rvAnimalsList.setAdapter(this.animalsListAdapter);
    }

    @Override
    public void onClickAnimalListener(Animal animal) {
        Intent intent = new Intent(this, AnimalDetailsActivity.class);
        intent.putExtra(ANIMAL_KEY, animal);
        this.startActivity(intent);
    }
}
