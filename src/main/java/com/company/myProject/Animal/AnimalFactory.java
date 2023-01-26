package com.company.myProject.Animal;

import com.company.myProject.Animal.*;

public class AnimalFactory {
    Animal animal;
    private  int goatCount = 0;
    private int wolfCount = 0;
    private int foxCount = 0;


    public Animal createAnimal(AnimalType type, AnimalType goat, AnimalType animalType) {

        switch (animalType) {
            case GOAT:

             animal = new Goat();
             this.goatCount++;
             break;
            case WOLF:
                animal = new Wolf();
                this.wolfCount++;
                break;
            case FOX:
                animal = new Fox();
                this.foxCount++;
                break;
        }System.out.println(("Goats = " + goatCount + "Wolfs = " + wolfCount + "Foxes = " + foxCount).toString());
        return  animal;

    }
}




