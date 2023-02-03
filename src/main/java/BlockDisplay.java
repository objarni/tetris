import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Used to display the contents of a game board
public class BlockDisplay implements KeyListener
{
	private static final Color BACKGROUND = Color.WHITE;

	private MyBoundedGrid<Block> board;
	private JPanel[][] grid;
	private JFrame frame;
	private ArrowListener listener;

	public BlockDisplay(MyBoundedGrid<Block> board)
	{
		this.board = board;
		grid = new JPanel[board.getNumRows()][board.getNumCols()];

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });

	    try
        {
        	while (frame == null || !frame.isVisible())
        		Thread.sleep(1);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

    private void createAndShowGUI()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(board.getNumRows(), board.getNumCols()));
        frame.addKeyListener(this);

	    for (int row = 0; row < grid.length; row++)
        	for (int col = 0; col < grid[row].length; col++)
        	{
				grid[row][col] = new JPanel();
				grid[row][col].setBackground(BACKGROUND);
				grid[row][col].setPreferredSize(new Dimension(20, 20));
				frame.getContentPane().add(grid[row][col]);
			}

		showBlocks();

        frame.pack();
        frame.setVisible(true);
    }

	public void showBlocks()
	{
		for (int row = 0; row < grid.length; row++)
			for (int col = 0; col < grid[row].length; col++)
			{
				Location loc = new Location(row, col);

				Block square = board.get(loc);

				if (square == null)
				{
					grid[row][col].setBackground(BACKGROUND);
					grid[row][col].setBorder(null);
				}
				else
				{
					grid[row][col].setBackground(square.getColor());
					grid[row][col].setBorder(BorderFactory.createLineBorder(BACKGROUND));
				}
			}
	}

	public void setTitle(String title)
	{
		frame.setTitle(title);
	}

	public void keyTyped(KeyEvent e)
	{
	}

	public void keyReleased(KeyEvent e)
	{
	}

	public void keyPressed(KeyEvent e)
	{
		if (listener == null)
			return;
		int code = e.getKeyCode();
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

	public void setArrowListener(ArrowListener listener)
	{
		this.listener = listener;
	}
}
