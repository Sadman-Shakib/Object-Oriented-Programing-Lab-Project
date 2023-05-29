import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class warning implements ActionListener {
	JFrame warning = new JFrame();
	JButton exit;
	
	public warning () {
		warning.setTitle("Warning");
		warning.setIconImage(new ImageIcon("src\\warningicon.png").getImage());
		warning.setResizable(false);
		warning.setSize(420, 160);
		warning.setLocationRelativeTo(null);
		warning.getContentPane().setBackground(Color.black);
		warning.setLayout(new FlowLayout());    
		
		JLabel img = new JLabel(new ImageIcon("src\\warning.png"));
		warning.add(img);
		JLabel text = new JLabel("No Action Will Procced. Currently You are in Home Page");
		
		text.setFont(new Font("monaco", Font.PLAIN, 12));
		text.setForeground(Color.red);
		text.setBounds(100, 100, 100, 50);
		
		exit = new JButton(new ImageIcon("src\\exit.png"));
		exit.setBorder(null); 
		exit.setBorderPainted(false);         // button er border gula invisible kore dilam
		exit.setContentAreaFilled(false); 
		exit.addActionListener(this);         // button er sathe action Listener add korlam
		warning.add(text);
		warning.add(exit);
		warning.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			warning.dispose(); // exit button press korle warning window close hoye jabe
			new MainWindow().setVisible(true);  // abar home age e fire jabar jnno jframe ke visible kore dilam
		}
	}
	
}
