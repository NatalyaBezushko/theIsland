package com.company.myProject.model.animal;

import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.herbivore.Goat;
import com.company.myProject.model.animal.predator.Fox;
import com.company.myProject.model.animal.predator.Wolf;

public class AnimalFactory {

    public static int goatCount = 0;
    public static int wolfCount = 0;
    public static int foxCount = 0;


    public Animal createAnimal(AnimalType animalType, Cell position) {
        Animal animal = null;
        switch (animalType) {
            case GOAT:
                animal = new Goat(position);
                goatCount++;
                break;
            case WOLF:
                animal = new Wolf();
                wolfCount++;
                break;
            case FOX:
                animal = new Fox();
                foxCount++;
                break;
        }
        System.out.println(("Goats = " + goatCount + "Wolfs = " + wolfCount + "Foxes = " + foxCount).toString());
        return animal;
    }
}




