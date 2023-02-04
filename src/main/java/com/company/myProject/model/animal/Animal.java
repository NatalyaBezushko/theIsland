package com.company.myProject.model.animal;

import com.company.myProject.model.Eatable;
import com.company.myProject.Island.Cell;
import com.company.myProject.Island.Direction;
import com.company.myProject.Island.Island;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class Animal implements Eatable {

    private final AnimalProperties properties;
    public double currentStomachLevel;
    public int daysWithoutFood;
    private boolean alive;
    private UUID id;
    private Island island;
    private Cell position;
    private AtomicInteger movesCount;


    public Animal(AnimalProperties properties, Cell currentPosition) {
        this.properties = properties;
        this.currentStomachLevel = properties.maxStomachCapacity / 2;
        this.id = UUID.randomUUID();
        this.daysWithoutFood = -1;
        this.alive = true;
        this.position = currentPosition;
        this.island = Island.getInstance();
    }

    public void dailyRoutine() {
        System.out.println("Starts daily routine" + id);
        if(!alive) {
            System.out.println("is dead" + id);
        }
        move();
        getFood();
        System.out.println("Breed = " );
    }

    public void move() {
        System.out.printf("Animal [%s] started moving. Current position - %s %n", this, position);
        Random moveDecider = new Random();
        for (int i = 0; i < properties.getRange(); i++) {
            boolean moveDecision = moveDecider.nextBoolean();

            if (moveDecision) {
                System.out.println("Animal will move...");
                moveToOtherCell();

            } else {
                System.out.println("Animal decided to stay here for now...");
            }
        }
        System.out.println("Animal finished his moving turn!");
        System.out.println("Current position - " + position);
        movesCount.incrementAndGet();
    }

    private void moveToOtherCell() {

        Random directionPicker = new Random();
        Direction[] directions = Direction.values();
        Direction direction;
        do {
            direction = directions[directionPicker.nextInt(directions.length)];

        } while (!directionValid(direction));
        changePosition(direction);

    }

    private boolean directionValid(Direction direction) {
        System.out.println("Picking direction...");
        switch (direction) {
            case UP: {
                return position.getY() - 1 > 0;
            }
            case DOWN: {
                return position.getY() + 1 < island.yDimension;
            }
            case LEFT: {
                return position.getX() - 1 > 0;
            }
            case RIGHT: {
                return position.getX() + 1 < island.xDimension;
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    private void changePosition(Direction direction) {
        System.out.println("Animal changes position...");

        int newX = -1;
        int newY = -1;
        switch (direction) {
            case UP: {
                newX = position.getX();
                newY = position.getY() - 1;
                break;
            }
            case DOWN: {
                newX = position.getX();
                newY = position.getY() + 1;
                break;
            }
            case LEFT: {
                newX = position.getX() - 1;
                newY = position.getY();
                break;
            }
            case RIGHT: {
                newX = position.getX() + 1;
                newY = position.getY();
            }
        }
        Cell newCell = island.islandGrid[newX][newY];
        this.position.removeAnimal(this);
        this.position = newCell;
        this.position.addAnimal(this);
        System.out.println("Position changed...");


    }

    private void consumeEnergy(){
        currentStomachLevel = currentStomachLevel - properties.getDailyEnergyConsumption();
        if (currentStomachLevel <= 0) {
            currentStomachLevel = 0;
            daysWithoutFood++;
            if (daysWithoutFood == 0) {
                System.out.println("Started starving" + id);
            } else {
                System.out.println("Starving");
            }
        }
        if(daysWithoutFood > properties.getDeathFromStarvingAfter()) {
            System.out.println("Died from starving" + id);
            if (!position.removeAnimal(this))  {
                System.out.println("Could not even remove dead guy from cell");
            }
            alive = false;
        }
    }

    public abstract void getFood();

    protected void eat(Eatable eatable) {
        double consumed = eatable.consumeAsFood(properties.getMaxStomachCapacity());
        currentStomachLevel = currentStomachLevel + consumed;
        if (currentStomachLevel >= properties.getMaxStomachCapacity()) {
            currentStomachLevel = properties.getMaxStomachCapacity();
        }
        daysWithoutFood = -1;
    }

    public synchronized double consumeAsFood(double required) {
        double consumed;
        if (getEatableMass() >= required) {
            consumed = required;
        } else {
            consumed = getEatableMass();
        }
        this.alive = false;
        this.position.removeAnimal(this);
        return consumed;
    }

    protected abstract double getEatableMass();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return id.equals(animal.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                '}';
    }


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public UUID getId() {
        return id;
    }

    public Cell getPosition() {
        return this.position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }
}
