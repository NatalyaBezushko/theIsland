package com.company.myProject.config.fromKostia;

import com.company.myProject.model.animal.AnimalType;

public class EatingProbability {

    private final AnimalType prey;
    private final int probability;

    public EatingProbability(AnimalType prey, int probability) {
        this.prey = prey;
        this.probability = probability;
    }

    public AnimalType getPrey() {
        return prey;
    }

    public int getProbability() {
        return probability;
    }

    @Override
    public String toString() {
        return "EatingProbability{" +
                "prey=" + prey +
                ", probability=" + probability +
                '}';
    }
}
