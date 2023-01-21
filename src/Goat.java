import java.util.Properties;

import static java.lang.System.getProperties;

public class Goat extends Herbivorous {

    public Goat(AnimalProperties animalProperties) {
        super(animalProperties);
    }


    @Override
    protected double getEatableMass() {
        return getAnimalProperties().getWeight() * 0.4;
    }

    private AnimalProperties getAnimalProperties() {
        return getAnimalProperties();
    }

}
