import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class SettingsPanel extends JPanel implements ActionListener {
	
	Main w;
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 800;
	
	/**
	 * Creates a new SettingsPanel object with a back button to return to the menu.
	 * @param w The Main object that this SettingsPanel will be a part of.
	 */
	public SettingsPanel(Main w) {
		this.w = w;
		JButton backButton = new JButton("Back to Menu (THIS IS SETTINGS SCREEN)");
		//JButton rightButton = new JButton("Rotate 90� counterclockwise");
		//JButton bombButton = new JButton("Activate bomb");

		setBackground(Color.YELLOW);
		backButton.addActionListener(this);
		add(backButton);
		/*rightButton.addActionListener(this);
		add(rightButton);
		bombButton.addActionListener(this);
		add(bombButton);*/
	}
	
	/**
	 * Changes the panel back to the menu.
	 */
	public void actionPerformed(ActionEvent e) {
		w.changePanel("menu");
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


	    //g2.setBackground(Color.BLACK);
	    g2.setTransform(at);
	    
	    g2.setColor(Color.RED);
		g2.setFont(new Font("font", Font.BOLD, 75));
		g2.drawString("Settings", 50, 150);
		g2.setFont(new Font("font", Font.BOLD, 15));
		g2.drawString("To be completed.", 50, 250);
		
		




	  }
	
	
	
}