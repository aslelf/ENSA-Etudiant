package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class listes_scm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listes_scm frame = new listes_scm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public listes_scm() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(160, 100,1020, 550);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(null);
			contentPane.setBackground(Color.WHITE);
			getContentPane();
			setVisible(true);
			
			JMenuBar myMenuBar=new JMenuBar();
			myMenuBar.setBackground(new Color(173, 216, 230));
			myMenuBar.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.add(myMenuBar);
			myMenuBar.setBounds(0, 0, 1004, 60);
			setVisible(true);
			setVisible(true);
			
			
			JMenu menuFichier3 = new JMenu("");
			menuFichier3.setIcon(new ImageIcon(listes_scm.class.getResource("/image/icons8-menu-2-48.png")));
			menuFichier3.setForeground(Color.WHITE);
			myMenuBar.add(menuFichier3);
			setVisible(true);
			
			JMenuItem menuQuitter = new JMenuItem("Déconnexion"); 
			JMenuItem menuaceuil = new JMenuItem("Retour ");
			
			

			menuFichier3.add(menuQuitter);
			menuFichier3.add(menuaceuil);
			
			JLabel lblNewLabel_11 = new JLabel("supply chain management");
			myMenuBar.add(lblNewLabel_11);
			lblNewLabel_11.setForeground(new Color(0,0,0));
			lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 25));
			
			
			menuaceuil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					apogee y=new apogee();
				}
			});
			
			
			menuQuitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					listes_etudiants y=new listes_etudiants();
				}
			});
			
		
		JButton btnNewButton = new JButton("première année");
		btnNewButton.setBounds(311, 270, 330, 31);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setForeground(Color.black);
		btnNewButton.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SCM i =new SCM(); 
			}
		});
		
		JButton btnNewButton_1 = new JButton("deusième année");
		btnNewButton_1.setBounds(311, 312, 330, 31);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.black);
		btnNewButton_1.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SCM2 i =new SCM2(); 
			}
		});
		
		JButton btnNewButton_2 = new JButton("troisième année");
		btnNewButton_2.setBounds(311, 354, 330, 31);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setForeground(Color.black);
		btnNewButton_2.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SCM3 i =new SCM3(); 
			}
			});
	}

}
