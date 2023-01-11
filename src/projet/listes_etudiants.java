package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;



public class listes_etudiants extends JFrame {

	private JPanel contentPane;
	String[][] data;
	JTable tab;
	String code_apoge ;
	String nom ;
	String prenom ;
	//String type_doc ;
	String id_demande;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listes_etudiants frame = new listes_etudiants();
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
	public listes_etudiants() {
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
			menuFichier3.setIcon(new ImageIcon(listes_etudiants.class.getResource("/image/icons8-menu-2-48.png")));
			menuFichier3.setForeground(Color.WHITE);
			myMenuBar.add(menuFichier3);
			setVisible(true);
			
			JMenuItem menuQuitter = new JMenuItem("Déconnexion"); 
			JMenuItem menuaceuil = new JMenuItem("Retour ");
			
			

			menuFichier3.add(menuQuitter);
			menuFichier3.add(menuaceuil);
			
			JLabel lblNewLabel_11 = new JLabel("les listes des étudiants");
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
		btnNewButton.setBounds(311, 270, 330, 31);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setForeground(Color.black);
		btnNewButton.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				listes_info i =new listes_info(); 
			}
		});
		
		JButton btnNewButton_1 = new JButton("Supply chain management");
		btnNewButton_1.setBounds(311, 312, 330, 31);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.black);
		btnNewButton_1.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				listes_scm i =new listes_scm(); 
			}
		});
		
		JButton btnNewButton_2 = new JButton("Génie mécatronique");
		btnNewButton_2.setBounds(311, 354, 330, 31);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setForeground(Color.black);
		btnNewButton_2.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				listes_mec i =new listes_mec(); 
			}
		});;
		
		JButton btnNewButton_3 = new JButton("Génie des Systèmes des Télécommunications et Réseaux");
		btnNewButton_3.setBounds(311, 396, 330, 31);
		
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_3.setForeground(Color.black);
		btnNewButton_3.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				listes_gstr i =new listes_gstr(); 
			}
		});
		
		JButton btnNewButton_4 = new JButton("Génie civil");
		btnNewButton_4.setBounds(311, 438, 330, 31);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setForeground(Color.black);
		btnNewButton_4.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				listes_civil i =new listes_civil(); 
			}
		});
		
		JButton btnNewButton_5 = new JButton(" 1ère année de cycle préparatoire");
		btnNewButton_5.setBounds(311, 185, 330, 31);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_5.setForeground(Color.black);
		btnNewButton_5.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CP1 i =new CP1(); 
			}
		});
		
		JButton btnNewButton_6 = new JButton(" 2ère année de cycle préparatoire");
		btnNewButton_6.setBounds(311, 228, 330, 31);
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_6.setForeground(Color.black);
		btnNewButton_6.setBackground(new Color(173, 216, 230));
		contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CP2 i =new CP2(); 
			}
		});
		

		

		
	}

}
