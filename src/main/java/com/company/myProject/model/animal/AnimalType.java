package com.company.myProject.model.animal;

import static com.company.myProject.model.animal.herbivore.Goat.GOAT_PROPERTIES;
import static com.company.myProject.model.animal.herbivore.Sheep.SHEEP_PROPERTIES;

public enum AnimalType {

    GOAT(GOAT_PROPERTIES),/* WOLF(), FOX(),*/ SHEEP(SHEEP_PROPERTIES);

    private AnimalProperties properties;

    AnimalType(AnimalProperties properties) {
        this.properties = properties;
    }

    public AnimalProperties getProperties() {
        return properties;
    }
}
