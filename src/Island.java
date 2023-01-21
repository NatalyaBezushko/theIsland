import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Island {

    int xDimension;
    int yDimension;

    Cell[][] islandGrid;
    List <Animal> animalList = Collections.synchronizedList(new ArrayList<>());

    public Island(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.islandGrid = new Cell[xDimension][yDimension];
        for (int x = 0; x < xDimension; x++) {
            for (int y = 0; y < yDimension; y++) {
                islandGrid[x][y] = new Cell(x, y);
            }
        }
    }
}
