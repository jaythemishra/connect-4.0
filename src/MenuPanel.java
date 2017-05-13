import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class MenuPanel extends JPanel implements ActionListener {
	
	Main w;
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 800;
	
	//private JButton instructionButton, settingsButton, playButton;
	
	public MenuPanel(Main w) {
		this.w = w;
		JButton instructionButton = new JButton("Instructions");
		JButton settingsButton = new JButton("Settings");
		JButton playButton = new JButton("Play Game");


		//instructionButton.addActionListener(this);
		//add(instructionButton);
		//settingsButton.addActionListener(this);
		//add(settingsButton);
		playButton.addActionListener(this);
		add(playButton);
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

	    g2.setBackground(Color.BLACK);
	    g2.setTransform(at);

		// TODO Add any custom drawings here
	  }
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel("game");
	}
	
}