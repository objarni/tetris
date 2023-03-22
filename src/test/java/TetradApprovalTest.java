import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;


class TetradApprovalTest {

    @Test
    void initialTetrad() {
        var grid = new Grid<Block>(2, 3);
        var tetrad = new Tetrad(grid);
        Approvals.verify(tetrad);
    }

}
