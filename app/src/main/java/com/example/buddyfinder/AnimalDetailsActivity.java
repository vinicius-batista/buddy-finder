package com.example.buddyfinder;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.TextView;

import com.example.buddyfinder.model.Animal;
import com.example.buddyfinder.view.GalleryAdapter;
import com.example.buddyfinder.view.PhotoOpenDialogFragment;


// TODO: SHOW OWNER IF ANIMAL WAS ADOPTED
// TODO: SHOW PEOPLE INTERESTED IN ADOPT THIS ANIMAL
public class AnimalDetailsActivity extends AppCompatActivity implements GalleryAdapter.GalleryListener {

    private TextView txtSpecie;
    private TextView txtLifePhase;
    private TextView txtStatus;
    private TextView txtAge;
    private TextView txtCharacteristics;
    private TextView txtEntryDate;
    private RecyclerView rvGallery;
    private GalleryAdapter galleryAdapter;
    private PhotoOpenDialogFragment photoOpenDialogFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        this.photoOpenDialogFragment = new PhotoOpenDialogFragment();
        this.createTextViews();
        this.createGallery();

        Animal animal = this.getIntent().getParcelableExtra(ShowAnimalsActivity.ANIMAL_KEY);
        this.setTextViewValues(animal);
        this.galleryAdapter.setPicList(animal.getPictures());
    }

    private void createTextViews() {
        this.txtSpecie = this.findViewById(R.id.txtSpecie);
        this.txtLifePhase = this.findViewById(R.id.txtLifePhase);
        this.txtStatus = this.findViewById(R.id.txtStatus);
        this.txtAge = this.findViewById(R.id.txtAge);
        this.txtCharacteristics = this.findViewById(R.id.txtCharacteristics);
        this.txtEntryDate = this.findViewById(R.id.txtEntryDate);
    }

    private void setTextViewValues(Animal animal) {
        this.txtSpecie.setText(animal.getSpecie());
        this.txtLifePhase.setText(animal.getLifePhase());
        this.txtStatus.setText(animal.getStatus());
        this.txtAge.setText(animal.getAge());
        this.txtCharacteristics.setText(animal.getCharacteristics());
        this.txtEntryDate.setText(animal.getEntryDate());
    }

    private void createGallery () {
        this.rvGallery = (RecyclerView) this.findViewById(R.id.rvAnimalGallery);
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

    @Override
    public void onClickPhoto(Bitmap pic) {
        photoOpenDialogFragment.setBitmap(pic);
        FragmentManager fragmentManager = getSupportFragmentManager();
        photoOpenDialogFragment.show(fragmentManager, "showpic");
    }
}
