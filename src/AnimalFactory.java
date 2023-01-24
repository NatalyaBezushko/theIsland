


import java.util.Random;

public class AnimalFactory {
    Animal animal;
    private  int goat = 0;
    private int wolf = 0;
    private int fox = 0;

    public Animal createAnimal(AnimalType animalType) {

        switch (animalType) {
            case GOAT:
                animal = new Goat();
                goat++;
                break;
            case WOLF:
                animal = new Wolf();
                wolf++;
                break;
            case FOX:
                animal = new Fox();
                fox++;
                break;
        }
        System.out.println("Goats = " + goat + "Wolfs = " + wolf + "Foxes = " + fox);
        return animal;
    }
}




