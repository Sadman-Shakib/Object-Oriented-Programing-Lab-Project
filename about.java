import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class about {
	
	static JFrame f;
	
	public about() {
		f = new JFrame("About Project");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(new ImageIcon("src\\mainlogo.png").getImage());
		f.setLayout(null);
		f.setBounds(0, 0, 450, 300);
		f.getContentPane().setBackground(Color.black);
		
		String myText = "Tic-Tac-Toe game is a compact and engaging "
				+ "project that brings the classic game to life. It offers a "
				+ "minimalist interface with a n X n grid where players can"
				+ " strategically place their symbols to win. The game is designed "
				+ "to be easy to play, understand, and enjoy, making it suitable for "
				+ "players of all skill levels. With its simplicity and straightforwardness, "
				+ "our Tic-Tac-Toe game is the perfect choice for a quick and e"
				+ "ntertaining gaming experience.";
	
		
		JLabel text = new JLabel("<html>" + myText + "</html>");
		
		text.setFont(new Font("monaco", Font.PLAIN, 12));
		text.setForeground(Color.white);
		text.setBounds(0, 10, 450, 200);
		text.setVerticalTextPosition(JLabel.TOP);
		f.add(text);
		
		JLabel aboutIcon = new JLabel(new ImageIcon("src\\about.png"));
		aboutIcon.setBounds(0, 0, 450, 50);
		f.add(aboutIcon);
		f.setResizable(false);
		f.add(new control(0, 220, 450, 50, 4).getControlButton());
		f.setLocationRelativeTo(null);
		
		JLabel developer = new JLabel(">> Developed by Sadman Sakib <<");
		developer.setFont(new Font("monaco", Font.PLAIN, 12));
		developer.setForeground(Color.green);
		developer.setBounds(0, 85, 450, 200);
		developer.setVerticalTextPosition(JLabel.TOP);
		developer.setHorizontalAlignment(JLabel.CENTER);
		f.add(developer);
		
		
		JLabel date = new JLabel("Object Oriented Programing Lab - (30/May/2023)");
		date.setFont(new Font("monaco", Font.PLAIN, 12));
		date.setForeground(Color.yellow);
		date.setBounds(0, 100, 450, 200);
		date.setVerticalTextPosition(JLabel.TOP);
		date.setHorizontalAlignment(JLabel.CENTER);
		f.add(date);
		
		f.setVisible(true);
	}
}
