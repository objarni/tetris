import java.util.ArrayList;

public class MyBoundedGrid<E> {
    private Object[][] occupantArray;

    public MyBoundedGrid(int rows, int cols) {
        occupantArray = new Object[rows][cols];
    }

    public int getNumRows() {
        return occupantArray.length;
    }

    public int getNumCols() {
        return occupantArray[1].length;
    }

    public boolean isValid(Location loc) {
        if (loc.getRow() < getNumRows() && loc.getCol() < getNumCols() && loc.getRow() >= 0 && loc.getCol() >= 0) {
            return true;
        } else return false;
    }

    public E get(Location loc) {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                if (i == loc.getRow() && j == loc.getCol()) {
                    return (E) occupantArray[i][j];
                }
            }
        }
        return null;
    }

    public E put(Location loc, E obj) {
        Object former = get(loc);
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                if (i == loc.getRow() && j == loc.getCol()) {
                    occupantArray[i][j] = obj;
                }
            }
        }
        return (E) former;
    }

    public E remove(Location loc) {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                if (i == loc.getRow() && j == loc.getCol()) {
                    Object former = occupantArray[i][j];
                    occupantArray[i][j] = null;
                    return (E) former;
                }
            }
        }
        return null;
    }

    public ArrayList<Location> getOccupiedLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                Location loc = new Location(i, j);
                if (get(loc) != null) {
                    locations.add(loc);
                }
            }
        }
        return locations;

    }
}