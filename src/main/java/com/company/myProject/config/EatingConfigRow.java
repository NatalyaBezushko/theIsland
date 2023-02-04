package com.company.myProject.config;

import java.util.HashMap;
import java.util.Map;

public class EatingConfigRow {
    private String animalName;
    private Map<String, Integer> probabilities = new HashMap<>();

    public EatingConfigRow() {
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Map<String, Integer> getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(Map<String, Integer> probabilities) {
        this.probabilities = probabilities;
    }
}
