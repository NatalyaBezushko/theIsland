package com.company.myProject.Animal;

public abstract class AnimalProperties {


    private AnimalType animalType;

    private final double weight;

    private final int range;

    public double stomachCapacity;

    private final double dailyEnergyConsumption;

    private final int deathFromStarvingAfter;

    private int maxAmountInCell = 10;

    public AnimalProperties(double weight, int range, double stomachCapacity, double dailyEnergyConsumption, int deathFromStarvingAfter, int maxAmauntInCell) {
        this.weight = weight;
        this.range = range;
        this.stomachCapacity = stomachCapacity;
        this.dailyEnergyConsumption = dailyEnergyConsumption;
        this.deathFromStarvingAfter = deathFromStarvingAfter;
        this.maxAmountInCell = 10;
    }

    public abstract Animal createAnimal();

    public double getWeight() {
        return weight;
    }

    public int getRange() {
        return range;
    }

    public double getStomachCapacity() {
        return stomachCapacity;
    }

    public double getDailyEnergyConsumption() {
        return dailyEnergyConsumption;
    }

    public int getDeathFromStarvingAfter() {
        return deathFromStarvingAfter;
    }

    public int getMaxAmauntInCell() {
        return maxAmountInCell;
    }


}
