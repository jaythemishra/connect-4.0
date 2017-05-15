import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class GamePanel extends JPanel implements Runnable, MouseMotionListener, MouseListener
{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 800;

	private static final int RECT_HEIGHT = (DRAWING_HEIGHT - 100) / 7;
	private static final int RECT_WIDTH = (DRAWING_WIDTH - 100) / 7;

	private Rectangle screenRect;

	//private Tile mario;
	private Tile[][] tiles;
	private Rectangle[][] grid;
	private Color[][] colors;

	private boolean currentPlayer;

	private KeyHandler keyControl;

	/**
	 * Creates a new GamePanel object that initializes the 2D array that will hold all the game tiles and another 2D array to hold the rectangles that get drawn on the screen.
	 */
	public GamePanel () {
		super();
		currentPlayer = true;
		keyControl = new KeyHandler();
		setBackground(Color.WHITE);
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		tiles = new Tile[7][7];
		//tiles[4][4] = new Tile(true);
		grid = new Rectangle[7][7];
		colors = new Color[7][7];
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				grid[row][col] = new Rectangle(50 + row * RECT_WIDTH, 50 + col * RECT_HEIGHT, RECT_WIDTH, RECT_HEIGHT);
				colors[row][col]= Color.yellow;
			}
		}
		addMouseMotionListener(this);
		addMouseListener(this);
		new Thread(this).start();
	}

	/**
	 * The method that actually draws the game board and all the tiles on it, determining if the tiles should be red or black.
	 * @param g The Graphics object that allows the method to draw things on the screen.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		for (int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				// g2.draw(col);
				Rectangle r = grid[row][col];
				g2.setColor(colors[row][col]);
				g2.fill(r);
				g2.setColor(Color.WHITE);
				if(tiles[row][col] != null) {
					if(tiles[row][col].getPlayer() == true)
						g2.setColor(Color.RED);
					else
						g2.setColor(Color.BLACK);
				} else
					g2.setColor(Color.WHITE);

				g2.fillOval((int)r.getX() + 5, (int)r.getY() + 5, (int)r.getWidth() - 10, (int)r.getHeight() - 10);
			}
		}
		//mario.draw(g2,this);

		g2.setTransform(at);

		// TODO Add any custom drawings here
	}

	/**
	 * Adds a new tile to the first open spot in the specified column, updating the 2D array that holds all the tiles.
	 * @param col The column that the tile should be added to.
	 */
	public void addTile(int col) {
		for(int row = tiles.length - 1; row > -1; row--) {
			if(tiles[col-1][row] == null) {
				currentPlayer = !currentPlayer;
				tiles[col-1][row] = new Tile(currentPlayer);
				return;
			}
		}
	}

	/**
	 * Deletes all the tiles in a specified column.
	 * @param col The column from which all the tiles shall be deleted.
	 */
	public void deleteColumn(int col) {
		for(int i = 0; i < 7; i++) {
			tiles[col][i] = null;
		}
	}

	/**
	 * Returns whether the current player is Player 1 or Player 2.
	 * @return The corresponding number to the current player.
	 */
	public int playerInt() {
		if(currentPlayer)
			return 1;
		else
			return 2;
	}

	/**
	 * Determines if either player has won the game, and if they have, it creates a pop-up window that tells the players who has won.
	 * @return The player who has won.
	 */
	public boolean winner() {
		for(int row = 0; row < tiles.length; row++) {
			for(int col = 0; col < tiles[0].length; col++) {
				//int numInARow = 1;
				if(tiles[row][col] != null) {
					boolean player = tiles[row][col].getPlayer();
					try{
						if(tiles[row - 1][col].getPlayer() == player && tiles[row + 1][col].getPlayer() == player && tiles[row + 2][col].getPlayer() == player) {
							System.out.println("The winner is Player " + player);
							JOptionPane.showMessageDialog(this, "Game Over! Player " + playerInt() + " wins!");
							return player;
						}
					} catch(ArrayIndexOutOfBoundsException e) {

					} catch(NullPointerException e){}
					try{
						if(tiles[row][col - 1].getPlayer() == player && tiles[row][col + 1].getPlayer() == player && tiles[row][col + 2].getPlayer() == player) {
							System.out.println("The winner is Player " + player);
							JOptionPane.showMessageDialog(this, "Game Over! Player " + playerInt() + " wins!");
							return player;
						}
					} catch(ArrayIndexOutOfBoundsException e) {

					}	catch(NullPointerException e){}

					try{
						if(tiles[row - 1][col - 1].getPlayer() == player && tiles[row + 1][col + 1].getPlayer() == player && tiles[row + 2][col + 2].getPlayer() == player) {
							System.out.println("The winner is Player " + player);
							JOptionPane.showMessageDialog(this, "Game Over! Player " + playerInt() + " wins!");
							return player;
						}
					} catch(ArrayIndexOutOfBoundsException e) {

					} catch(NullPointerException e){}
					try{
						if(tiles[row - 1][col + 1].getPlayer() == player && tiles[row + 1][col - 1].getPlayer() == player && tiles[row + 2][col - 2].getPlayer() == player) {
							System.out.println("The winner is Player " + player);
							JOptionPane.showMessageDialog(this, "Game Over! Player " + playerInt() + " wins!");
							return player;
						}
					} catch(ArrayIndexOutOfBoundsException e) {

					} catch(NullPointerException e){}
				}
			}
		}
		return false;
	}


	/**
	 * Gets the keyControl field..
	 * @return The keyControl field.
	 */
	public KeyHandler getKeyHandler() {
		return keyControl;
	}

	/**
	 * Runs the animations.
	 */
	public void run() {
		while (true) { // Modify this to allow quitting
			long startTime = System.currentTimeMillis();

			/*if (keyControl.isPressed(KeyEvent.VK_1)) {
			currentPlayer = !currentPlayer;
	  		addTile(1, currentPlayer);
		} if (keyControl.isPressed(KeyEvent.VK_2)) {
			currentPlayer = !currentPlayer;
	  		addTile(2, currentPlayer);
		} if (keyControl.isPressed(KeyEvent.VK_3)) {
			currentPlayer = !currentPlayer;
	  		addTile(3, currentPlayer);
		} if (keyControl.isPressed(KeyEvent.VK_4)) {
			currentPlayer = !currentPlayer;
	  		addTile(4, currentPlayer);
		} if (keyControl.isPressed(KeyEvent.VK_5)) {
			currentPlayer = !currentPlayer;
	  		addTile(5, currentPlayer);
		} if (keyControl.isPressed(KeyEvent.VK_6)) {
			currentPlayer = !currentPlayer;
	  		addTile(6, currentPlayer);
		} if (keyControl.isPressed(KeyEvent.VK_7)) {
			currentPlayer = !currentPlayer;
	  		addTile(7, currentPlayer);
		}*/

			//mario.act(grid);

			//if (!screenRect.intersects(mario))
			//spawnNewMario();

			repaint();

			long waitTime = 17 - (System.currentTimeMillis()-startTime);
			try {
				if (waitTime > 0)
					Thread.sleep(waitTime);
				else
					Thread.yield();
			} catch (InterruptedException e) {}
		}
	}



	public class KeyHandler implements KeyListener {

		private ArrayList<Integer> keys;

		/**
		 * Creates a new KeyHandler object and initializes the keys field.
		 */
		public KeyHandler() {
			keys = new ArrayList<Integer>();
		}

		/**
		 * Method from the KeyListener interface.
		 */
		public void keyPressed(KeyEvent e) {
			keys.add(e.getKeyCode());
		}

		/**
		 * Method from the KeyListener interface that enables players to delete columns from the board.
		 */
		public void keyReleased(KeyEvent e) {
			Integer code = e.getKeyCode();
			while(keys.contains(code))
				keys.remove(code);
			if(e.getKeyCode() == KeyEvent.VK_1) {
				deleteColumn(0);
				winner();
			}
			if(e.getKeyCode() == KeyEvent.VK_2) {
				deleteColumn(1);
				winner();
			}
			if(e.getKeyCode() == KeyEvent.VK_3) {
				deleteColumn(2);
				winner();
			}
			if(e.getKeyCode() == KeyEvent.VK_4) {
				deleteColumn(3);
				winner();
			}
			if(e.getKeyCode() == KeyEvent.VK_5) {
				deleteColumn(4);
				winner();
			}
			if(e.getKeyCode() == KeyEvent.VK_6) {
				deleteColumn(5);
				winner();
			}
			if(e.getKeyCode() == KeyEvent.VK_7) {
				deleteColumn(6);
				winner();
			}
			if(e.getKeyCode() == KeyEvent.VK_8) {
				turnRight();

			}

		}

		/**
		 * Method from the KeyListener interface.
		 */
		public void keyTyped(KeyEvent e) {

		}

		/**
		 * Returns true if a key is pressed.
		 * @param code the code of the key that is being checked.
		 * @return true if the specified key is pressed, false otherwise.
		 */
		public boolean isPressed(int code) {
			return keys.contains(code);
		}
	}


	/**
	 * Method from the MouseListener interface.
	 */
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		for (int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {

				if(getMousePosition()!=null)
				{
					if(grid[row][col].contains(getMousePosition()))
					{
						//System.out.println(getMousePosition());

						// chnages the current select colum to GRAY
						for (int i = 0; i<grid.length; i++)
						{
							colors[row][i]=Color.gray;	
						}

						// Resets all other Colums back to YELLOW
						for(int k = 0; k<7; k++)
						{
							if(k!=row)
							{
								for(int j=0; j<7; j++)
								{
									colors[k][j]=Color.yellow;
								}
							}

						}
						repaint();
						break;
					}
				}
			}
		}
	}

	/**
	 * Method from the MouseListener interface.
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	/**
	 * Method from the MouseListener interface.
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method from the MouseListener interface.
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method from the MouseListener interface that allows players to add tiles to the board.
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		Point p = getMousePosition();
		if(p!=null)
		{
			for (int row = 0; row < grid.length; row++) {
				for(int col = 0; col < grid[0].length; col++) {
					if(grid[row][col].contains(p))
					{
						addTile(row+1);
						winner();
					}
				}
			}
		}






	}

	/**
	 * Method from the MouseListener interface.
	 */
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

/**
 * Rotates the board to the right 90 degrees 
 */
	public void turnRight()
	{
		Tile[][] temp= new Tile[7][7];

		for(int row = 6; row>=0; row--)
		{
			Tile[] hold= new Tile[7];
			for(int i = 0; i< 7; i++)
			{
				//System.out.println(tiles[i][row]);
				hold[i]= tiles[i][row];
			}
			
			for(int j =0; j<tiles[0].length; j++)
			{
						System.out.println(tiles[0][j]);
			}
			
			temp[6-row]=hold;
	
			
			//System.out.println("next row up");

		}
		
		tiles=temp;
		repaint();







	}
}
