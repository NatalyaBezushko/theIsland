package com.company.myProject.Animal;



public abstract class Herbivorous extends Animal {
    private static final Object Animal = 0;


    public Herbivorous(AnimalProperties animalProperties) {
        super(animalProperties);
    }

    public Herbivorous() {
        super((AnimalProperties) Animal);
    }

    public Herbivorous(Cell cell) {
        super((AnimalProperties) Animal);
    }

    @Override
    protected void getFood() {
        System.out.println("Herbivorous started getting food" + getId());
        Cell position = this.getPosition();
        Vegetation vegetation = position.getVegetation();
        eat(vegetation);
        System.out.println("Herbivorous ate food" + getId());
    }

    public abstract void giveBirths(int breed);
}
