package com.company.myProject.Animal;

public class Goat extends Herbivorous {

    static com.company.myProject.Animal.Animal countYoungGoat;

    public Goat(AnimalProperties animalProperties) {
        super(animalProperties);
    }


    public com.company.myProject.Animal.Animal getCountYoungGoat() {
        return countYoungGoat;
    }

    public Goat() {

    }

    @Override
    public com.company.myProject.Animal.Animal giveBirths(com.company.myProject.Animal.Animal animal) {

        return animal;
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
        for (int i = 0; i < 10; i++) {
            Goat youngGoat;
            youngGoat = new Goat();
            getPosition().addAnimal(youngGoat);
            System.out.println("Breed = " + youngGoat);
        }

    }

}