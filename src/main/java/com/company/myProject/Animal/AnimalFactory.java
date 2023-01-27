package com.company.myProject.Animal;

import com.company.myProject.Animal.*;

public class AnimalFactory {
    Animal animal;
    public   int goatCount = 0;
    public int wolfCount = 0;
    public int foxCount = 0;
    private Cell position;


    public Animal createAnimal(AnimalType animalType) {

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

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }
}



