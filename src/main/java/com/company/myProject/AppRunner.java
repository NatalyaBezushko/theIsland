package com.company.myProject;

import com.company.myProject.Island.Island;
import com.company.myProject.config.fromKostia.EatingProbability;
import com.company.myProject.config.fromKostia.EatingProbabilityConfig;
import com.company.myProject.model.animal.AnimalFactory;
import com.company.myProject.model.animal.AnimalProperties;
import com.company.myProject.model.animal.AnimalType;
import com.company.myProject.simulation.Simulation;

import java.util.List;

public class AppRunner {

    public static void main(String[] args) {
        prepareSimulation(); //инициализируем конфигурации, создание острова, населяем остров, садим растения
        Simulation simulation = new Simulation();
        simulation.runSimulation();
    }

    private static void prepareSimulation() {
        Island island = Island.getInstance();
        //населить остров животными
        for (AnimalType currentType : AnimalType.values()) {
            AnimalProperties currentProperties = currentType.getProperties();
            AnimalFactory factory = new AnimalFactory();
            factory.createAnimal(currentType, island.islandGrid[0][0]);
            //дальнейшая логика популяции острова
        }
        System.out.println("lol");
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
}
