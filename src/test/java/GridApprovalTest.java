import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;


class GridApprovalTest {

    // # initial state - an empty grid
    // a grid top left cell set to a string
    // a grid bottom right cell set to number
    // a full grid

    @Test
    void anEmptyGrid() {
        var grid = new MyBoundedGrid<String>(2, 3);
        Approvals.verify(grid);
    }
}