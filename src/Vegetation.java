public class Vegetation implements Eatable{

    public static final int MAX_VEGETATION_LEVEL = 200 * 15;

    public static final double GROW_FACTOR = 5;

    private double vegetation;

    public Vegetation(int nextInt) {
        this.vegetation = vegetation;
    }


    @Override
    public synchronized double consumeAsFood(double required) {
        if (vegetation >= required) {
            this.vegetation = this.vegetation - required;
            return required;
        }
        this.vegetation = 0;
         return this.vegetation;
    }

    public double getVegetation() {
        return vegetation;
    }

    public double grow() {
        if (vegetation < 1) {
            System.out.println("Cannot grow vegetation as there is no life here");
        }
        return vegetation = (int) (vegetation * GROW_FACTOR);


        }
    }
