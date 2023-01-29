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
    private static AnimalProperties getAnimalProperties() {
        return getAnimalProperties();
    }


    @Override
    protected double getEatableMass() {
        return getAnimalProperties().getWeight() * 0.4;
    }



    public static void giveBirths() {

        for (int i = 0; i < getAnimalProperties().getMaxAmauntInCell(); i++) {
            Goat youngGoat;
            youngGoat = new Goat();
            getPosition().addAnimal(youngGoat);

            System.out.println("Breed = " + youngGoat);

        }

    }


}