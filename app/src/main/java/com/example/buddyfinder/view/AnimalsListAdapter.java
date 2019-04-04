package com.example.buddyfinder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buddyfinder.R;
import com.example.buddyfinder.data.DAOAnimals;
import com.example.buddyfinder.model.Animal;

import java.util.ArrayList;

public class AnimalsListAdapter extends RecyclerView.Adapter<AnimalsListViewHolder>  {
    private ArrayList<Animal> peopleList;
    private AnimalListener animalListener;

    public AnimalsListAdapter (AnimalListener animalListener) {
        this.peopleList = DAOAnimals.getInstance().getAnimals();
        this.animalListener = animalListener;
    }

    public interface AnimalListener {
        void onClickAnimalListener(Animal animal);
    }

    @NonNull
    @Override
    public AnimalsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_animals_list, viewGroup, false);
        return new AnimalsListViewHolder(view, this.animalListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsListViewHolder animalsListViewHolder, int i) {
        animalsListViewHolder.bind(this.peopleList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.peopleList.size();
    }
}
