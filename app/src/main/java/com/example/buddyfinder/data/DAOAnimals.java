package com.example.buddyfinder.data;

import com.example.buddyfinder.model.Animal;

import java.util.ArrayList;

public class DAOAnimals {
    private static final DAOAnimals ourInstance = new DAOAnimals();
    private ArrayList<Animal> animals;

    public static DAOAnimals getInstance() {
        return ourInstance;
    }

    private DAOAnimals() {
        this.animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
