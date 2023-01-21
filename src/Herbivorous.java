public abstract class Herbivorous extends Animal {
    public Herbivorous(AnimalProperties animalProperties) {
        super(animalProperties);
    }

    @Override
    protected void getFood() {
        System.out.println("Herbivorous started getting food" + getId());
        Cell position = this.getPosition();
        Vegetation vegetation = position.getVegetation();
        eat(vegetation);
        System.out.println("Herbivorous ate food" + getId());
    }
}
