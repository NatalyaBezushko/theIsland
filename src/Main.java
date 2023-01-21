import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static int MAX_DEFAULT_ANIMAL_COUNT = 3;

    private static int SIMULATION_DURATION = 10;

    public static AtomicInteger movesCount = new AtomicInteger(0);

    private static List<Animal> allAnimals = new ArrayList<>();

    AnimalProperties stomachCapacity;

    public static void main(String[] args) {

        Island island = new Island(5, 3);

        populateIsland(island);
        System.out.println("Total animals = " + allAnimals.size());
        int dayCount = 0;
        do {
            startDay();
            dayCount++;
        } while (dayCount < SIMULATION_DURATION);

        System.out.println("Simulation finished");
        System.out.println("Total moves done = " + movesCount.toString());
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
        int animalCount = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);

        for (int i = 0; i < animalCount; i++) {
            Animal animal = new Animal(island) {
                @Override
                protected void getFood() {

                }

                @Override
                protected double getEatableMass() {
                    return 0;
                }
            };
            animal.setPosition(cell);
            cell.addAnimal(animal);
            allAnimals.add(animal);
        }
        System.out.printf("Cell %s populated with %s animals%n", cell, animalCount);
    }
}
