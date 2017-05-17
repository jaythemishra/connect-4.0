import java.awt.event.*;
import javax.swing.*;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

import java.awt.*;

public class Main extends JFrame implements JayLayerListener {

	JPanel cardPanel;
	
	private JayLayer sound;
	
	private String[] songs;

	
	/**
	 * Creates a new Main object that runs the program.
	 * @param title The title of the window
	 */
	public Main(String title) {
		
		super(title);
		String[] songs = new String[]{"game1.mp3"};
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
	    
	    sound=new JayLayer("audio/","audio/",false);
		sound.addPlayList();
		sound.addSongs(0,songs);
		//sound.addSoundEffects(soundEffects);
		sound.changePlayList(0);
		sound.addJayLayerListener(this);
		sound.nextSong();

	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	/**
	 * Starts the program by creating a new main object.
	 * @param args The standard parameter for the main method.
	 */
	public static void main(String[] args)
	{
		Main w = new Main("Connect 4.0");
	}
  
	/**
	 * Switches the current panel that is showing on the screen.
	 * @param name The name of the panel that should be switched to.
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}

	@Override
	public void musicStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void musicStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playlistEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void songEnded() {
		// TODO Auto-generated method stub
		
	}
	
	
  
}