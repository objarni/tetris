import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;


class GridApprovalTest {

    // # initial state - an empty grid
    // a grid with top left cell set to letter A
    // a grid bottom right cell set to number
    // a full grid

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
}