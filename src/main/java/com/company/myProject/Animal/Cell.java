package com.company.myProject.Animal;

import com.company.myProject.Animal.Animal;
import com.company.myProject.Animal.Vegetation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cell implements Runnable {

    private Goat youngGoat;
    final int x;
    final int y;

    Goat goat = new Goat();


    public Vegetation getVegetation;

    List<Animal> animalList;

    public Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public Vegetation getVegetation() {
        return vegetation;
    }

    private Vegetation vegetation;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.animalList = new ArrayList<>();
        this.vegetation = new Vegetation(new Random().nextInt(Vegetation.MAX_VEGETATION_LEVEL));
    }

    public synchronized void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public synchronized boolean removeAnimal(Animal animal) {
        animalList.remove(animal);
        return animalList.remove(animal);
    }

    @Override
    public String toString() {
        return "Cell x=" + x + ", y=" + y;

    }

    @Override
    public void run() {

    }


    public void setVegetation(Vegetation vegetation) {
        this.vegetation = vegetation;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
}
