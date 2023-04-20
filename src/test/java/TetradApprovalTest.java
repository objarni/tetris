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
    void blockOne() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 1);
        Approvals.verify(tetrad);
    }

    @Test
    void blockTwo() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 2);
        Approvals.verify(tetrad);
    }

    @Test
    void blockThree() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 3);
        Approvals.verify(tetrad);
    }

    @Test
    void blockFour() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 4);
        Approvals.verify(tetrad);
    }

    @Test
    void blockFive() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 5);
        Approvals.verify(tetrad);
    }

    @Test
    void blockSix() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 6);
        Approvals.verify(tetrad);
    }
    @Test
    void blockSeven() {
        var grid = new Grid<Block>(10, 10);
        var tetrad = new Tetrad(grid, 7);
        Approvals.verify(tetrad);
    }
}
