package com.company.myProject.model.animal;

import static com.company.myProject.model.animal.herbivore.Goat.GOAT_PROPERTIES;
import static com.company.myProject.model.animal.herbivore.Sheep.SHEEP_PROPERTIES;
import static com.company.myProject.model.animal.predator.Fox.FOX_PROPERTIES;
import static com.company.myProject.model.animal.predator.Wolf.WOLF_PROPERTIES;

public enum AnimalType {

    GOAT(GOAT_PROPERTIES), WOLF(WOLF_PROPERTIES), FOX(FOX_PROPERTIES), SHEEP(SHEEP_PROPERTIES);

    private AnimalProperties properties;

    AnimalType(AnimalProperties properties) {
        this.properties = properties;
    }

    public AnimalProperties getProperties() {
        return properties;
    }
}
