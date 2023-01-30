package com.company.myProject.Animal;

import static com.company.myProject.Animal.Main.goat;

public class GoatProperties extends AnimalProperties{
    @Override
    public Animal createAnimal() {
        return goat;
    }

    public GoatProperties(double weight, int range, double stomachCapacity, double dailyEnergyConsumption, int deathFromStarvingAfter, int maxAmauntInCell) {
        super(weight, range, stomachCapacity, dailyEnergyConsumption, deathFromStarvingAfter, maxAmauntInCell);
        this.stomachCapacity = stomachCapacity;
    }

    @Override
    public static double getStomachCapacity() {
        return AnimalProperties.getStomachCapacity();
    }
}
