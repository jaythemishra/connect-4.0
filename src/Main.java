import java.awt.event.*;
import javax.swing.*;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

import java.awt.*;

public class Main extends JFrame implements JayLayerListener {

	JPanel cardPanel;
	
	private JayLayer sound1, sound2, sound3;
	
	private String[] songs1, songs2, songs3;

	
	/**
	 * Creates a new Main object that runs the program.
	 * @param title The title of the window
	 */
	public Main(String title) {
		
		super(title);
		songs1 = new String[]{"menu.mp3"};
		songs2 = new String[]{"game.mp3"};
		songs3 = new String[]{"winner.mp3"};
		setBounds(100, 100, 800, 800);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		MenuPanel menu = new MenuPanel(this);
		InstructionPanel instructions = new InstructionPanel(this);

	    GamePanel game = new GamePanel(this);
		SettingsPanel settings = new SettingsPanel(this, game);
	    
	    addKeyListener(game.getKeyHandler());
	
	    cardPanel.add(menu,"menu");
	    cardPanel.add(instructions,"instructions");
	    cardPanel.add(settings,"settings");
	    cardPanel.add(game,"game");
	    
	    sound1 = new JayLayer("audio/","audio/",false);
		sound1.addPlayList();
		sound1.addSongs(0,songs1);
		//sound.addSoundEffects(soundEffects);
		sound1.changePlayList(0);
		sound1.addJayLayerListener(this);
		sound1.nextSong();
		
		sound2 = new JayLayer("audio/","audio/",false);
		sound2.addPlayList();
		sound2.addSongs(0,songs2);
		//sound.addSoundEffects(soundEffects);
		sound2.changePlayList(0);
		sound2.addJayLayerListener(this);
		//sound1.nextSong();
		
		sound3 = new JayLayer("audio/","audio/",false);
		sound3.addPlayList();
		sound3.addSongs(0,songs3);
		//sound.addSoundEffects(soundEffects);
		sound3.changePlayList(0);
		sound3.addJayLayerListener(this);

	    
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
	
	/**
	 * Switches the music to the next song when the players begin the game.
	 */
	public void switchSong() {
		sound1.stopSong();
		sound2.nextSong();
	}
	
	/**
	 * Plays the victory music when a player wins the game.
	 */
	public void winnerSong() {
		sound2.stopSong();
		sound3.nextSong();
	}

	@Override
	/**
	 * Inherited abstract method from JayLayerListener.
	 */
	public void musicStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Inherited abstract method from JayLayerListener.
	 */
	public void musicStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Inherited abstract method from JayLayerListener.
	 */
	public void playlistEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Inherited abstract method from JayLayerListener.
	 */
	public void songEnded() {
		// TODO Auto-generated method stub
		
	}
	
	
  
}