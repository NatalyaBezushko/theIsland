package com.company.myProject.model.animal;

public class AnimalProperties {

    private AnimalType animalType;
    private final double weight;
    private final int range;
    private final int maxLitterSize;
    public final double maxStomachCapacity;
    private final double dailyEnergyConsumption;
    private final int deathFromStarvingAfter;
    private final int maxAmountInCell;
    // изначальное количество на острове. Сделай жто поле и используй во время создания и популяции острова

    public AnimalProperties(AnimalType animalType, double weight, int range, int maxLitterSize,
                            double maxStomachCapacity, double dailyEnergyConsumption, int deathFromStarvingAfter,
                            int maxAmountInCell) {
        this.animalType = animalType;
        this.weight = weight;
        this.range = range;
        this.maxLitterSize = maxLitterSize;
        this.maxStomachCapacity = maxStomachCapacity;
        this.dailyEnergyConsumption = dailyEnergyConsumption;
        this.deathFromStarvingAfter = deathFromStarvingAfter;
        this.maxAmountInCell = maxAmountInCell;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public double getWeight() {
        return weight;
    }

    public int getRange() {
        return range;
    }

    public int getMaxLitterSize() {
        return maxLitterSize;
    }

    public double getMaxStomachCapacity() {
        return maxStomachCapacity;
    }

    public double getDailyEnergyConsumption() {
        return dailyEnergyConsumption;
    }

    public int getDeathFromStarvingAfter() {
        return deathFromStarvingAfter;
    }

    public int getMaxAmountInCell() {
        return maxAmountInCell;
    }
}
