import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class TetradApprovalTest {

    @Test
    void initialTetrad() {
        var grid = new Grid<Block>(2, 3);
        var tetrad = new Tetrad(grid, 6);
        Approvals.verify(tetrad);
    }

}
