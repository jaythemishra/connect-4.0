import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	JPanel cardPanel;
	
	/**
	 * Creates a new Main object that runs the program.
	 * @param title The title of the window
	 */
	public Main(String title) {
		super(title);
		setBounds(100, 100, 800, 800);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		MenuPanel menu = new MenuPanel(this);
		InstructionPanel instructions = new InstructionPanel(this);
		SettingsPanel settings = new SettingsPanel(this);

	    GamePanel game = new GamePanel();
	    
	    addKeyListener(game.getKeyHandler());
	
	    cardPanel.add(menu,"menu");
	    cardPanel.add(instructions,"instructions");
	    cardPanel.add(settings,"settings");
	    cardPanel.add(game,"game");
	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	/**
	 * Starts the program by creating a new main object.
	 * @param args The standard parameter for the main method.
	 */
	public static void main(String[] args)
	{
		Main w = new Main("Connect 4 Rotate");
	}
  
	/**
	 * Switches the current panel that is showing on the screen.
	 * @param name The name of the panel that should be switched to.
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}
  
}