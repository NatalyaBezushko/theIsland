package com.company.myProject.model.animal.predator;


import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.AnimalProperties;
import com.company.myProject.model.animal.AnimalType;
import com.company.myProject.model.animal.herbivore.Sheep;

import java.util.Random;

import static com.company.myProject.model.animal.AnimalType.GOAT;
import static com.company.myProject.model.animal.predator.Wolf.WOLF_PROPERTIES;

public class Fox extends Predator {

    public static final AnimalProperties FOX_PROPERTIES = new AnimalProperties(AnimalType.WOLF, 8, 2, 4, 2,
            5, 5, 30);

    public Fox(Cell currentPosition) {
        super(FOX_PROPERTIES, currentPosition);
    }

    @Override
    protected double getEatableMass() {
        return FOX_PROPERTIES.getWeight() * 0.4;
    }

    public  void giveBirths() {
        double maxLitterSize = FOX_PROPERTIES.getMaxLitterSize();
        int thisLitter = new Random().nextInt((int) maxLitterSize);
        for (int i = 0; i < thisLitter; i++) {
            Sheep newBornSheep= new Sheep(getPosition());
            getPosition().addAnimal(newBornSheep);
            System.out.println("Breed = " + newBornSheep);
        }
    }
}
