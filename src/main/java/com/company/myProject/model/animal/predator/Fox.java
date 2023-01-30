package com.company.myProject.model.animal.predator;


import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.AnimalProperties;

public class Fox extends Predator {
    public Fox(Cell properties) {
        super(properties);
    }

    @Override
    protected double getEatableMass() {
        return getAnimalProperties().getWeight() * 0.4;
    }

    private AnimalProperties getAnimalProperties() {
        return getAnimalProperties();
    }
}
