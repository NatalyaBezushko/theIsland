package com.company.myProject.model.animal.herbivore;

import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.AnimalProperties;
import com.company.myProject.model.animal.AnimalType;

import java.util.Random;

public class Goat extends Herbivorous {

    //создай подобные статические константы для других видов животных пярмо внутри классов других животных, как здесь
    public static final AnimalProperties GOAT_PROPERTIES = new AnimalProperties(AnimalType.GOAT, 60, 3, 4, 10,
            5, 5, 140);

    public Goat(Cell currentPosition) {
        super(GOAT_PROPERTIES, currentPosition);
    }

    public static void position(Cell cell) {
    }

    @Override
    protected double getEatableMass() {
        return GOAT_PROPERTIES.getWeight() * 0.4;
    }

    public  void giveBirths() {
        double maxLitterSize = GOAT_PROPERTIES.getMaxLitterSize();
        int thisLitter = new Random().nextInt((int) maxLitterSize);
        for (int i = 0; i < thisLitter; i++) {
            Goat newBornGoat= new Goat(getPosition());
            getPosition().addAnimal(newBornGoat);
            System.out.println("Breed = " + newBornGoat);
        }
    }


}