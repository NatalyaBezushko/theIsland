package com.company.myProject;

import com.company.myProject.Island.Cell;
import com.company.myProject.Island.Island;
import com.company.myProject.config.fromKostia.EatingProbability;
import com.company.myProject.config.fromKostia.EatingProbabilityConfig;
import com.company.myProject.model.animal.Animal;
import com.company.myProject.model.animal.AnimalFactory;
import com.company.myProject.model.animal.AnimalProperties;
import com.company.myProject.model.animal.AnimalType;
import com.company.myProject.model.animal.herbivore.Goat;
import com.company.myProject.simulation.Simulation;

import javax.swing.*;
import java.util.List;
import java.util.Random;

import static com.company.myProject.model.animal.AnimalType.*;
import static com.company.myProject.model.animal.herbivore.Goat.GOAT_PROPERTIES;

public class AppRunner {

    AnimalFactory factory = new AnimalFactory();
    private static final int MAX_DEFAULT_ANIMAL_COUNT = 200;
    Cell cell;


    public static void main(String[] args) {
        prepareSimulation(); //инициализируем конфигурации, создание острова, населяем остров, садим растения
        Simulation simulation = new Simulation();
        simulation.runSimulation();
    }

    private static void prepareSimulation() {
        Island island = Island.getInstance();
        AnimalFactory factory = new AnimalFactory();
        //населить остров животными
        for (AnimalType currentType : AnimalType.values()) {
            AnimalProperties currentProperties = currentType.getProperties();
            for (int i = 0; i < island.xDimension; i++) {
                for (int j = 0; j < island.yDimension; j++) {

                    factory.createAnimal(currentType, island.islandGrid[i][j]);
                }
            }
        }
    }

    //дальнейшая логика популяции острова

    private void populateCell(Cell cell, Island island) {
        Random cellPopulationPicker = new Random();
        int animalCount = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);

        for (int i = 0; i < animalCount; i++) {
            factory.createAnimal(GOAT, cell);
            factory.createAnimal(SHEEP, cell);
            factory.createAnimal(WOLF, cell);
            factory.createAnimal(FOX, cell);
            Goat.position(cell);
            cell.addAnimal(goat, cell);
            animalList.add(goat);
        }
        System.out.printf("Cell %s populated with %s animals%n", cell, animalCount);
        System.out.println("Island is populated");
    }


}
/*
    private static void eatingDemo() { //это метод я написал чтоб продемонстрировать как достать из конфигурации конкретную вероятность
        List<EatingProbability> probabilityOfWolfEatingAllHerbivores =
                EatingProbabilityConfig.eatingProbabilityMap.get(AnimalType.WOLF);
        EatingProbability probabilityOfWolfEatingASheep = probabilityOfWolfEatingAllHerbivores.stream()
                .filter(eatingProbability -> eatingProbability.getPrey() == AnimalType.SHEEP)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Could not find probability of wolf eating a sheep"));
        System.out.println(probabilityOfWolfEatingAllHerbivores);
        System.out.println(probabilityOfWolfEatingASheep);
    }*/
//}
//