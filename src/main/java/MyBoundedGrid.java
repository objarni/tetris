import java.util.ArrayList;
import java.util.List;

public class MyBoundedGrid<E> {
    private Object[][] occupantArray;

    public MyBoundedGrid(int rows, int columns) {
        occupantArray = new Object[rows][columns];
    }

    public int getNumberOfRows() {
        return occupantArray.length;
    }

    public int getNumberOfColumns() {
        return occupantArray[1].length;
    }

    public boolean isValid(Location location) {
        if (location.getRow() < getNumberOfRows() && location.getColumn() < getNumberOfColumns() && location.getRow() >= 0 && location.getColumn() >= 0) {
            return true;
        } else return false;
    }

    public E get(Location location) {
        for (int row = 0; row < getNumberOfRows(); row++) {
            for (int column = 0; column < getNumberOfColumns(); column++) {
                if (row == location.getRow() && column == location.getColumn()) {
                    return (E) occupantArray[row][column];
                }
            }
        }
        return null;
    }

    public E put(Location location, E element) {
        Object former = get(location);
        for (int row = 0; row < getNumberOfRows(); row++) {
            for (int column = 0; column < getNumberOfColumns(); column++) {
                if (row == location.getRow() && column == location.getColumn()) {
                    occupantArray[row][column] = element;
                }
            }
        }
        return (E) former;
    }

    public E remove(Location location) {
        for (int row = 0; row < getNumberOfRows(); row++) {
            for (int column = 0; column < getNumberOfColumns(); column++) {
                if (row == location.getRow() && column == location.getColumn()) {
                    Object former = occupantArray[row][column];
                    occupantArray[row][column] = null;
                    return (E) former;
                }
            }
        }
        return null;
    }

    public ArrayList<Location> getOccupiedLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();
        for (int row = 0; row < getNumberOfRows(); row++) {
            for (int column = 0; column < getNumberOfColumns(); column++) {
                Location location = new Location(row, column);
                if (get(location) != null) {
                    locations.add(location);
                }
            }
        }
        return locations;

    }

    @Override
    public String toString() {
        return String.format("A grid of %d rows %d columns. Content:\n%s", this.getNumberOfRows(), this.getNumberOfColumns(), printCells());
    }

    private String printCells() {
        List<String> rows = new ArrayList<>();
        for (var row : this.occupantArray) {
            rows.add(printRow(row));
        }
        return String.join("\n", rows);
    }

    private String printRow(Object[] theRow) {
        StringBuilder sb = new StringBuilder();
        for (var elem : theRow)
            sb.append((elem == null) ? "." : elem);
        return sb.toString();
    }
}