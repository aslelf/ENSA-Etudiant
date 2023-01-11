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

public class apogee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					apogee frame = new apogee();
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
	public apogee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(160, 100,1020, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		getContentPane();
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 60, 213, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//creation de label
		JLabel lblNewLabel = new JLabel("BIENVENUE");
		lblNewLabel.setBounds(29, 120, 184, 27);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.black);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Historique");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				historique ff = new historique(); 
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(29, 391, 137, 23);
		panel.add(btnNewButton);
		
		
	
	JButton edition = new JButton("édition des étudiants");
	edition.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			EditionEtudiant ff = new EditionEtudiant(); 
		}
	});
	
	edition.setFont(new Font("Times New Roman", Font.BOLD, 25));
	edition.setBounds(487, 224, 277, 33);
	edition.setFocusPainted(false);
	edition.setBackground(new Color	(253,245,230));
	contentPane.add(edition);
	

	JButton liste = new JButton("les listes des étudiants");
	liste.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			listes_etudiants ff = new listes_etudiants(); 
		}
	});
	liste.setFont(new Font("Times New Roman", Font.BOLD, 25));
	liste.setBounds(265, 460, 277, 33);
	liste.setFocusPainted(false);
	liste.setBackground(new Color(253,245,230));
	contentPane.add(liste);
	
	JButton filiere = new JButton("les filiéres");
	filiere.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			menu_filiere ff = new menu_filiere(); 
		}
	});
	filiere.setFont(new Font("Times New Roman", Font.BOLD, 25));
	filiere.setBounds(702, 460, 280, 33);
	filiere.setFocusPainted(false);
	filiere.setBackground(new Color(253,245,230));
	contentPane.add(filiere);

	JLabel image = new JLabel("");
	image.setIcon(new ImageIcon(apogee.class.getResource("/image/choix.png")));
	image.setBounds(752, 268, 230, 190);
	contentPane.add(image);
	
	JLabel img = new JLabel("");
	img.setIcon(new ImageIcon(apogee.class.getResource("/image/listes.png")));
	img.setBounds(318, 268, 147, 190);
	contentPane.add(img);
	
	
	JLabel mg = new JLabel("");
	mg.setBounds(565, 60, 177, 161);
	contentPane.add(mg);
	mg.setIcon(new ImageIcon(apogee.class.getResource("/image/edition2.png")));
	
	JMenuBar myMenuBar=new JMenuBar();
	myMenuBar.setBackground(new Color(173, 216, 230));
	myMenuBar.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.add(myMenuBar);
	myMenuBar.setBounds(0, 0, 1020, 60);
	setVisible(true);
	setVisible(true);
	
	
	JMenu menuFichier3 = new JMenu("");
	menuFichier3.setIcon(new ImageIcon(apogee.class.getResource("/image/icons8-menu-2-48.png")));
	menuFichier3.setForeground(Color.WHITE);
	myMenuBar.add(menuFichier3);
	
	
	JLabel lblNewLabel_0 = new JLabel("Admin apogée");
	myMenuBar.add(lblNewLabel_0);
	
	lblNewLabel_0.setFont(new Font("Tahoma", Font.BOLD, 22));
	lblNewLabel_0.setForeground(Color.black);
	setVisible(true);
	
	JMenuItem menuQuitter = new JMenuItem("Déconnexion"); 
	
	
	menuFichier3.add(menuQuitter);
	
	
	
	menuQuitter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			login y=new login();
		}
	});
	}

}
