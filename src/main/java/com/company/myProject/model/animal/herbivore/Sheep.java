package com.company.myProject.model.animal.herbivore;

import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.AnimalProperties;
import com.company.myProject.model.animal.AnimalType;

import java.util.Random;

public class Sheep extends Herbivorous {

    public static final AnimalProperties SHEEP_PROPERTIES = new AnimalProperties(AnimalType.SHEEP, 50, 3, 4, 20,
            5, 5, 150);

    public Sheep(Cell currentPosition) {
        super(SHEEP_PROPERTIES, currentPosition);
    }

    @Override
    protected double getEatableMass() {
        return SHEEP_PROPERTIES.getWeight() * 0.4;
    }

    public  void giveBirths() {
        double maxLitterSize = SHEEP_PROPERTIES.getMaxLitterSize();
        int thisLitter = new Random().nextInt((int) maxLitterSize);
        for (int i = 0; i < thisLitter; i++) {
            Sheep newBornSheep= new Sheep(getPosition());
            getPosition().addAnimal(newBornSheep);
            System.out.println("Breed = " + newBornSheep);
        }
    }


}