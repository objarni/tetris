import org.approvaltests.Approvals;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;


@UseReporter(JunitReporter.class)
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

    @Test
    void doubleRotateBlock() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 6);

        tetrad.rotate();
        tetrad.rotate();

        Approvals.verify(tetrad);
    }

    @Test
    void blockI() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_I);
        Approvals.verify(tetrad);
    }

    @Test
    void blockT() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_T);
        Approvals.verify(tetrad);
    }

    @Test
    void blockO() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_O);
        Approvals.verify(tetrad);
    }

    @Test
    void blockJ() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_J);
        Approvals.verify(tetrad);
    }

    @Test
    void blockL() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_L);
        Approvals.verify(tetrad);
    }

    @Test
    void blockZ() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_Z);
        Approvals.verify(tetrad);
    }
}
