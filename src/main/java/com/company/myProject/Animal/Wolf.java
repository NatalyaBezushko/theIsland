package com.company.myProject.Animal;

public class Wolf extends Predator {
    public Wolf(Cell properties) {
        super(properties);
    }

    public Wolf() {
        super();
    }

    @Override
    protected void eat(Eatable eatable) {
        double consumed = eatable.consumeAsFood(getStomachCapacity());
        currentStomachLevel = currentStomachLevel + consumed;
        if (currentStomachLevel >= getStomachCapacity()) ;
        {
            currentStomachLevel = getStomachCapacity();

        }
        daysWithoutFood = -1;
    }

    @Override
    protected double getEatableMass() {
        return getAnimalProperties().getWeight() * 0.4;
    }

    private AnimalProperties getAnimalProperties() {
        return getAnimalProperties();
    }

}
