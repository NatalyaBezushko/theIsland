package com.company.myProject.Animal;

public class Goat extends Herbivorous{

    static int countYoungGoat;

    public Goat(AnimalProperties animalProperties) {
        super(animalProperties);
    }


    public int getCountYoungGoat() {
        return countYoungGoat;
    }

    public Goat() {

    }



    @Override
    protected double getEatableMass() {
        return getAnimalProperties().getWeight() * 0.4;
    }

    private AnimalProperties getAnimalProperties() {
        return getAnimalProperties();
    }

    @Override
    public void giveBirths(int breed) {
        int births = breed();
        for (int i = 0; i < 30; i++) {
        Goat youngGoat = new Goat();
        }
        countYoungGoat++;
        System.out.println("Breed = " + getCountYoungGoat());
    }

}
