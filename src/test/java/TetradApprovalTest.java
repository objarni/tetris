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
    }

    @Test
    void blockI() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_I);
        Approvals.verify(tetrad);
    }

    @Test
    void blockTwo() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_O);
        Approvals.verify(tetrad);
    }

    @Test
    void blockThree() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_L);
        Approvals.verify(tetrad);
    }

    @Test
    void blockFour() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_J);
        Approvals.verify(tetrad);
    }

    @Test
    void blockFive() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_S);
        Approvals.verify(tetrad);
    }

    @Test
    void blockSix() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_Z);
        Approvals.verify(tetrad);
    }
    @Test
    void blockSeven() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, Tetrad.Block_T);
        Approvals.verify(tetrad);
    }
}
