package com.company.myProject.Animal;



import java.util.List;
import java.util.Random;

public abstract class Predator extends Animal{

    private static Object Animal;

    public Predator(Cell properties) {
        super((AnimalProperties) Animal);
    }

    public Predator() {
        super();
    }

    @Override
    protected void getFood() {
        System.out.println("Predator started getting food" + getId());
        Cell position = this.getPosition();
        List<Animal>  animalList;
        animalList = (List<Animal>) position.getAnimalList().stream()
                .filter(animal -> animal instanceof Herbivorous);
        if (animalList.size() <= 1) {
            return;
        }
        eat(animalList.get(new Random().nextInt(animalList.size() - 1)));
        System.out.println("Predator ate food" + getId());
    }
}
