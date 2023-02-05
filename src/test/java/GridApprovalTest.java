import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;


class GridApprovalTest {

    // # initial state - an empty grid
    // # a grid with top left cell set to letter A
    // # a grid bottom right cell set to number
    // A grid with Yellow Block in center

    @Test
    void anEmptyGrid() {
        var grid = new MyBoundedGrid<String>(2, 3);
        Approvals.verify(grid);
    }

    @Test
    void aGridWithTopLeftCellsSetToA() {
        var grid = new MyBoundedGrid<String>(2, 3);
        grid.put(new Location(0, 0), "A");
        Approvals.verify(grid);
    }

    @Test
    void aGridWithBottomRightCellsSetTo1() {
        var grid = new MyBoundedGrid<Integer>(2, 3);
        grid.put(new Location(1, 2), 1);
        Approvals.verify(grid);
    }

    @Test
    void aGridWithBlueBlockInCenter() {
        var grid = new MyBoundedGrid<Block>(3, 3);
        grid.put(new Location(1, 1), new Block());
        Approvals.verify(grid);
    }
}