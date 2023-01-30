package com.company.myProject.model.animal.predator;

import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.AnimalProperties;

public class Wolf extends Predator {
    public Wolf(Cell properties) {
        super(properties);
    }

    public Wolf() {
        super();
    }


    @Override
    protected double getEatableMass() {
        return getAnimalProperties().getWeight() * 0.4;
    }

    private AnimalProperties getAnimalProperties() {
        return getAnimalProperties();
    }

}
