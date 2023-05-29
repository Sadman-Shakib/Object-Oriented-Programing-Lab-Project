import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sadman_sakib
 * 
 */

public class MainWindow extends JFrame implements ActionListener {
	
	static int idx = 0;   // level er index
	static int n = 3;     // grid size 
	static JPanel buttonPanel;  // home level about exit button gula ei button pannel e add korbo
	static JPanel panel;        
	static JPanel bottomPanel; // ei panel kichu text add korbo
	static JLabel ban;
	static JButton [] btn = new JButton[5];  // home level about exit and play 5 ta button er array
	static String adrs [] = new String[5];  // button gular image load korar jnno file path er string array
	static int [] posX = new int[5];          // button gular X axis er position store korbo
	static int [] posY = new int[5];          // button gular Y axis er position store korbo
	static final int frameHeight = 370;
	static final int frameWidth = 460;
	static final int btnHeight = 40;
	static final int btnWidth = 160;
	static JLabel str;  // ei level e text add korbo and text JPanel ta te eta add kore dibo
	static JPanel text;
	
	void addPlayButton() {
		// ei method er vitor Play button add korar implementation
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBounds(0, 200, frameWidth, 100);
		bottomPanel.setBackground(Color.black);
		btn[4].setIcon(new ImageIcon(adrs[4]));
		

		// button gular border gula invisible kore dichi ekhane
		btn[4].setBorderPainted(false);
		btn[4].setBorder(null);
		btn[4].setContentAreaFilled(false);
		
		btn[4].addActionListener(this);
		bottomPanel.add(btn[4]);
		add(bottomPanel);
	}
	
	
	void printText() {
		// ei panel e copyright er text ta add korbo JLabel use korbo text print korar jnno
		text = new JPanel();
		text.setBackground(Color.black);
		text.setBounds(0, 300, frameWidth, 60);
		
		str = new JLabel("TicTacToe (C) Sadman Sakib - All Right Reserved");  // bottom text
		str.setFont(new Font("monaco", Font.PLAIN, 14));  // font set korchi bottom panel er
		str.setForeground(Color.white);
		str.setHorizontalAlignment(JLabel.CENTER);
		str.setVerticalAlignment(JLabel.CENTER);
		text.add(str);
		add(text);
	}
	
	void initButtonAdrs() {
		// ekhane home page e joto gula image button icon thakbe sob gular position, icon set kora hoiche
		adrs[0] = "src\\home.png";		posX[0] = 20;			posY[0] = 10;
		adrs[1] = "src\\lavels.png";	posX[1] = 70 + 200;		posY[1] = 10;
		adrs[2] = "src\\about.png";		posX[2] = 20;			posY[2] = 50;
		adrs[3] = "src\\exit.png";		posX[3] = 70 + 200;		posY[3] = 50;
		adrs[4] = "src\\play.png";		//posX[4] = 0;			posY[4] = 0;
		
		for(int i = 0; i < 4; i++) {

			// n * n gula button create kore buttonPanel er sathe add kore dibo
			btn[i] = new JButton();
			
			
			btn[i].setBorderPainted(false);
			btn[i].setBorder(null);
			btn[i].setContentAreaFilled(false);
			
			btn[i].setBounds(posX[i], posY[i], btnWidth, btnHeight);
			btn[i].setIcon(new ImageIcon(adrs[i]));
			btn[i].addActionListener(this);
			buttonPanel.add(btn[i]);
			
		}
		
	}
	
	void basicFrame() {
		// JFrame create korbo
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setTitle("TicTacToe");
        setResizable(false);
        getContentPane().setBackground(Color.yellow);        
        setIconImage(new ImageIcon("src\\mainlogo.png").getImage()); 
        setLayout(null);
	}
	
	
	void imagePanel() {
		// ei image pannel tictactoe icon set korbo
        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, frameWidth, 100);
        add(panel);
	}
	
	void printBanner() {
		// tictactoe icon ta set korbo imagePanel e
        JLabel ban = new JLabel(new ImageIcon("src\\banner.gif"));
        panel.add(ban);
	}
	
	
	void setAllButton() {
		// Button Panel and button gular object create korbo
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black);
        buttonPanel.setBounds(0, 100, frameWidth, 100);
        buttonPanel.setLayout(null);
        
        for(int i = 0; i < 5; i++) {
        	btn[i] = new JButton();  // button er object banaichi ekahne
        }
        
        
        add(buttonPanel); // button panel t frame er sathe add korbo
	}
	
	public MainWindow() {
		
		
		basicFrame();
        
        imagePanel();
        
        printBanner();
        
        
        setAllButton();
        
        initButtonAdrs();
        
        addPlayButton();
        
        printText();
        
        setVisible(true);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn[0]) {
			// btn[0] ta holo about button
			setVisible(false); // jFrame ta invisible kore dibo karon amr warning window open hobe
			warning w = new warning(); // warning window create hbe karon home ei achi
		}
		
		if(e.getSource() == btn[1]) {
			// btn[1] ta holo level button
			setVisible(false); // new window open hbe tai jframe invisible hbe
			lavel sel  = new lavel(); // level select korar jnno level window open hbe
		} 
		
		if(e.getSource() == btn[2]) {
			setVisible(false);
			about a = new about();
		}
		
		if(e.getSource() == btn[3]) {
			// exit button tai only jframe ta invisible kore dibo
			setVisible(false);
		}
		
		if(e.getSource() == btn[4]) {

			// game start korar jnno play button
			setVisible(false);
			Game start = new Game(n, idx); // eta call korle game start hoye jabe
			// default vabe level 1 ache but manually level select korle sei level ei game strt hbe

		}


	}
    
}
