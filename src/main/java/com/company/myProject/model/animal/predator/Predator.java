package com.company.myProject.model.animal.predator;


import com.company.myProject.Island.Cell;
import com.company.myProject.model.animal.Animal;
import com.company.myProject.model.animal.AnimalProperties;
import com.company.myProject.model.animal.herbivore.Herbivorous;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Predator extends com.company.myProject.model.animal.Animal {

    public Predator(AnimalProperties properties, Cell position) {
        super(properties, position);
    }

    @Override
    public void getFood() {
        System.out.println("Predator started getting food" + getId());
        Cell position = this.getPosition();
        List<Animal> animalList = position.getAnimalList().stream()
                .filter(animal -> animal instanceof Herbivorous)
                .collect(Collectors.toList());
        if (animalList.size() <= 1) {
            System.out.println("Animal could not find food");
            return;
        }
        eat(animalList.get(new Random().nextInt(animalList.size() - 1)));
        System.out.println("Predator ate food" + getId());
    }
}
