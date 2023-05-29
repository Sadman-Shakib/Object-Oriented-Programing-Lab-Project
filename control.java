import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class control implements ActionListener{

	// Ei class  just ekta Pannel return korbe jetate home and exit button thakbe only
	// and amr jno home e and exit korar jnno bar bar new code na likha lage tai ekta class baniye rakhlam
	// jkhn home and exit e abar jnno code likha lagbe tkhn just ei class tar object baniye getContr.... call korbo
	
	JPanel pan = new JPanel();
	JButton exit = new JButton();
	JButton home = new JButton();
	int index = 0;
	
	public control(int x, int y, int width, int height, int index) { 

		/* 
			x and y holo panel add er position 
			width and height holo panel er height and width and index holo kon frame theke call kora hoiche
			frame er index korar karon holo amr exactly oi frame tai close kora lagbe jekhan theke ei control 
			class er object ta call kora hoiche
		*/
	
		this.index = index;
		pan.setBounds(x, y, width, height);
		pan.setBackground(Color.black);
		pan.setLayout(new FlowLayout());
		
		home.setIcon(new ImageIcon("src\\home.png")); // home button logo set korchi
		exit.setIcon(new ImageIcon("src\\exit.png"));  // exit button er logo set korchi
		
		home.setBorder(null);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		
		exit.setBorder(null);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		
		home.addActionListener(this);
		exit.addActionListener(this);
		
		pan.add(home);  // home button panel e add korchi
		pan.add(exit);   // exit button ta panel e add korchi

		// ekhn just ei class ta diye home and exit kora jabe
		
	}
	
	JPanel getControlButton() {
		return pan;  // control button er panel ta return kore dibo .. ei panel tai specific kono frame e add hbe
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == home) {
			new MainWindow().setVisible(true);  // home button press hoiche so age home page er frame ta visible korbo
			if(index == 1) lavel.f.dispose();  // jdi level frame theke call hoy taile level window close hbe
			if(index == 2) Game.f.dispose();   // jdi game frame theke call hoy taile game window close hbe
			if(index == 3) GameOver.f.dispose();   // jdi gameover frame theke call hoy taile gameover window close hbe
			if(index == 4) about.f.dispose();
		
		} else if(e.getSource() == exit) {
			// ekane exit button press hoiche so sobgula frame e invisible hbe 
			// tai sudhu jei frame theke exit call hoiche sei frame ta off kore debo
			if(index == 1) lavel.f.dispose();
			if(index == 2) Game.f.dispose();
			if(index == 3) GameOver.f.dispose();
			if(index == 4) about.f.dispose();
		}
	}
}
