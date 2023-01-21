public class AnimalFactory {

    public Animal createAnimal(AnimalProperties properties) {
        return properties.createAnimal();
    }
}
