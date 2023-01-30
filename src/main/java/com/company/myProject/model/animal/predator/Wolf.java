package com.company.myProject.model.animal.predator;

import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.AnimalProperties;

import static com.company.myProject.model.animal.AnimalType.GOAT;

public class Wolf extends Predator {
    public Wolf(Cell position) {
        super(GOAT.getProperties(), position);
    }


    @Override
    protected double getEatableMass() {
        return getAnimalProperties().getWeight() * 0.4;
    }

    private AnimalProperties getAnimalProperties() {
        return getAnimalProperties();
    }

}
