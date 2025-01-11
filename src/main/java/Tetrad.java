import java.awt.*;

public class Tetrad {
    static int Block_I = 0;
    static int Block_tmp = 1;
    static int Block_L = 2;
    static int Block_J = 3;
    static int Block_Zold = 4;
    static int Block_O = 5;
    static int Block_Z = 6;

    private Block[] blocks;
    private Grid<Block> theGrid;

    public Tetrad(Grid<Block> grid) {
        initialize(grid, getRandomBlockNumber());
    }

    public Tetrad(Grid<Block> grid, int blockNumber) {
        initialize(grid, blockNumber);
    }

    private void initialize(Grid<Block> grid, int blockNumber) {

        blocks = new Block[4];
        theGrid = grid;

        Location[] locations = new Location[4];

        Block block1 = new Block();
        Block block2 = new Block();
        Block block3 = new Block();
        Block block4 = new Block();

        blocks[0] = block1;
        blocks[1] = block2;
        blocks[2] = block3;
        blocks[3] = block4;



        if (blockNumber == Block_I) {
            block1.setColor(Color.RED);
            block2.setColor(Color.RED);
            block3.setColor(Color.RED);
            block4.setColor(Color.RED);
            locations[0] = new Location(1, 4);
            locations[1] = new Location(0, 4);
            locations[2] = new Location(2, 4);
            locations[3] = new Location(3, 4);
        }
        if (blockNumber == Block_tmp) {
            block1.setColor(Color.BLUE);
            block2.setColor(Color.BLUE);
            block3.setColor(Color.BLUE);
            block4.setColor(Color.BLUE);
            locations[0] = new Location(0, 4);
            locations[1] = new Location(0, 3);
            locations[2] = new Location(0, 5);
            locations[3] = new Location(1, 4);
        }

        if (blockNumber == Block_O) {
            block1.setColor(Color.GREEN);
            block2.setColor(Color.GREEN);
            block3.setColor(Color.GREEN);
            block4.setColor(Color.GREEN);
            locations[0] = new Location(0, 4);
            locations[1] = new Location(0, 5);
            locations[2] = new Location(1, 4);
            locations[3] = new Location(1, 5);
        }

        if (blockNumber == Block_L) {
            block1.setColor(Color.YELLOW);
            block2.setColor(Color.YELLOW);
            block3.setColor(Color.YELLOW);
            block4.setColor(Color.YELLOW);
            locations[0] = new Location(2, 4);
            locations[1] = new Location(1, 4);
            locations[2] = new Location(0, 4);
            locations[3] = new Location(2, 5);
        }

        if (blockNumber == Block_J) {
            block1.setColor(Color.GRAY);
            block2.setColor(Color.GRAY);
            block3.setColor(Color.GRAY);
            block4.setColor(Color.GRAY);
            locations[0] = new Location(2, 5);
            locations[1] = new Location(1, 5);
            locations[2] = new Location(0, 5);
            locations[3] = new Location(2, 4);
        }

        if (blockNumber == Block_Zold) {
            block1.setColor(Color.MAGENTA);
            block2.setColor(Color.MAGENTA);
            block3.setColor(Color.MAGENTA);
            block4.setColor(Color.MAGENTA);
            locations[0] = new Location(1, 4);
            locations[1] = new Location(0, 5);
            locations[2] = new Location(0, 4);
            locations[3] = new Location(1, 3);
        }

        if (blockNumber == Block_Z) {
            block1.setColor(Color.CYAN);
            block2.setColor(Color.CYAN);
            block3.setColor(Color.CYAN);
            block4.setColor(Color.CYAN);
            locations[0] = new Location(0, 4);
            locations[1] = new Location(0, 3);
            locations[2] = new Location(1, 4);
            locations[3] = new Location(1, 5);
        }
        addToLocations(grid, locations);
    }

    private void addToLocations(Grid<Block> grid, Location[] locations) {
        for (int blockIndex = 0; blockIndex < blocks.length; blockIndex++) {
            blocks[blockIndex].putSelfInGrid(grid, locations[blockIndex]);
        }

    }

    private int getRandomBlockNumber() {
        int randomNumber = (int) (Math.random() * 7);
        return randomNumber;
    }

    private Location[] removeBlocks() {
        Location[] oldBlocks = new Location[blocks.length];
        for (int blockIndex = 0; blockIndex < blocks.length; blockIndex++) {
            oldBlocks[blockIndex] = blocks[blockIndex].getLocation();
        }
        for (int blockIndex = 0; blockIndex < blocks.length; blockIndex++) {
            blocks[blockIndex].removeSelfFromGrid();
        }
        return oldBlocks;
    }

    private boolean areEmpty(Grid<Block> grid, Location[] locations) {
        for (int locationIndex = 0; locationIndex < locations.length; locationIndex++) {
            if (!grid.isValid(locations[locationIndex]) || grid.get(locations[locationIndex]) != null) {
                return false;
            }
        }
        return true;
    }

    public boolean translate(int deltaRow, int deltaColumn) {
        Location[] newLocations = new Location[4];
        for (int blockIndex = 0; blockIndex < blocks.length; blockIndex++) {
            int newRow = blocks[blockIndex].getLocation().getRow() + deltaRow;
            int newColumn = blocks[blockIndex].getLocation().getColumn() + deltaColumn;
            Location newLocation = new Location(newRow, newColumn);
            newLocations[blockIndex] = newLocation;
        }
        Location[] oldLocations = removeBlocks();
        if (areEmpty(theGrid, newLocations)) {
            addToLocations(theGrid, newLocations);
            return true;
        } else {
            addToLocations(theGrid, oldLocations);
            return false;
        }
    }

    public boolean rotate() {
        Location[] newLocations = new Location[4];
        for (int blockIndex = 0; blockIndex < blocks.length; blockIndex++) {
            int newRow = blocks[0].getLocation().getRow() - blocks[0].getLocation().getColumn() + blocks[blockIndex].getLocation().getColumn();
            int newColumn = blocks[0].getLocation().getColumn() + blocks[0].getLocation().getRow() - blocks[blockIndex].getLocation().getRow();
            Location newLocation = new Location(newRow, newColumn);
            newLocations[blockIndex] = newLocation;
        }
        Location[] oldLocations = removeBlocks();
        if (areEmpty(theGrid, newLocations)) {
            addToLocations(theGrid, newLocations);
            return true;
        } else {
            addToLocations(theGrid, oldLocations);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Tetrad:\n"
                + "Grid: " + theGrid.toString();
    }

}
