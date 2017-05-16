import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class MenuPanel extends JPanel implements ActionListener {
	
	Main w;
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 800;
	
	private JButton instructionButton, settingsButton, playButton;
	
	/**
	 * Creates a new MenuPanel object with a Play button to play the game, a Settings Button to go to the game settings, and an Instructions button to view the game instructions.
	 * @param w The Main object that this MenuPanel will be a part of.
	 */
	public MenuPanel(Main w) {
		this.w = w;
		instructionButton = new JButton("Instructions");
		settingsButton = new JButton("Settings");
		playButton = new JButton("Play Game");


		//instructionButton.addActionListener(this);
		//add(instructionButton);
		//settingsButton.addActionListener(this);
		//add(settingsButton);
		playButton.addActionListener(this);
		add(playButton);
		instructionButton.addActionListener(this);
		add(instructionButton);
		settingsButton.addActionListener(this);
		add(settingsButton);
	}
	
	/**
	 * The method that actually draws the menu.
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

	    g2.setBackground(Color.BLACK);
	    g2.setTransform(at);

		// TODO Add any custom drawings here
	  }
	
	/**
	 * Changes the panel to the game.
	 */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(playButton)) {
			w.changePanel("game");
		} else if(o.equals(instructionButton)) {
			w.changePanel("instructions");
		} else if(o.equals(settingsButton)) {
			w.changePanel("settings");
		}
	}
	
}