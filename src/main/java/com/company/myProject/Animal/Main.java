package com.company.myProject.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.company.myProject.Animal.AnimalType.*;
import static com.company.myProject.config.GameConfig.EATING_PROBABILITY_CONFIG;

public class Main {

    private static AnimalFactory animalFactory = new AnimalFactory();

    static Animal animal = new Animal() {

        @Override
        protected void getFood() {

        }

        @Override
        protected double getEatableMass() {
            return 0;
        }
    };


    static Animal wolf = new Wolf();
    static Animal goat = new Goat();
    static Goat youngGoat = new Goat();
    static Animal fox = new Fox();

    private static int MAX_DEFAULT_ANIMAL_COUNT = 10;

    private static int SIMULATION_DURATION = 10;

    public static AtomicInteger movesCount = new AtomicInteger(0);

    public static int animalCount;

    private static List<Animal> allAnimals = new ArrayList<>();


    AnimalProperties stomachCapacity;


    public static void main(String[] args) {

        Island island = new Island(5, 3);

        populateIsland(island);

        animal.getFood();
        wolf.eat();

        System.out.println("Total animals = " + allAnimals.size());
        int dayCount = 0;
        do {
            startDay();
            dayCount++;

        } while (dayCount < SIMULATION_DURATION);

        System.out.println("Simulation finished");
        System.out.println("Total moves done = " + movesCount);
        System.out.println(movesCount.toString());

    }


    private static void populateIsland(Island island) {
        for (int i = 0; i < island.xDimension; i++) {
            for (int j = 0; j < island.yDimension; j++) {
                populateCell(island.islandGrid[i][j], island);
            }
        }
        System.out.println("Island populated");
    }

    private static void startDay() {
        System.out.println("Starting simulation period");
        ExecutorService executorService = Executors.newCachedThreadPool();
        allAnimals.forEach(executorService::submit);
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void populateCell(Cell cell, Island island) {
        Random cellPopulationPicker = new Random();
        int goatCount = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);
        int wolfCount = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);
        int foxCount = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);
        int youngGoatCount = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);

        for (int i = 0; i < MAX_DEFAULT_ANIMAL_COUNT; i++) {

            animal = animalFactory.createAnimal(WOLF);
            animal = animalFactory.createAnimal(GOAT);
            animal = animalFactory.createAnimal(FOX);
            animal = animalFactory.createAnimal(YOUNGGOAT);

            goatCount++;
            youngGoatCount++;
            foxCount++;
            wolfCount++;


            animal.setPosition(cell);
            cell.addAnimal(animal);
            allAnimals.add(animal);

        }
        System.out.printf("Cell %s populated with %s animals%n", cell, wolfCount);

    }


    Double probability = EATING_PROBABILITY_CONFIG.getHuntSuccessProbabilityFor(wolf, goat);

    {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(String.format("%s tries to eat %s", WOLF, GOAT));
            if (random.nextDouble() < probability) {
                System.out.println(" successfully");
            } else {
                System.out.println(" and failed");
            }
        }
    }
}