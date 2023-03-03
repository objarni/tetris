import org.approvaltests.Approvals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;


class GridApprovalTest {

    @Test
    void anEmptyGrid() {
        var grid = new Grid<String>(2, 3);
        Approvals.verify(grid);
    }

    @Test
    void aGridWithTopLeftCellsSetToA() {
        var grid = new Grid<String>(2, 3);
        grid.put(new Location(0, 0), "A");
        Approvals.verify(grid);
    }

    @Test
    void aGridWithBottomRightCellsSetTo1() {
        var grid = new Grid<Integer>(2, 3);
        grid.put(new Location(1, 2), 1);
        Approvals.verify(grid);
    }

    @Test
    void aGridWithBlueBlockInCenter() {
        var grid = new Grid<Block>(3, 3);
        grid.put(new Location(1, 1), new Block());
        Approvals.verify(grid);
    }

    @Test
    void aGridWithAll7ColorsRepresented() {
        var grid = new Grid<Block>(1, 7);
        var colors = List.of(Color.RED,
                Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.GRAY,
                Color.MAGENTA,
                Color.CYAN
        );
        int column = 0;
        for (var color :
                colors) {
            Block block = new Block();
            block.setColor(color);
            grid.put(new Location(0, column++), block);
        }
        Approvals.verify(grid);
    }

    @Test
    void nullIsWhenYouAreOutsideOfBounds() {
        var grid = new Grid<Block>(3, 3);
        Block nullable = grid.get(new Location(-1, -1));
        Assertions.assertNull(nullable);
    }

    @Test
    void removeFromEmptyGrid() {
        var grid = new Grid<String>(2, 3);
        String result = grid.remove(new Location(0, 0));
        Assertions.assertNull(result);
    }

    @Test
    void removeGetsWhatYouPut() {
        var grid = new Grid<Integer>(2, 3);
        grid.put(new Location(1, 2), 10);
        int result = grid.remove(new Location(1, 2));
        Assertions.assertEquals(10, result);
    }

    @Test
    void removeOutsideGrid() {
        var grid = new Grid<Integer>(2, 3);
        grid.put(new Location(1, 2), 10);
        Object result = grid.remove(new Location(-1, -1));
        Assertions.assertNull(result);
    }

    @Test
    void putOnInvalidLocationSilentlyIgnoresElement() {
        var grid = new Grid<Integer>(2, 3);

        grid.put(new Location(-1, -1), 10);
        Approvals.verify(grid);
    }
}
