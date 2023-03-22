import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;


class TetradApprovalTest {

    @Test
    void initialTetrad() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 6);
        Approvals.verify(tetrad);
    }

    @Test
    void rotateBlock() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 6);

        tetrad.rotate();

        Approvals.verify(tetrad);
    }

}
