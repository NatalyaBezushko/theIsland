package com.company.myProject.Animal;

import static com.company.myProject.Animal.Main.wolf;

public class WolfProperties extends AnimalProperties{
    public WolfProperties(double weight, int range, double stomachCapacity, double dailyEnergyConsumption, int deathFromStarvingAfter, int maxAmauntInCell) {
        super(weight, range, stomachCapacity, dailyEnergyConsumption, deathFromStarvingAfter, maxAmauntInCell);
        this.stomachCapacity = 4;
    }

    @Override
    public Animal createAnimal() {
        return wolf;
    }
}
