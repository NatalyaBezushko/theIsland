package com.company.myProject.config.fromKostia;

import com.company.myProject.model.animal.AnimalType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EatingProbabilityConfig {

    public static Map<AnimalType, List<EatingProbability>> eatingProbabilityMap; //ключ - кто есть, значение - список вероятностей для каждой жертвы

    static {
        eatingProbabilityMap = new HashMap<>();
        createWolfProbabilities();
        createFoxProbabilities();
    }

    private static void createWolfProbabilities() {
        List<EatingProbability> wolfProbabilities = new ArrayList<>();
        wolfProbabilities.add(new EatingProbability(AnimalType.GOAT, 40));
        wolfProbabilities.add(new EatingProbability(AnimalType.SHEEP, 60));
        eatingProbabilityMap.put(AnimalType.WOLF, wolfProbabilities);
    }

    private static void createFoxProbabilities() {
        List<EatingProbability> foxProbabilities = new ArrayList<>();
        foxProbabilities.add(new EatingProbability(AnimalType.GOAT, 15));
        foxProbabilities.add(new EatingProbability(AnimalType.SHEEP, 30));
        eatingProbabilityMap.put(AnimalType.FOX, foxProbabilities);
    }

}
