package com.example.buddyfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.buddyfinder.data.DAOAnimals;
import com.example.buddyfinder.model.Animal;

public class AddAnimalActivity extends AppCompatActivity {

    private EditText ptxtSpecie;
    private EditText ptxtEntryDate;
    private EditText ptxtCharacteristics;
    private EditText ptxtAge;
    private EditText ptxtLifePhase;

//    TODO: ADD PHOTO GALLERY
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        this.ptxtSpecie = this.findViewById(R.id.ptxtSpecie);
        this.ptxtEntryDate = this.findViewById(R.id.ptxtEntryDate);
        this.ptxtCharacteristics = this.findViewById(R.id.ptxtCharacteristics);
        this.ptxtAge = this.findViewById(R.id.ptxtAge);
        this.ptxtLifePhase = this.findViewById(R.id.ptxtLifePhase);
    }

    public void onClickAdd(View v) {
        String specie = this.ptxtSpecie.getText().toString();
        String entryDate = this.ptxtEntryDate.getText().toString();
        String characteristics = this.ptxtCharacteristics.getText().toString();
        String age = this.ptxtAge.getText().toString();
        String lifePhase = this.ptxtLifePhase.getText().toString();

        Animal animal = new Animal(specie, entryDate, age, lifePhase, characteristics);

        DAOAnimals.getInstance().addAnimal(animal);

        this.finish();
    }
}
