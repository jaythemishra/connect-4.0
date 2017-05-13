import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MenuPanel extends JPanel implements ActionListener {
	
	Main w;
	
	public MenuPanel(Main w) {
		this.w = w;
		JButton instructionButton = new JButton("Instruction");
		JButton settingsButton = new JButton("Settings");
		JButton playButton = new JButton("Play Game");


		instructionButton.addActionListener(this);
		add(instructionButton);
		settingsButton.addActionListener(this);
		add(settingsButton);
		playButton.addActionListener(this);
		add(playButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel("instructions");
	}
	
}