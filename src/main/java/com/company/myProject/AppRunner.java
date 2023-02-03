package com.company.myProject;

import com.company.myProject.Island.Cell;
import com.company.myProject.Island.Island;
import com.company.myProject.model.animal.AnimalFactory;
import com.company.myProject.model.animal.AnimalProperties;
import com.company.myProject.model.animal.AnimalType;
import com.company.myProject.simulation.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.myProject.model.animal.AnimalType.*;

public class AppRunner {

    private static final int MAX_DEFAULT_ANIMAL_COUNT = 200;

    private static List<AnimalFactory> allAnimals = new ArrayList<AnimalFactory>();

    AnimalFactory factory = new AnimalFactory();

    public static void main(String[] args) {
        prepareSimulation(); //инициализируем конфигурации, создание острова, населяем остров, садим растения
        Simulation simulation = new Simulation();
        simulation.runSimulation();
        AppRunner appRunner = new AppRunner();
        appRunner.populateCell();
        prepareSimulation();

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

    public void populateCell(Cell cell, Island island) {
        Random cellPopulationPicker = new Random();
        int animalCount = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);
        for (int i = 0; i < MAX_DEFAULT_ANIMAL_COUNT; i++) {
            AnimalFactory factory = new AnimalFactory();
            factory.setPosition(cell);
            cell.addAnimal(cellPopulationPicker);
            allAnimals.add(factory);
            }
        System.out.printf("Cell %s populated with %s animals%n", cell);
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