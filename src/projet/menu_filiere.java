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

public class menu_filiere extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_filiere frame = new menu_filiere();
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
	public menu_filiere() {
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
			menuFichier3.setIcon(new ImageIcon(menu_filiere.class.getResource("/image/icons8-menu-2-48.png")));
			menuFichier3.setForeground(Color.WHITE);
			myMenuBar.add(menuFichier3);
			setVisible(true);
			
			JMenuItem menuQuitter = new JMenuItem("Déconnexion"); 
			JMenuItem menuaceuil = new JMenuItem("Retour ");
			
			

			menuFichier3.add(menuQuitter);
			menuFichier3.add(menuaceuil);
			
			JLabel lblNewLabel_11 = new JLabel("les filières");
			myMenuBar.add(lblNewLabel_11);
			lblNewLabel_11.setForeground(new Color(0,0,0));
			lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 25));
			
			
			menuaceuil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					apogee y=new apogee();
				}
			});
			
		
		JButton btnNewButton = new JButton("Génie informatique");
		btnNewButton.setBounds(311, 213, 398, 31);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setForeground(Color.black);
		btnNewButton.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				filere_info i =new filere_info(); 
			}
		});
		
		JButton btnNewButton_1 = new JButton("Supply chain management");
		btnNewButton_1.setBounds(311, 274, 398, 31);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.black);
		btnNewButton_1.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				filiere_scm i =new filiere_scm(); 
			}
		});
		
		JButton btnNewButton_2 = new JButton("Génie mécatronique");
		btnNewButton_2.setBounds(311, 327, 398, 31);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setForeground(Color.black);
		btnNewButton_2.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				filiere_gm i =new filiere_gm(); 
			}
		});;
		
		JButton btnNewButton_3 = new JButton("Génie des Systèmes des Télécommunications et Réseaux");
		btnNewButton_3.setBounds(311, 381, 398, 31);
		
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_3.setForeground(Color.black);
		btnNewButton_3.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				filiere_gstr i =new filiere_gstr(); 
			}
		});
		
		JButton btnNewButton_4 = new JButton("Génie civil");
		btnNewButton_4.setBounds(311, 438, 398, 31);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setForeground(Color.black);
		btnNewButton_4.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				filiere_gc i =new filiere_gc(); 
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Choisissez la fili\u00E8re");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(335, 94, 453, 31);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1);
		

		
	}

}
