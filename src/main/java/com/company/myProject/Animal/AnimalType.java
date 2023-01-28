package com.company.myProject.Animal;

public enum AnimalType {

    GOAT("goat"), WOLF("wolf"), FOX("fox"), YOUNGGOAT("youngGoat");


    private final String value;


    AnimalType(String value) {
        this.value = value;
    }
}
