public class Fox extends Predator{
    public Fox(Cell properties) {
        super(properties);
    }

    public Fox() {

    }

    @Override
    protected double getEatableMass() {
        return 0;
    }
}
