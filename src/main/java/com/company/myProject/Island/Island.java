package com.company.myProject.Island;


import com.company.myProject.config.fromKostia.IslandConfig;
import com.company.myProject.model.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Island {

    private static Island instance;

    public int xDimension;
    public int yDimension;

    public Cell[][] islandGrid;
    List <Animal> animalList = new ArrayList<>();

    private Island(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.islandGrid = new Cell[xDimension][yDimension];
        for (int x = 0; x < xDimension; x++) {
            for (int y = 0; y < yDimension; y++) {
                islandGrid[x][y] = new Cell(x, y);
            }
        }
    }

    public static Island getInstance() {
        if (instance == null) {
            instance = new Island(IslandConfig.X_DIMENSION, IslandConfig.Y_DIMENSION);
        }
        return instance;
    }
}
