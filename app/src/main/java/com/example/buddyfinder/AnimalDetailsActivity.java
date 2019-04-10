package com.example.buddyfinder;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.buddyfinder.data.DAOAnimals;
import com.example.buddyfinder.data.DAOSupporter;
import com.example.buddyfinder.model.Animal;
import com.example.buddyfinder.model.Supporter;
import com.example.buddyfinder.view.GalleryAdapter;
import com.example.buddyfinder.view.InterestedAdoptingListAdapter;
import com.example.buddyfinder.view.PhotoOpenDialogFragment;

import java.util.ArrayList;


public class AnimalDetailsActivity extends AppCompatActivity implements GalleryAdapter.GalleryListener, InterestedAdoptingListAdapter.ApproveListener {

    private TextView txtSpecie;
    private TextView txtLifePhase;
    private TextView txtStatus;
    private TextView txtAge;
    private TextView txtCharacteristics;
    private TextView txtEntryDate;
    private TextView txtOwner;
    private TextView txtOw;
    private RecyclerView rvGallery;
    private GalleryAdapter galleryAdapter;
    private RecyclerView rvInterestedAdopting;
    private PhotoOpenDialogFragment photoOpenDialogFragment;
    private Animal animal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        this.photoOpenDialogFragment = new PhotoOpenDialogFragment();
        this.createTextViews();
        this.createGallery();

        this.animal = this.getIntent().getParcelableExtra(ShowAnimalsActivity.ANIMAL_KEY);
        this.setTextViewValues();
        this.galleryAdapter.setPicList(this.animal.getPictures());

        this.rvInterestedAdopting = this.findViewById(R.id.rvInterestedAdoptingList);
        this.setupRecyclerView();

        if (DAOSupporter.getInstance().getSupporter() != null) {
            Button btnAdopt = this.findViewById(R.id.btnAdopt);
            btnAdopt.setVisibility(Button.VISIBLE);
        }

        if (this.animal.getInterestedAdopting().isEmpty()) {
            LinearLayout llInterestedAdopting = this.findViewById(R.id.llInterestedAdopting);
            llInterestedAdopting.setVisibility(LinearLayout.INVISIBLE);
        }
    }

    private void setupRecyclerView() {
        this.rvInterestedAdopting.setLayoutManager(new LinearLayoutManager(this));
        this.rvInterestedAdopting.setHasFixedSize(true);

        InterestedAdoptingListAdapter interestedAdoptingListAdapter =
                new InterestedAdoptingListAdapter(this.animal.getInterestedAdopting(), this);

        this.rvInterestedAdopting.setAdapter(interestedAdoptingListAdapter);
    }

    private void createTextViews() {
        this.txtSpecie = this.findViewById(R.id.txtSpecie);
        this.txtLifePhase = this.findViewById(R.id.txtLifePhase);
        this.txtStatus = this.findViewById(R.id.txtStatus);
        this.txtAge = this.findViewById(R.id.txtAge);
        this.txtCharacteristics = this.findViewById(R.id.txtCharacteristics);
        this.txtEntryDate = this.findViewById(R.id.txtEntryDate);
        this.txtOwner = this.findViewById(R.id.txtOwner);
        this.txtOw = this.findViewById(R.id.txtOw);
    }

    private void setTextViewValues() {
        this.txtSpecie.setText(this.animal.getSpecie());
        this.txtLifePhase.setText(this.animal.getLifePhase());
        this.txtStatus.setText(this.animal.getStatus());
        this.txtAge.setText(this.animal.getAge());
        this.txtCharacteristics.setText(this.animal.getCharacteristics());
        this.txtEntryDate.setText(this.animal.getEntryDate());

        if (this.animal.getOwner() != null) {
            this.txtOw.setVisibility(TextView.VISIBLE);
            this.txtOwner.setText(this.animal.getOwner().getName());
        }
    }

    private void createGallery() {
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

    private Animal getAnimalFromDAO() {
        ArrayList<Animal> animals = DAOAnimals.getInstance().getAnimals();
        for (Animal animal : animals) {
            if (animal.equals(this.animal)) {
                return animal;
            }
        }

        return null;
    }

    @Override
    public void onClickPhoto(Bitmap pic) {
        this.photoOpenDialogFragment.setBitmap(pic);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.photoOpenDialogFragment.show(fragmentManager, "showpic");
    }

    public void onClickAdopt(View v) {
        Supporter supporter = DAOSupporter.getInstance().getSupporter();
        Animal animal = this.getAnimalFromDAO();
        animal.addInterestedAdopting(supporter);

        this.finish();
    }

    @Override
    public void onClickApprove(Supporter supporter) {
        Animal animal = this.getAnimalFromDAO();
        animal.setOwner(supporter);
        animal.clearInterestedAdopting();
        animal.setStatus("adopted");

        this.finish();
    }
}
