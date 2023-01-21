import java.util.List;
import java.util.Random;

public abstract class Predator extends Animal{

    public Predator(AnimalProperties properties) {
        super(properties);
    }

    @Override
    protected void getFood() {
        System.out.println("Herbivorous started getting food" + getId());
        Cell position = this.getPosition();
        List<Animal>  animalList;
        animalList = (List<Animal>) position.getAnimalList().stream()
                .filter(animal -> animal instanceof Herbivorous);
        if (animalList.size() <= 1) {
            return;
        }
        eat(animalList.get(new Random().nextInt(animalList.size() - 1)));
        System.out.println("Herbivorous ate food" + getId());
    }
}
