import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	JPanel cardPanel;
	
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

	public static void main(String[] args)
	{
		Main w = new Main("Connect 4 Rotate");
	}
  
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}
  
}