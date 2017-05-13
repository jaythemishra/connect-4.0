import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class SettingsPanel extends JPanel implements ActionListener {
	
	Main w;
	
	public SettingsPanel(Main w) {
		this.w = w;
		JButton backButton = new JButton("Back to Menu (This is Settings)");
		//JButton rightButton = new JButton("Rotate 90° counterclockwise");
		//JButton bombButton = new JButton("Activate bomb");


		backButton.addActionListener(this);
		add(backButton);
		/*rightButton.addActionListener(this);
		add(rightButton);
		bombButton.addActionListener(this);
		add(bombButton);*/
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel("menu");
	}
	
}