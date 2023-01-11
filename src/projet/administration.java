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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class administration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administration frame = new administration();
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
	public administration() {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(160, 100,1020, 550);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(null);
			contentPane.setBackground(Color.WHITE);
			getContentPane();
			setVisible(true);
			
			
			
			// La barre de Menu 
			
			JMenuBar myMenuBar=new JMenuBar();
			myMenuBar.setBackground(new Color(173, 216, 230));
			myMenuBar.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.add(myMenuBar);
			myMenuBar.setBounds(0, 0, 1004, 60);
			setVisible(true);
			setVisible(true);
			
			JMenu menuFichier3 = new JMenu("");
			menuFichier3.setIcon(new ImageIcon(administration.class.getResource("/image/icons8-menu-2-48.png")));
			menuFichier3.setForeground(Color.WHITE);
			myMenuBar.add(menuFichier3);
			setVisible(true);
			
			JMenuItem menuaceuil = new JMenuItem("Retour ");
			
			

			
			menuFichier3.add(menuaceuil);
			
				JLabel lblNewLabel = new JLabel("Administration");
				myMenuBar.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
			
			
			menuaceuil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					acceuil y=new acceuil();
				}
			});
			
			
			
		
			JButton sll = new JButton("Admin de Systéme");
			sll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					login_admin_systeme ff = new login_admin_systeme(); 
				}
			});
			sll.setFont(new Font("Times New Roman", Font.BOLD, 25));
			sll.setBounds(283, 242, 250, 33);
			sll.setFocusPainted(false);
			sll.setBackground(new Color(173, 216, 230));
			contentPane.add(sll);
		
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(173, 216, 230));
			panel.setBounds(0, 60, 213, 460);
			contentPane.add(panel);
			panel.setLayout(null);
			
			//creation de label
			JLabel lblNewLabel_6 = new JLabel("BIENVENUE");
			lblNewLabel_6.setBounds(29, 120, 184, 27);
			
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblNewLabel_6.setForeground(Color.black);
			panel.add(lblNewLabel_6);
			
		JButton prof = new JButton("Admin Apogée");
		prof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login ff = new login (); 
			}
		});
		prof.setFont(new Font("Times New Roman", Font.BOLD, 25));
		prof.setBounds(283, 467, 250, 33);
		prof.setFocusPainted(false);
		prof.setBackground(new Color(173, 216, 230));
		contentPane.add(prof);
		
		
		JButton mod = new JButton("Admin de Scolarité");
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login_scolarité ff = new login_scolarité(); 
			}
		});
		mod.setFont(new Font("Times New Roman", Font.BOLD, 25));
		mod.setBounds(660, 242, 280, 33);
		mod.setFocusPainted(false);
		mod.setBackground(new Color(173, 216, 230));
		contentPane.add(mod);
		
		JButton exm = new JButton("Directeur");
		exm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login_directeur ff = new login_directeur(); 
			}
		});
		exm.setFont(new Font("Times New Roman", Font.BOLD, 25));
		exm.setBounds(660, 467, 280, 33);
		exm.setFocusPainted(false);
		exm.setBackground(new Color(173, 216, 230));
		contentPane.add(exm);

		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(administration.class.getResource("/image/directeur.png")));
		image.setBounds(719, 275, 230, 190);
		contentPane.add(image);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(administration.class.getResource("/image/admin.png")));
		img.setBounds(306, 286, 241, 190);
		contentPane.add(img);
		
		JLabel mg = new JLabel("");
		mg.setBounds(317, 71, 200, 160);
		contentPane.add(mg);
		mg.setIcon(new ImageIcon(administration.class.getResource("/image/admin2.png")));
		
		
		JLabel g = new JLabel("");
		g.setBounds(719, 76, 130, 143);
		contentPane.add(g);
		g.setIcon(new ImageIcon(administration.class.getResource("/image/admin1.png")));
		
	
		

}}
