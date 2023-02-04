package com.company.myProject.model.animal.predator;

import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.AnimalProperties;
import com.company.myProject.model.animal.AnimalType;
import com.company.myProject.model.animal.herbivore.Sheep;

import java.util.Random;

import static com.company.myProject.model.animal.AnimalType.GOAT;
import static com.company.myProject.model.animal.herbivore.Sheep.SHEEP_PROPERTIES;

public class Wolf extends Predator {

    public static final AnimalProperties WOLF_PROPERTIES = new AnimalProperties(AnimalType.WOLF, 50, 3, 4, 8,
            5, 5, 30);

    public Wolf(Cell currentPosition) {
        super(WOLF_PROPERTIES, currentPosition);
    }

    @Override
    protected double getEatableMass() {
        return WOLF_PROPERTIES.getWeight() * 0.4;
    }

    public  void giveBirths() {
        double maxLitterSize = WOLF_PROPERTIES.getMaxLitterSize();
        int thisLitter = new Random().nextInt((int) maxLitterSize);
        for (int i = 0; i < thisLitter; i++) {
            Sheep newBornSheep= new Sheep(getPosition());
            getPosition().addAnimal(newBornSheep);
            System.out.println("Breed = " + newBornSheep);
        }
    }
}
