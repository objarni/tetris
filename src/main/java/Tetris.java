public class Tetris implements ArrowListener {
    Grid<Block> grid;
    BlockDisplay display;
    Tetrad activeTetrad;
    int points;
    int level;
    int speed;
    int rowsCompletedSet;
    int totalRowsCompleted;

    public Tetris() {
        grid = new Grid<Block>(30, 20);
        display = new BlockDisplay(grid);
        display.setArrowListener(this);
        points = 0;
        totalRowsCompleted = 0;
        level = 1;
        speed = 1000;
        rowsCompletedSet = 0;
        activeTetrad = new Tetrad(grid);
    }

    public static void main(String[] args) {
        Tetris game = new Tetris();
        game.display.setTitle("source.Tetris-- Level: " + 1 + "  Score: " + 0);
        game.display.showBlocks();
        game.play();
    }

    public void play() {
        boolean lost = false;
        try {
            while (lost != true) {
                boolean next = activeTetrad.translate(1, 0);
                if (next == false) {
                    clearCompletedRows();
                    clearCompletedRows();
                    clearCompletedRows();
                    rowsCompletedSet = 0;
                    if (totalRowsCompleted == 10) {
                        level++;
                        speed -= 200;
                        totalRowsCompleted = 0;
                    }
                    display.setTitle("source.Tetris-- Level: " + level + "  Score: " + points);
                    activeTetrad = new Tetrad(grid);
                    if (activeTetrad.translate(1, 0) == false) {
                        lost = true;
                        display.setArrowListener(null);
                        System.out.println("You lost!! How shameful...");
                    }
                }
                display.showBlocks();
                Thread.sleep(speed);
            }
        } catch (InterruptedException e) {
        }
    }

    private void clearCompletedRows() {
        for (int row = grid.getNumberOfRows(); row > -1; row--) {
            if (isCompletedRow(row)) {
                clearRow(row);
                rowsCompletedSet++;
                totalRowsCompleted++;
                if (rowsCompletedSet == 1) {
                    points = points + (level * 40);
                }
                if (rowsCompletedSet == 2) {
                    points = points + (level * 60);
                }
                if (rowsCompletedSet == 3) {
                    points = points + (level * 200);
                }
                if (rowsCompletedSet == 4) {
                    points = points + (level * 1000);
                }
            }
        }
    }

    private boolean isCompletedRow(int row) {
        for (int column = 0; column < grid.getNumberOfColumns(); column++) {
            Location location = new Location(row, column);
            if (grid.get(location) == null) {
                return false;
            }
        }
        return true;
    }

    private void clearRow(int rowToClear) {
        for (int column = 0; column < grid.getNumberOfColumns(); column++) {
            Location location = new Location(rowToClear, column);
            if (grid.get(location) != null) {
                grid.get(location).removeSelfFromGrid();
            }
        }
        for (int row = rowToClear - 1; row > -1; row--) {
            for (int column = 0; column < grid.getNumberOfColumns(); column++) {
                Location location = new Location(row, column);
                Location nextLocation = new Location(row + 1, column);
                if (grid.get(location) != null) {
                    grid.get(location).moveTo(nextLocation);
                }
            }
        }

    }

    public void upPressed() {
        activeTetrad.rotate();
        display.showBlocks();
    }

    public void downPressed() {
        activeTetrad.translate(1, 0);
        display.showBlocks();
    }

    public void leftPressed() {
        activeTetrad.translate(0, -1);
        display.showBlocks();
    }

    public void rightPressed() {
        activeTetrad.translate(0, 1);
        display.showBlocks();
    }

    public void spacePressed() {
        speed -= 15;
        activeTetrad.translate(1, 0);
        display.showBlocks();
    }
}
