package com.company.myProject.Island;

import com.company.myProject.model.animal.Animal;
import com.company.myProject.model.Vegetation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cell {

    private final int x;
    private final int y;

    public Vegetation vegetation;

    List<Animal> animalList = new ArrayList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.animalList = new ArrayList<>();
        this.vegetation = new Vegetation(new Random().nextInt(Vegetation.MAX_VEGETATION_LEVEL));
    }

    public Vegetation getVegetation() {
        return vegetation;
    }

    public synchronized void addAnimal(Animal animal) {
        animalList.add(animal);
        Island.getInstance().animalList.add(animal);
    }

    public synchronized boolean removeAnimal(Animal animal) {
        animalList.remove(animal);
        return animalList.remove(animal);
    }

    public void setVegetation(Vegetation vegetation) {
        this.vegetation = vegetation;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Cell x=" + x + ", y=" + y;

    }
}
