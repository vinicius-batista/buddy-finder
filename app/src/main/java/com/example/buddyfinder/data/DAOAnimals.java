package com.example.buddyfinder.data;

import com.example.buddyfinder.model.Animal;

import java.util.ArrayList;

public class DAOAnimals {
    private static final DAOAnimals ourInstance = new DAOAnimals();
    private ArrayList<Animal> animals;
    private int counter;

    public static DAOAnimals getInstance() {
        return ourInstance;
    }

    private DAOAnimals() {
        this.animals = new ArrayList<>();
        this.counter = 0;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    public void addAnimal(Animal animal) {
        animal.setId(this.counter++);
        this.animals.add(animal);
    }

    public ArrayList<Animal> getAvailableAnimals() {
        ArrayList<Animal> availableAnimals = new ArrayList<>();

        for (Animal animal: this.animals) {
            if (animal.getStatus().equalsIgnoreCase("available")) {
                availableAnimals.add(animal);
            }
        }

        return availableAnimals;
    }
}
