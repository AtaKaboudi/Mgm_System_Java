import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class GUI {
	static Color primaryColor ;
	static Color fontColor1;
	static JFrame frame;
	static JPanel panel;
	static JLabel label ;
	public static void main(String[] args) {
		primaryColor = new Color(17,34,51);
		fontColor1 =  Color.WHITE;
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel("Managment System");
		JButton btnTeam = new JButton("Team");
		JButton btnStaff = new JButton("Staff");
		JButton btnSeason = new JButton("Season");
		setStyle(btnTeam);
		setStyle(btnStaff);
		setStyle(btnSeason);
		panel.add(label);
		panel.add(btnTeam);
		panel.add(btnStaff);
		panel.add(btnSeason);

		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(2,3));
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MGM SYSTEM");
		frame.pack();
		frame.setVisible(true);	
	}
	
	public static void setStyle (JButton button) {
		button.setBackground(primaryColor = new Color(17,34,51));
		button.setForeground(fontColor1);
		button.setBorder(BorderFactory.createMatteBorder(50, 50, 50, 50,primaryColor));

	}


	
}