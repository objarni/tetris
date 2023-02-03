public class Location implements Comparable {
    private int row;
    private int column;

    public Location(int atRow, int atColumn) {
        row = atRow;
        column = atColumn;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Location))
            return false;

        Location otherLocation = (Location) other;
        return getRow() == otherLocation.getRow() && getColumn() == otherLocation.getColumn();
    }

    public int hashCode() {
        return getRow() * 3737 + getColumn();
    }

    public int compareTo(Object other) {
        Location otherLoc = (Location) other;
        if (getRow() < otherLoc.getRow())
            return -1;
        if (getRow() > otherLoc.getRow())
            return 1;
        if (getColumn() < otherLoc.getColumn())
            return -1;
        if (getColumn() > otherLoc.getColumn())
            return 1;
        return 0;
    }

    public String toString() {
        return "(" + getRow() + ", " + getColumn() + ")";
    }
}
