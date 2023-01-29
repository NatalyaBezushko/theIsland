package com.company.myProject.config;

import java.util.ArrayList;
import java.util.List;

public class EatingProbabilityConfig<Animal> {
    private List<EatingConfigRow> rows = new ArrayList<>();

    public Double getFor(String predator, String food) {
        EatingConfigRow row = rows.stream()
            .filter(eatingConfigRow -> eatingConfigRow.getAnimalName().equals(predator))
            .findFirst()
            .get();

        return row.getProbabilities().get(food) / 100.0;
    }

    public Double getHuntSuccessProbabilityFor(Animal predator, Animal food) {
        return getFor(predator.getClass().getSimpleName().toLowerCase(), food.getClass().getSimpleName().toLowerCase());
    }

    public List<EatingConfigRow> getRows() {
        return rows;
    }

    public void setRows(List<EatingConfigRow> rows) {
        this.rows = rows;
    }
}
