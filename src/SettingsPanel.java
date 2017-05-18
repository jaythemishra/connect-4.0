import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class SettingsPanel extends JPanel implements ActionListener {
	
	Main w;
	
	GamePanel game;
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 800;
	
	private JButton backButton, toggleRotation, toggleRowDeletion, toggleColumnDeletion;
	/**
	 * Creates a new SettingsPanel object with a back button to return to the menu.
	 * @param w The Main object that this SettingsPanel will be a part of.
	 */
	public SettingsPanel(Main w, GamePanel game) {
		this.w = w;
		this.game = game;
		backButton = new JButton("Back to Menu");
		toggleRotation = new JButton("Turn off Board Rotation");
		toggleRowDeletion = new JButton("Turn off Row Deletion");
		toggleColumnDeletion = new JButton("Turn off Column Deletion");


		setBackground(Color.YELLOW);
		backButton.addActionListener(this);
		add(backButton);
		toggleRotation.addActionListener(this);
		add(toggleRotation);
		toggleRowDeletion.addActionListener(this);
		add(toggleRowDeletion);
		toggleColumnDeletion.addActionListener(this);
		add(toggleColumnDeletion);
	}
	
	/**
	 * Changes the visible JPanel back to the menu and toggles game features based on what buttons the players push.
	 */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(backButton)) {
			w.changePanel("menu");
		} else if(o.equals(toggleRotation)) {
			game.toggleRotation();
			if(game.getRotation()) {
				toggleRotation.setText("Turn off Board Rotation");
			} else {
				toggleRotation.setText("Turn on Board Rotation");
			}
			repaint();
		} else if(o.equals(toggleRowDeletion)) {
			game.toggleRowDeletion();
			if(game.getRowDelete()) {
				toggleRowDeletion.setText("Turn off Row Deletion");
			} else {
				toggleRowDeletion.setText("Turn on Row Deletion");
			}
			repaint();

		} else if(o.equals(toggleColumnDeletion)) {
			game.toggleColumnDeletion();
			if(game.getColumnDelete()) {
				toggleColumnDeletion.setText("Turn off Column Deletion");
			} else {
				toggleColumnDeletion.setText("Turn on Column Deletion");
			}
			repaint();
		}
	}
	
	/**
	 * Draws the current status of the game settings.
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


	    //g2.setBackground(Color.BLACK);
	    g2.setTransform(at);
	    
	    g2.setColor(Color.RED);
		g2.setFont(new Font("font", Font.BOLD, 75));
		g2.drawString("Settings", 50, 150);
		g2.setFont(new Font("font", Font.BOLD, 30));
		
		if(game.getRotation())
			g2.drawString("Board Rotation is currently ON", 50, 250);
		else
			g2.drawString("Board Rotation is currently OFF", 50, 250);
		
		if(game.getRowDelete())
			g2.drawString("Row Deletion is currently ON", 50, 300);
		else
			g2.drawString("Row Deletion is currently OFF", 50, 300);
		
		if(game.getColumnDelete())
			g2.drawString("Column Deletion is currently ON", 50, 350);
		else
			g2.drawString("Column Deletion is currently OFF", 50, 350);


	  }
	
	
	
}