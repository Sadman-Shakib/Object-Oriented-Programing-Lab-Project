import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class lavel implements ActionListener{
	
	// 350, 400
	int height = 350, width = 400; // level window er frame er height and width
	static JFrame f;
	static String [] btnAdrs = new String[6];  // 6 ta level button er image er filepath load korbo ei array te
	int [] btnPosX = new int[6];                  // 6 ta button er X axis er position
	int [] btnPosY = new int[6];				  // 6 ta button er Y axis er position
	static JButton [] level;                      // 6 ta level button create korbo constuctor er vitor e
	static JPanel banPan = new JPanel();
	
	void initLevelButton() {
		// Level er button gular jnno icon and Position set korbo ekhane
		btnAdrs[0] = "src\\l1.png";		btnPosX[0] = 50;		btnPosY[0] = 10;
		btnAdrs[1] = "src\\l2.png";		btnPosX[1] = 150;		btnPosY[1] = 10;
		btnAdrs[2] = "src\\l3.png";		btnPosX[2] = 250;		btnPosY[2] = 10;
		btnAdrs[3] = "src\\l4.png";		btnPosX[3] = 50;		btnPosY[3] = 110;
		btnAdrs[4] = "src\\l5.png";		btnPosX[4] = 150;		btnPosY[4] = 110;
		btnAdrs[5] = "src\\l6.png";		btnPosX[5] = 250;		btnPosY[5] = 110;
	}
	 
	public lavel() {
		// level window er basic frame
		f  = new JFrame("Select Levels");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(width, height);
		f.setResizable(false);
		f.setIconImage(new ImageIcon("src\\mainlogo.png").getImage());
		f.getContentPane().setBackground(Color.yellow);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		
		// level icon print korar jnno jlabel create korchi
		JLabel print = new JLabel(new ImageIcon("src\\lavels.png"));
		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(0, 0, width, 40);
		firstPanel.setBackground(Color.black);
		firstPanel.add(print);

		// ei panel e sobgula level er button add korbo ar ei panel ta frame er sathe add korbo
		JPanel buttonPan = new JPanel();
		buttonPan.setBounds(0, 40, width, 220);
		buttonPan.setBackground(Color.black);
		buttonPan.setLayout(null);


		initLevelButton();   // level button gula add korar age amr button gular image and object gula lagbe so age age funtion ta call kore nichi


		level = new JButton[6];  // 6 ta level button lagbe tai 6 ta button er array banalam


		
		for(int i = 0; i < 6; i++) {
			// ei loop er vitor e 
			level[i] = new JButton(); // ever button er jnno object gula banaichi ekahne karon ager ta array chilo
			level[i].setBounds(btnPosX[i], btnPosY[i], 100, 100);
			level[i].setIcon(new ImageIcon(btnAdrs[i]));
			level[i].setBorderPainted(false);
			level[i].setBorder(null);
			level[i].setContentAreaFilled(false); 
			level[i].addActionListener(this);

			buttonPan.add(level[i]);   // button gula ta buttonPan er sathe attach korchi
		}
		
		f.add(new control(0, 260, width, 60, 1).getControlButton());  // frame theke exit korar jnno nijer banano class ta use korbo
		
		
		f.add(buttonPan);  // buttonPan ta frame er sathe attach korlam
		f.add(firstPanel);   // level icon er panel ta frame er sathe attach korchi
		
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 6; i++) {
			if(e.getSource() == level[i]) {
				// jdi kono level button press hoy
				MainWindow.n = i + 3;  // amr level start hbe 1 the and first level er grid size 3 tai i + 3 korchi
				MainWindow.idx = i;    // koto number level user select korche setar record ekahne save kore rakhlam 
				f.dispose();  // level select kora ses tai dispose kore dilam 
				new MainWindow().setVisible(true); // home page e back korar jnno

				// amar jkhn game start hbe tkhn level and gridSize lagbe tai egula initilize kore rakhchi ekhane
			}
		}
	}
}
