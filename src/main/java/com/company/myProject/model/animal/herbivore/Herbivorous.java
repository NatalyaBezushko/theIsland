package com.company.myProject.model.animal.herbivore;


import com.company.myProject.Island.Cell;
import com.company.myProject.model.Vegetation;
import com.company.myProject.model.animal.Animal;
import com.company.myProject.model.animal.AnimalProperties;

public abstract class Herbivorous extends Animal {

    public Herbivorous(AnimalProperties animalProperties, Cell currentPosition) {
        super(animalProperties, currentPosition);
    }

    @Override
    public void getFood() {
        System.out.println("Herbivorous started getting food" + getId());
        Cell position = this.getPosition();
        Vegetation vegetation = position.getVegetation();
        eat(vegetation);
        System.out.println("Herbivorous ate food" + getId());
    }

}
