import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;

public class GameOver {
	
	static JFrame f; 
	static String flag = "draw"; /*default vabe game draw flag set kora thakbe jdi kono player
								   win hoy taile game window theke etar flag change hoye jabe  */ 
	static int index;
	
	public GameOver(int n, int frameWidth, int frameHeight, int playerID, int idx) {
		
		f = new JFrame("GameOver");
		f.setBounds(0, 0, frameWidth, frameWidth + 50); 
		f.setIconImage(new ImageIcon("src\\mainlogo.png").getImage());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setResizable(false);
		f.add(new control(0, 0, frameWidth, 50, 3).getControlButton());  // home or exit korar jnno
		f.getContentPane().setBackground(Color.black);

		String [] playerIcon = new String[3];     // win hobar por winner er icon print korar jnno
		
		playerIcon[0] = "src\\draw.png";
		playerIcon[1] = "src\\winplayer1.png";
		playerIcon[2] = "src\\winplayer1.png";

		JButton [][] buttonPan = new JButton[n][n];   
		JPanel btnPan = new  JPanel();
		
		btnPan.setLayout(null);
		btnPan.setBounds(0, 50, frameWidth, frameWidth - 80);
		
		int posX = 45, posY = 3;

		Border border = BorderFactory.createLineBorder(Game.colors[idx], 1);

		for(int i = 0, rightIndex = n - 1; i < n; i++, rightIndex--) {
			for(int j = 0; j < n; j++, posX += Game.size[idx]) {

				/* game er button gula print korbo 
				exactly game jekhane exit hoiche tokhonkar
				button state print korar jnno  */

				/* ekhane Game class er property gula use korbo karon amr
				 game window er exact same state lagbe ei frame e */

				Game.button[i][j] = new JButton();
				Game.button[i][j].setBorder(border);
				Game.button[i][j].setContentAreaFilled(false);
				Game.button[i][j].setBounds(posX, posY, Game.size[idx], Game.size[idx]);
				
				// ekhane icon alada alada icon set kora lagbe jdi kono row ba collum winner collum or row er sathe 
				// mile jai taile oi button er color arrow icon diye set korte hbe

				if(flag == "rowWin" && i == index) {
					Game.button[i][j].setIcon(new ImageIcon("src\\rightsmall.png"));
				}
				else if(flag == "collumWin" && j == index) {
					Game.button[i][j].setIcon(new ImageIcon("src\\downsmall.png"));
				}
				else if(flag == "mainDigWin" && i == j) {
					Game.button[i][j].setIcon(new ImageIcon("src\\maindigsmall.png"));
				}
				else if(flag == "secondDigWin" && j == rightIndex) {
					Game.button[i][j].setIcon(new ImageIcon("src\\seconddigsmall.png"));
				}
				else {
					if(Game.save[i][j] == 1) Game.button[i][j].setIcon(new ImageIcon("src\\o.png"));
					if(Game.save[i][j] == 2) Game.button[i][j].setIcon(new ImageIcon("src\\x.png"));
				}
				
				
				btnPan.add(Game.button[i][j]);
			}
			posX = 45;
			posY += Game.size[idx];
			
		}
		
		btnPan.setBackground(Color.black);
		
		
		f.setLocationRelativeTo(null);
		f.add(btnPan);
		
		JLabel winner = null;
		
		// winner label e je player win hoiche tar logo thakbe na hole draw er logo thakbe
		
		if(playerID == 0) winner = new JLabel(new ImageIcon("src\\draw.png"));
		if(playerID == 1) winner = new JLabel(new ImageIcon("src\\p1.png"));
		if(playerID == 2) winner = new JLabel(new ImageIcon("src\\p2.png"));
		
		winner.setBackground(Color.yellow);
		winner.setBounds(0, frameWidth - 80 + 50, frameWidth, 50);
		
		
		f.add(winner);
		
		f.setVisible(true);
	}
}
