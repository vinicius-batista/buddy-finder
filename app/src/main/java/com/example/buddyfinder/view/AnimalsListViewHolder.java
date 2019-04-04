package com.example.buddyfinder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.buddyfinder.R;
import com.example.buddyfinder.model.Animal;

public class AnimalsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView txtSpecie;
    private TextView txtStatus;
    private TextView txtLifePhase;
    private Animal animal;
    private AnimalsListAdapter.AnimalListener listener;

    public AnimalsListViewHolder(@NonNull View itemView, AnimalsListAdapter.AnimalListener listener) {
        super(itemView);
        this.txtSpecie = (TextView) itemView.findViewById(R.id.txtSpecie);
        this.txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
        this.txtLifePhase = (TextView) itemView.findViewById(R.id.txtLifePhase);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bind (Animal animal) {
        this.txtSpecie.setText(animal.getSpecie());
        this.txtStatus.setText(animal.getStatus());
        this.txtLifePhase.setText(animal.getLifePhase());
        this.animal = animal;
    }

    @Override
    public void onClick(View v) {
        this.listener.onClickAnimalListener(this.animal);
    }
}
