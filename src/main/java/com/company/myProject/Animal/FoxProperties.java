package com.company.myProject.Animal;

import static com.company.myProject.Animal.Main.fox;

public class FoxProperties extends AnimalProperties{
    public FoxProperties(double weight, int range, double stomachCapacity, double dailyEnergyConsumption, int deathFromStarvingAfter, int maxAmauntInCell) {
        super(weight, range, stomachCapacity, dailyEnergyConsumption, deathFromStarvingAfter, maxAmauntInCell);
        this.stomachCapacity = stomachCapacity;
    }

    @Override
    public Animal createAnimal() {
        return fox;
    }
}
