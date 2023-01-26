package com.company.myProject.Animal;



public class Wolf extends Predator {
    public Wolf(Cell properties) {
        super(properties);
    }

    public Wolf() {
        super();
    }

    @Override
    protected double getEatableMass() {
        return 0;
    }

}
