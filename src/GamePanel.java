import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class GamePanel extends JPanel implements Runnable
{
  public static final int DRAWING_WIDTH = 800;
  public static final int DRAWING_HEIGHT = 800;
  
  private static final int RECT_HEIGHT = (DRAWING_HEIGHT - 100) / 7;
  private static final int RECT_WIDTH = (DRAWING_WIDTH - 100) / 7;

  private Rectangle screenRect;
	
  private TileMario mario;
  private Rectangle[][] grid;

  
  private KeyHandler keyControl;


  public GamePanel () {
	  super();
	  
	  keyControl = new KeyHandler();
	  setBackground(Color.WHITE);
	  screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
	  grid = new Rectangle[7][7];
	  for(int row = 0; row < grid.length; row++) {
		  for(int col = 0; col < grid[0].length; col++) {
			  grid[row][col] = new Rectangle(50 + row * RECT_WIDTH, 50 + col * RECT_HEIGHT, RECT_WIDTH, RECT_HEIGHT);
		  }
	  }
	  spawnNewMario();
	  new Thread(this).start();
  }

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

    for (Rectangle[] row : grid) {
    	for(Rectangle col : row) {
    	   // g2.draw(col);
    	    g2.setColor(Color.YELLOW);
    		g2.fill(col);
    	    g2.setColor(Color.WHITE);
    		g2.fillOval((int)col.getX() + 5, (int)col.getY() + 5, (int)col.getWidth() - 10, (int)col.getHeight() - 10);
    	}
    }
    //mario.draw(g2,this);
    
    g2.setTransform(at);

	// TODO Add any custom drawings here
  }

  
  public void spawnNewMario() {
	  mario = new TileMario(DRAWING_WIDTH/2-TileMario.MARIO_WIDTH/2,50);
  }
  
  public KeyHandler getKeyHandler() {
	  return keyControl;
  }


  public void run() {
	while (true) { // Modify this to allow quitting
		long startTime = System.currentTimeMillis();
		
		if (keyControl.isPressed(KeyEvent.VK_LEFT))
	  		mario.walk(-1);
		if (keyControl.isPressed(KeyEvent.VK_RIGHT))
	  		mario.walk(1);
		if (keyControl.isPressed(KeyEvent.VK_UP))
	  		mario.jump();
	
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

	  public KeyHandler() {
		  keys = new ArrayList<Integer>();
	  }

	  public void keyPressed(KeyEvent e) {
		  keys.add(e.getKeyCode());
	  }

	  public void keyReleased(KeyEvent e) {
		  Integer code = e.getKeyCode();
		  while(keys.contains(code))
			  keys.remove(code);
	  }

	  public void keyTyped(KeyEvent e) {

	  }
	  
	  public boolean isPressed(int code) {
		  return keys.contains(code);
	  }
  }


}
