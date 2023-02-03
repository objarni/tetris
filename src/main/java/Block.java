import java.awt.*;

public class Block {
    private MyBoundedGrid<Block> grid;
    private Location location;
    private Color color;

    public Block() {
        color = Color.BLUE;
        grid = null;
        location = null;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public MyBoundedGrid<Block> getGrid() {
        return grid;
    }

    public Location getLocation() {
        return location;
    }

    public void removeSelfFromGrid() {
        grid.remove(location);
        grid = null;
        location = null;
    }

    public void putSelfInGrid(MyBoundedGrid<Block> grid, Location atLocation) {
        Block old = grid.get(atLocation);
        if (old != null) {
            old.grid = null;
            old.location = null;
        }
        this.grid = grid;
        location = atLocation;
        grid.put(atLocation, this);
    }

    public void moveTo(Location newLocation) {
        Location oldLocation = location;
        putSelfInGrid(grid, newLocation);
        grid.remove(oldLocation);
        grid.put(newLocation, this);

    }

    public String toString() {
        return "source.Block[location=" + location + ",color=" + color + "]";
    }
}