package com.company.myProject.config;

import com.company.myProject.Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class EatingProbabilityConfig<Animal> {
    private List<EatingConfigRow> rows = new ArrayList<>();

    public Double getHuntSuccessProbabilityFor(com.company.myProject.Animal.Animal predator, com.company.myProject.Animal.Animal food) {
        EatingConfigRow row = rows.stream()
            .filter(eatingConfigRow -> eatingConfigRow.getAnimalName().equals(predator))
            .findFirst()
            .get();

        return row.getProbabilities().get(food) / 100.0;
    }



    public List<EatingConfigRow> getRows() {
        return rows;
    }

    public void setRows(List<EatingConfigRow> rows) {
        this.rows = rows;
    }
}
