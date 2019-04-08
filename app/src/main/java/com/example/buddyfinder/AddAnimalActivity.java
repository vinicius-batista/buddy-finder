package com.example.buddyfinder;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

import com.example.buddyfinder.data.DAOAnimals;
import com.example.buddyfinder.model.Animal;
import com.example.buddyfinder.view.GalleryAdapter;
import com.example.buddyfinder.view.PhotoOpenDialogFragment;

import java.util.ArrayList;

public class AddAnimalActivity extends AppCompatActivity implements GalleryAdapter.GalleryListener {

    private EditText ptxtSpecie;
    private EditText ptxtEntryDate;
    private EditText ptxtCharacteristics;
    private EditText ptxtAge;
    private EditText ptxtLifePhase;
    private RecyclerView rvGallery;
    private GalleryAdapter galleryAdapter;
    private PhotoOpenDialogFragment photoOpenDialogFragment;
    private ArrayList<Bitmap> pictures;

    private static final int CAMERA_REQUEST_CODE = 777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
        this.createGallery();

        this.photoOpenDialogFragment = new PhotoOpenDialogFragment();
        this.pictures = new ArrayList<>();
        this.ptxtSpecie = this.findViewById(R.id.ptxtQuantity);
        this.ptxtEntryDate = this.findViewById(R.id.ptxtEntryDate);
        this.ptxtCharacteristics = this.findViewById(R.id.ptxtKind);
        this.ptxtAge = this.findViewById(R.id.ptxtDescription);
        this.ptxtLifePhase = this.findViewById(R.id.ptxtLifePhase);
    }

    private void createGallery () {
        this.rvGallery = (RecyclerView) this.findViewById(R.id.rvGallery);
        this.galleryAdapter = new GalleryAdapter(this);

        Display display = this.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int spanCount = (int) Math.ceil(dpWidth / 100);

        this.rvGallery.setLayoutManager(new GridLayoutManager(this, spanCount));
        this.rvGallery.setHasFixedSize(true);
        this.rvGallery.setAdapter(this.galleryAdapter);
    }

    public void onClickAdd(View v) {
        String specie = this.ptxtSpecie.getText().toString();
        String entryDate = this.ptxtEntryDate.getText().toString();
        String characteristics = this.ptxtCharacteristics.getText().toString();
        String age = this.ptxtAge.getText().toString();
        String lifePhase = this.ptxtLifePhase.getText().toString();

        Animal animal = new Animal(specie, entryDate, age, lifePhase, characteristics, this.pictures);
        DAOAnimals.getInstance().addAnimal(animal);

        this.finish();
    }


    public void onClickTakePic(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            this.startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }
    }

    @Override
    public void onClickPhoto(Bitmap pic) {
        this.photoOpenDialogFragment.setBitmap(pic);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.photoOpenDialogFragment.show(fragmentManager, "showpic");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            Bundle extras = data.getExtras();
            if(extras != null && extras.containsKey("data")){
                Bitmap bmp = (Bitmap) extras.get("data");
                this.pictures.add(bmp);
                this.galleryAdapter.setPicList(this.pictures);
            }
        }
    }
}
