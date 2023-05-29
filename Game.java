import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.JSplitPane.TOP;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Game implements ActionListener{
	
	int panWidth;   
	int frameWidth;
	int frameHeight;
	int idx = 0;
	int playerId = 1;

	static int n;
	static int [][] save;

	
	static JFrame f;
	String [] levelIcon = new String[6];
	static int [] size = new int[6];
	static JButton [][] button;
	JLabel turn1;
	JLabel turn2;
	static Color [] colors = new Color[6];
	int totalTurn = 0;
	JPanel btnPan;
	
	void initAdrs() {
		// ei method e level er icon and gula button er size gula ar level wise border color set kora hoiche

		// level er icon
		levelIcon[0] = "src\\d1.png"; 		levelIcon[1] = "src\\d2.png"; 		
		levelIcon[2] = "src\\d3.png";       levelIcon[3] = "src\\d4.png";
		levelIcon[4] = "src\\d5.png"; 	    levelIcon[5] = "src\\d5.png";
		
		// button er size level wise set kora hoiche
		size[0] = 80;		size[1] = 80;		size[2] = 80;		size[3] = 80;
		size[4] = 60;		size[5] = 60;	
		
		// level wise button er border color different hbe 
		colors[0] = Color.lightGray;	colors[1] = Color.green;
		colors[2] = Color.red;			colors[3] = Color.orange;
		colors[4] = Color.blue;			colors[5] = Color.white;
		
		
	}
	
	
	
	public Game(int n, int idx) {
		
		button  = new JButton[n][n];      // game start korar jnno amr n X n er grid lagbe
		initAdrs();                       // icon buton er size and colors gula initilize korar jnnno
		save = new int[n][n];             /*button gula pressed kina or press korleo kon player 
											press korche setar record rakhbo ekhane */
		this.n = n;            // grid er size ta method argument theke nilam
		totalTurn = n * n;     // amr total turn hbe n X n. karon amr button er count holo n * n
		this.idx = idx;        // kon level e game start hbe setar index

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				save[i][j] = 0;            /* sob gular button state 0 kore dilam 
											karon sob gula unpressed */
			}
		}

		
		int btnSize = size[idx];      // level wise button er size alada hbe tai seta size array theke nibo
		int panWidth = n * btnSize;
		int panHeight = panWidth + 200;  
		int btnHeight, btnWidth;
		btnHeight = btnWidth = btnSize;
		
		int bannerHeight = 60;
		
		frameWidth = panWidth + 100;
		frameHeight = panHeight + 22;
		
		f = new JFrame("TicTacToe || Game Window");
		f.setLayout(null);
		f.setSize(frameWidth, frameHeight);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(new ImageIcon("src\\mainlogo.png").getImage());
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.black);
		
		
		JLabel banner = new JLabel(new ImageIcon(levelIcon[idx]));  // kon level e game ache setar icon
		banner.setBounds(0, 0, frameWidth, bannerHeight);
		bannerHeight += 5;
		JPanel turnPanel = new JPanel();                         // ei panel e player turn thakbe
		turnPanel.setBounds(0, bannerHeight, frameWidth, 60);
		turnPanel.setBackground(Color.black);
		bannerHeight += 65;
		turnPanel.setLayout(null);
		
		// prottek ta turn er por player change hbe tai kon player er turn setar icon ekhane set korbo
		turn1 = new JLabel(new ImageIcon("src\\p1.png"));      // player 1 er ture er somoy eta print hbe
		turn1.setBounds(0, 0, 100, 50);
		turnPanel.add(turn1);
		
		turn2 = new JLabel(new ImageIcon("src\\p2.png"));      // player 1 er ture er somoy eta print hbe
		turn2.setBounds(frameWidth - 120, 0, 100, 50);
		turn2.setVisible(false);                      // first e player 1 khela strt korbe tai 2nd player invisible thakbe
		
		turnPanel.add(turn2);
		
		f.add(turnPanel);        
		f.add(banner);
		
		btnPan = new JPanel();                                   // ei panel e main button gula thakbe
		btnPan.setBounds(45, bannerHeight, panWidth, panWidth);
		btnPan.setBackground(Color.black);
		btnPan.setLayout(null);
		
		
		int posX = 0, posY = 0;
		Border border = BorderFactory.createLineBorder(colors[idx], 1); // button er line border 

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++, posX += size[idx]) {
				// ekhane n X n ta button add kora hoiche
				button[i][j] = new JButton();
				button[i][j].setBounds(posX, posY, size[idx], size[idx]);
				button[i][j].setBorder(border);
				button[i][j].addActionListener(this);
				button[i][j].setBorder(border);
				button[i][j].setContentAreaFilled(false);
				btnPan.add(button[i][j]);
			}
			posX = 0;  // panel er ekabre bam theke button add hte thakbe tai x axis = 0
			posY += size[idx];  // button gula ektar nice ekta thakbe tai posY += size[idx]
		}
		
		f.add(btnPan);
		// game cmplt na korei home ba exit korte caile ei control class er obj use korbo
		f.add(new control(0, panWidth + bannerHeight + 5,frameWidth, 50, 2).getControlButton());
		
		
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(e.getSource() == button[i][j] && save[i][j] == 0) {

					/* jdi kono player button e press kore taile kon player
					kon button e press korche setar record save[i][j] te save kore rakhbo 
					and player change korbo, turn o 1 kore komabo */

					save[i][j] = playerId;
					totalTurn--;

					if(playerId == 1) {
						playerId++;      			// player 1 press korche
						turn1.setVisible(false);
						turn2.setVisible(true);
						button[i][j].setIcon(new ImageIcon("src\\o.png"));  /* player 1 er icon O tai
																			icon O set kore dichi */
					}

					else {
						playerId--;   			//  player 2 press korche
						turn1.setVisible(true);
						turn2.setVisible(false);
						button[i][j].setIcon(new ImageIcon("src\\x.png"));   /* player 2 er icon X tai
																			icon X set kore dichi */
					}
					
					int ans = isGameOver();  /*kono ekta button press over por kew ekjon win hote pare
												or game draw hote pare taie isGameOver() ei method diye
												cheak korbo game continue kora jabe kina */ 
					
					if(ans == 1 || ans == 2) {   
					// jdi isGameOver 1 or 2 return kore taile winner player 1  or player 2
						f.dispose();   
						// winner peye gele game window close hbe and gameOver Window open hbe
						GameOver over = new GameOver(n, frameWidth, frameHeight, ans, idx);
					}
					
					if(totalTurn == 0) {
						f.dispose();
						// total tuirn left houya mane game draw karon kew ekjn winner hole agei gameOver window open hoye jeto
						GameOver over = new GameOver(n, frameWidth, frameHeight, 0, idx);					}
					
					
				}
			}
		}
		
	}
	
	
	
	
	int isGameOver() {
		
		// prottek ta row cheak korbo
		for(int i = 0; i < n; i++) {
			boolean found = true;
			for(int j = 0; j < n; j++) {
				if(save[i][j] == 0) found = false;
				if(j > 0 && save[i][j-1] != save[i][j]) found = false;
			}
			if(found) {
				GameOver.flag = "rowWin";    /*ekhane GameOver.flag e record save kore rakhbo
												je player ki row wise win hoiche kina */
				GameOver.index = i;          // level ta save kore rakhbo
				return save[i][0];       // kon player win hoiche tar id 1 / 2 return korbe
			}

			/* ekhane gamePlay er somoy data gula save rakha lagbe karon GameOver Window ta amr 
			dekhano lagbe je Win ke kivabe hoiche . tai egula GameOver class er static variable e save rakhbo*/

		}
		
		// prottek ta collum cheak korbo
		for(int i = 0; i < n; i++) {
			boolean found = true;
			for(int j = 0; j < n; j++) {
				if(save[j][i] == 0) found = false;
				if(j > 0 && save[j-1][i] != save[j][i]) found = false;
			}
			if(found) {
				GameOver.flag = "collumWin";   // kew ekjon collum wise win hoiche
				GameOver.index = i;
				return save[0][i];   // winner player id return korbe
			}
		}
		
		// main diagonal cheak korbo
		boolean found = true;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					if(save[i][j] == 0) found = false;
					if(i > 0 && j > 0 && save[i-1][j-1] != save[i][j]) found = false;
				}
			}
		}
		if(found) {
			GameOver.flag = "mainDigWin";
			return save[0][0];
		}
		
		
		// secondery diagonal cheak korbo
		found = true;
		for(int i = 0, rightIndex = n - 1; i < n; i++, rightIndex--) {
			if(save[i][rightIndex] == 0) found = false;
			if(i > 0 && rightIndex != n - 1 && save[i-1][rightIndex+ 1] != save[i][rightIndex]) found = false;
		}
		
		if(found) {
			GameOver.flag = "secondDigWin";
			return save[0][n - 1];
		}
		return 0;
	}
	
	
}
