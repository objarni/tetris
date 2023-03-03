import java.util.ArrayList;
import java.util.List;

public class MyBoundedGrid<E> {
    private final Object[][] occupantArray;

    public MyBoundedGrid(int rows, int columns) {
        occupantArray = new Object[rows][columns];
    }

    public int getNumberOfRows() {
        return occupantArray.length;
    }

    public int getNumberOfColumns() {
        return occupantArray[0].length;
    }

    public boolean isValid(Location location) {
        return location.getRow() < getNumberOfRows() &&
                location.getColumn() < getNumberOfColumns() &&
                location.getRow() >= 0 &&
                location.getColumn() >= 0;
    }

    public E get(Location location) {
        if (isValid(location)) {
            //noinspection unchecked
            return (E) occupantArray[location.getRow()][location.getColumn()];
        } else {
            return null;
        }
    }

    public E put(Location location, E element) {
        E former = get(location);
        if (isValid(location)){
            occupantArray[location.getRow()][location.getColumn()] = element;
        }
        return former;
    }

    public E remove(Location location) {
        E former = get(location);
        if (isValid(location)){
            occupantArray[location.getRow()][location.getColumn()] = null;
        }
        return former;
    }

    public ArrayList<Location> getOccupiedLocations() {
        ArrayList<Location> locations = new ArrayList<>();
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
        return String.format(
                "A grid of %d rows %d columns. Content:\n%s",
                this.getNumberOfRows(),
                this.getNumberOfColumns(),
                printCells()
        );
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