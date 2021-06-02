import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame  = new JFrame();
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
			}
		});
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {313, 300, 300, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {229, 205, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnTeam = new JButton("Team");
		GridBagConstraints gbc_btnTeam = new GridBagConstraints();
		gbc_btnTeam.fill = GridBagConstraints.BOTH;
		gbc_btnTeam.insets = new Insets(0, 0, 5, 5);
		gbc_btnTeam.gridx = 0;
		gbc_btnTeam.gridy = 0;
		frame.getContentPane().add(btnTeam, gbc_btnTeam);
		
		JButton btnGame = new JButton("Game");
		GridBagConstraints gbc_btnGame = new GridBagConstraints();
		gbc_btnGame.fill = GridBagConstraints.BOTH;
		gbc_btnGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnGame.gridx = 1;
		gbc_btnGame.gridy = 0;
		frame.getContentPane().add(btnGame, gbc_btnGame);
		
		JButton btnStaff = new JButton("Staff");
		GridBagConstraints gbc_btnStaff = new GridBagConstraints();
		gbc_btnStaff.fill = GridBagConstraints.BOTH;
		gbc_btnStaff.insets = new Insets(0, 0, 5, 5);
		gbc_btnStaff.gridx = 0;
		gbc_btnStaff.gridy = 1;
		frame.getContentPane().add(btnStaff, gbc_btnStaff);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
