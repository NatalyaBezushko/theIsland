package com.company.myProject.Animal;

import static com.company.myProject.Animal.Main.goat;

public class AnimalFactory {

    public static  int goatCount = 0;
    public static int wolfCount = 0;
    public static int foxCount = 0;
    public static int youngGoatCount = 0;
    private Cell position;


    public Animal createAnimal(AnimalType animalType) {
        Animal animal = null;
        switch (animalType) {
            case GOAT:
             animal = new Goat();
             this.goatCount++;
             this.youngGoatCount++;
             break;
            case YOUNGGOAT:
                animal = new YoungGoat();
            case WOLF:
                animal = new Wolf();
                this.wolfCount++;
                break;
            case FOX:
                animal = new Fox();
                this.foxCount++;
                break;


        }System.out.println(("Goats = " + goatCount + "Wolfs = " + wolfCount + "Foxes = " + foxCount + "Young Goats" + youngGoatCount).toString());
        return  animal;

    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }
}




