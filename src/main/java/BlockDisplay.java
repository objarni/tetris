import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BlockDisplay implements KeyListener {
    private static final Color BACKGROUND = Color.WHITE;

    private Grid<Block> board;
    private JPanel[][] grid;
    private JFrame frame;
    private ArrowListener listener;

    public BlockDisplay(Grid<Block> board) {
        this.board = board;
        grid = new JPanel[board.getNumberOfRows()][board.getNumberOfColumns()];

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

        try {
            while (frame == null || !frame.isVisible())
                Thread.sleep(1);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    private void createAndShowGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(board.getNumberOfRows(), board.getNumberOfColumns()));
        frame.addKeyListener(this);

        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[row].length; column++) {
                grid[row][column] = new JPanel();
                grid[row][column].setBackground(BACKGROUND);
                grid[row][column].setPreferredSize(new Dimension(20, 20));
                frame.getContentPane().add(grid[row][column]);
            }

        showBlocks();

        frame.pack();
        frame.setVisible(true);

    }

    public void showBlocks() {
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[row].length; column++) {
                Location location = new Location(row, column);

                Block square = board.get(location);

                if (square == null) {
                    grid[row][column].setBackground(BACKGROUND);
                    grid[row][column].setBorder(null);
                } else {
                    grid[row][column].setBackground(square.getColor());
                    grid[row][column].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            }
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

    public void keyTyped(KeyEvent event) {
    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyPressed(KeyEvent event) {
        if (listener == null)
            return;
        int code = event.getKeyCode();
        if (code == KeyEvent.VK_LEFT)
            listener.leftPressed();
        else if (code == KeyEvent.VK_RIGHT)
            listener.rightPressed();
        else if (code == KeyEvent.VK_DOWN)
            listener.downPressed();
        else if (code == KeyEvent.VK_UP)
            listener.upPressed();
        else if (code == KeyEvent.VK_SPACE)
            listener.spacePressed();
    }

    public void setArrowListener(ArrowListener listener) {
        this.listener = listener;
    }
}
